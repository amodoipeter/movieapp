package com.moringaschool.movieapp.data.local;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;


import com.moringaschool.movieapp.model.movie.MovieResults;

import java.util.List;

/**
 * @author moringa
 */
@Dao
public interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void InsertMovie(MovieResults movie);

    @Delete
    void DeleteMovie(MovieResults movie);

    @Query("SELECT * FROM movies")
    LiveData<List<MovieResults>> getAllMovies();

    @Query("SELECT * FROM movies WHERE movieId= :movieId")
    LiveData<MovieResults> getSingleMovie(int movieId);
}
