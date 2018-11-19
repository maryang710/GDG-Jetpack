package com.maryang.jetpack.ui.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {

    protected Context context;

    public abstract void bind(T item);

    public BaseViewHolder(@NonNull View itemView) {
        super(itemView);
        this.context = itemView.getContext();
    }

    protected static View getItemView(ViewGroup parent, int layoutId) {
        return LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false);
    }
}