package com.maryang.jetpack.ui.users;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import com.maryang.jetpack.R;
import com.maryang.jetpack.ui.base.BaseActivity;

public class UsersActivity extends BaseActivity {

    private NavController navController;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_users;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        navController = Navigation.findNavController(this, R.id.nav_host);
        NavigationUI.setupActionBarWithNavController(this, navController);
    }

    @Override
    public boolean onSupportNavigateUp() {
        return navController.navigateUp();
    }
}