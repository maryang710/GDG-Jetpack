package com.maryang.jetpack.ui.users;

import com.maryang.jetpack.data.entity.User;
import com.maryang.jetpack.data.source.UserRepository;
import com.maryang.jetpack.ui.base.BasePresenter;
import io.reactivex.android.schedulers.AndroidSchedulers;

import java.util.List;

public class UsersPresenter extends BasePresenter {

    private View view;
    private UserRepository repository = UserRepository.get();

    public UsersPresenter(View view) {
        this.view = view;
    }

    public void listUsers() {
        view.showLoader();
        compositeDisposable.add(repository.listUsers()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(users -> {
                    view.hideLoader();
                    view.onListUsers(users);
                }, t -> {
                    t.printStackTrace();
                    view.hideLoader();
                }));
    }

    public interface View {
        void showLoader();

        void hideLoader();

        void onListUsers(List<User> users);
    }
}