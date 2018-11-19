package com.maryang.jetpack.ui.memo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.maryang.jetpack.R;
import com.maryang.jetpack.ui.base.BaseFragment;

public class MemoTypeFragment extends BaseFragment {

    private EditText inputText;
    private Button btnConfirm;

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
        setButton();
    }

    private void findView(View view) {
        inputText = view.findViewById(R.id.input_text);
        btnConfirm = view.findViewById(R.id.btn_confirm);
    }

    private void setButton() {
        btnConfirm.setOnClickListener(v -> {
            MemoActivity activity = ((MemoActivity) getActivity());
            activity.showMemo(inputText.getText().toString());
        });
    }
}
