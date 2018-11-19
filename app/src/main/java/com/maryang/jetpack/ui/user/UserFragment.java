package com.maryang.jetpack.ui.user;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.maryang.jetpack.R;
import com.maryang.jetpack.data.entity.User;
import com.maryang.jetpack.ui.base.BaseFragment;

public class UserFragment extends BaseFragment {

    private TextView txtName;

    public static UserFragment newInstance(String userName) {
        Bundle args = new Bundle();
        args.putString(User.INTENT_KEY, userName);

        UserFragment fragment = new UserFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_user;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        findView(view);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setName();
    }

    private void findView(View view) {
        txtName = view.findViewById(R.id.txt_name);
    }

    private void setName() {
//        String userName = getArguments().getString(User.INTENT_KEY);
//        txtName.setText(userName);

        UserFragmentArgs args = UserFragmentArgs.fromBundle(getArguments());
        txtName.setText(args.getUsername());
    }
}