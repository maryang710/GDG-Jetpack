package com.maryang.jetpack.network.service;

import com.maryang.jetpack.data.entity.User;
import io.reactivex.Observable;
import retrofit2.http.GET;

import java.util.List;

public interface GithubService {

    @GET("users")
    Observable<List<User>> listUsers();
}