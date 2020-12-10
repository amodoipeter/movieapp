package com.moringaschool.movieapp.common;


public class BaseRepository {
    public ApiService apiService;

    public BaseRepository() {
        apiService = ApiClient.getClient();
    }
}
