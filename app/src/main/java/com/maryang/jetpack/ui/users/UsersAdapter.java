package com.maryang.jetpack.ui.users;

import android.view.ViewGroup;
import com.maryang.jetpack.ui.base.BaseRecyclerViewAdapter;
import com.maryang.jetpack.ui.base.BaseViewHolder;

public class UsersAdapter extends BaseRecyclerViewAdapter {

    private final String TAG = getClass().getSimpleName();

    @Override
    protected BaseViewHolder getViewHolder(int viewType, ViewGroup parent) {
        return new UserViewHolder(parent);
    }
}