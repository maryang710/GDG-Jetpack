package com.maryang.jetpack.ui.users;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.inflearn.lightinstagram.ui.view.LoadingBar;
import com.maryang.jetpack.R;
import com.maryang.jetpack.data.entity.User;
import com.maryang.jetpack.ui.base.BaseFragment;

import java.util.List;

public class UsersFragment extends BaseFragment implements UsersPresenter.View {

    private LoadingBar loadingBar;
    private RecyclerView recyclerView;
    private UsersAdapter adapter;
    private UsersPresenter presenter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_users;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        findView(view);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setRecyclerView();
        presenter = new UsersPresenter(this);
        presenter.listUsers();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    private void findView(View view) {
        recyclerView = view.findViewById(R.id.recyclerview);
        loadingBar = view.findViewById(R.id.loading);
    }

    private void setRecyclerView() {
        adapter = new UsersAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void showLoader() {
        loadingBar.show();
    }

    @Override
    public void hideLoader() {
        loadingBar.hide();
    }

    @Override
    public void onListUsers(List<User> users) {
        adapter.refresh(users);
    }
}