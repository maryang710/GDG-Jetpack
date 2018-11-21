package com.maryang.jetpack.ui.memo;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentTransaction;
import com.maryang.jetpack.R;
import com.maryang.jetpack.ui.base.BaseActivity;

public class MemoActivity extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_memo;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setFragment();
    }

    private void setFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.box_display, new MemoDisplayFragment());
        transaction.add(R.id.box_type, new MemoTypeFragment());
        transaction.commit();
    }
}