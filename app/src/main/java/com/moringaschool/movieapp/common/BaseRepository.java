package com.moringaschool.movieapp.common;


import com.moringaschool.movieapp.data.remote.ApiClient;
import com.moringaschool.movieapp.data.remote.ApiService;

public class BaseRepository {
    public ApiService apiService;

    public BaseRepository() {
        apiService = ApiClient.getClient();
    }
}
