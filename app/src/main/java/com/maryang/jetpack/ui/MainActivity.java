package com.maryang.jetpack.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.annotation.Nullable;
import com.maryang.jetpack.R;
import com.maryang.jetpack.ui.base.BaseActivity;
import com.maryang.jetpack.ui.memo.MemoActivity;
import com.maryang.jetpack.ui.users.UsersActivity;

public class MainActivity extends BaseActivity {

    private Button btnUsers;
    private Button btnMemo;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        findView();
        setButton();
    }

    private void findView() {
        btnUsers = findViewById(R.id.btn_users);
        btnMemo = findViewById(R.id.btn_memo);
    }

    private void setButton() {
        btnUsers.setOnClickListener(v -> startActivity(new Intent(context, UsersActivity.class)));
        btnMemo.setOnClickListener(v -> startActivity(new Intent(context, MemoActivity.class)));
    }
}