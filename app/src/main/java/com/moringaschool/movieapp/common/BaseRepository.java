package com.moringaschool.movieapp.common;


import com.moringaschool.movieapp.data.remote.ApiClient;
import com.moringaschool.movieapp.data.remote.ApiService;

/**
 * @author moringa
 */
public class BaseRepository {
    public ApiService apiService;

    public BaseRepository() {
        apiService = ApiClient.getClient();
    }
}
