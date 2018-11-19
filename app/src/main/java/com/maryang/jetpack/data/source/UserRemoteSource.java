package com.maryang.jetpack.data.source;


import com.maryang.jetpack.data.entity.User;
import com.maryang.jetpack.network.RetrofitStore;
import com.maryang.jetpack.network.service.GithubService;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.util.List;

public class UserRemoteSource {

    private GithubService service = RetrofitStore.get().create(GithubService.class);

    public Observable<List<User>> listUsers() {
        return service.listUsers().subscribeOn(Schedulers.io());
    }
}