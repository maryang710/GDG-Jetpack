package com.maryang.jetpack.data.source;

import com.maryang.jetpack.data.entity.User;
import com.maryang.jetpack.util.NetworkChecker;
import io.reactivex.Observable;

import java.util.List;

public class UserRepository {

    private UserLocalSource userLocalSource = new UserLocalSource();
    private UserRemoteSource userRemoteSource = new UserRemoteSource();

    private static UserRepository instance;

    private UserRepository() {
    }

    public synchronized static UserRepository get() {
        if (instance == null) instance = new UserRepository();
        return instance;
    }

    public Observable<List<User>> listUsers() {
        if (NetworkChecker.isConnected()) {
            return userRemoteSource.listUsers()
                    .doOnNext(users -> userLocalSource.save(users));
        } else {
            return userLocalSource.listUsers();
        }
    }
}
