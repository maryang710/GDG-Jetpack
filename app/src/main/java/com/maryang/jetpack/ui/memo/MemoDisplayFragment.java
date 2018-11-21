package com.maryang.jetpack.ui.memo;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;
import com.maryang.jetpack.R;
import com.maryang.jetpack.ui.base.BaseFragment;

public class MemoDisplayFragment extends BaseFragment {

    private TextView txtMemo;
    private MemoViewModel viewModel;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_memo_display;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        findView(view);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel = ViewModelProviders.of(activity).get(MemoViewModel.class);
        viewModel.getMemo().observe(this, memo -> txtMemo.setText(memo));
    }

    private void findView(View view) {
        txtMemo = view.findViewById(R.id.txt_memo);
    }
}
