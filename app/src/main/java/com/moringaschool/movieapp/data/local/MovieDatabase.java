package com.moringaschool.movieapp.data.local;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


import com.moringaschool.movieapp.model.movie.MovieResults;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author moringa
 */
@Database(entities = {MovieResults.class}, version = 1)
public abstract class MovieDatabase extends RoomDatabase {
    public static volatile com.moringaschool.movieapp.data.local.MovieDatabase INSTANCE;

    public abstract MovieDao movieDao();

    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(1);

    public static com.moringaschool.movieapp.data.local.MovieDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (com.moringaschool.movieapp.data.local.MovieDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            com.moringaschool.movieapp.data.local.MovieDatabase.class,
                            "movies.db").build();
                }
            }
        }
        return INSTANCE;
    }
}
