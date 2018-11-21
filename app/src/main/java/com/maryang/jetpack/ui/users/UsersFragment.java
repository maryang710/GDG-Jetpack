package com.maryang.jetpack.ui.users;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.inflearn.lightinstagram.ui.view.LoadingBar;
import com.maryang.jetpack.R;
import com.maryang.jetpack.ui.base.BaseFragment;

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
        setPresenter();
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

    private void setPresenter() {
        presenter = new UsersPresenter(this);
        getLifecycle().addObserver(presenter);
        presenter.getUsers().observe(this, users -> adapter.refresh(users));
        presenter.listUsers();
    }

    @Override
    public void showLoader() {
        loadingBar.show();
    }

    @Override
    public void hideLoader() {
        loadingBar.hide();
    }
}