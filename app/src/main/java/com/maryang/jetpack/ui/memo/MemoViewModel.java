package com.maryang.jetpack.ui.memo;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MemoViewModel extends ViewModel {

    private MutableLiveData<String> memo = new MutableLiveData<>();

    public MutableLiveData<String> getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo.postValue(memo);
    }
}
