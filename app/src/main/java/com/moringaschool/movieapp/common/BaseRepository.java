package com.moringaschool.movieapp.common;


import com.moringaschool.movieapp.backend.ApiClient;
import com.moringaschool.movieapp.backend.ApiService;

public class BaseRepository {
    public ApiService apiService;

    public BaseRepository() {
        apiService = ApiClient.getClient();
    }
}
