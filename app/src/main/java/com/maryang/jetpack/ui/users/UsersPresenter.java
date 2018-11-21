package com.maryang.jetpack.ui.users;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.MutableLiveData;
import com.maryang.jetpack.data.entity.User;
import com.maryang.jetpack.data.source.UserRepository;
import com.maryang.jetpack.ui.base.BasePresenter;
import io.reactivex.android.schedulers.AndroidSchedulers;

import java.util.List;

public class UsersPresenter extends BasePresenter {

    private View view;
    private Lifecycle lifecycle;
    private UserRepository repository = UserRepository.get();
    private MutableLiveData<List<User>> users = new MutableLiveData<>();

    public MutableLiveData<List<User>> getUsers() {
        return users;
    }

    public void initialize(View view, Lifecycle lifecycle) {
        if (this.view != null) return;
        this.view = view;
        this.lifecycle = lifecycle;
    }

    public void listUsers() {
        view.showLoader();
        compositeDisposable.add(repository.listUsers()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(users -> {
                    view.hideLoader();
                    if (lifecycle.getCurrentState().isAtLeast(Lifecycle.State.CREATED))
                        this.users.postValue(users);
                }, t -> {
                    t.printStackTrace();
                    view.hideLoader();
                }));
    }

    public interface View {
        void showLoader();

        void hideLoader();
    }
}