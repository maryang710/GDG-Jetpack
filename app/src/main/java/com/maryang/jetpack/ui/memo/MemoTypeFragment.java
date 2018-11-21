package com.maryang.jetpack.ui.memo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;
import com.maryang.jetpack.R;
import com.maryang.jetpack.ui.base.BaseFragment;

public class MemoTypeFragment extends BaseFragment {

    private EditText inputText;
    private Button btnConfirm;
    private MemoViewModel viewModel;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_memo_type;
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
        setButton();
    }

    private void findView(View view) {
        inputText = view.findViewById(R.id.input_text);
        btnConfirm = view.findViewById(R.id.btn_confirm);
    }

    private void setButton() {
        btnConfirm.setOnClickListener(v -> viewModel.setMemo(inputText.getText().toString()));
    }
}
