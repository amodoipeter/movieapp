package com.moringaschool.movieapp.common;


import com.moringaschool.movieapp.service.ApiService;

public class BaseRepository {
    public ApiService apiService;

    public BaseRepository() {
        apiService = ApiClient.getClient();
    }
}
