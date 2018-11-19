package com.maryang.jetpack.ui.users;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import com.bumptech.glide.Glide;
import com.maryang.jetpack.R;
import com.maryang.jetpack.data.entity.User;
import com.maryang.jetpack.ui.base.BaseViewHolder;

public class UserViewHolder extends BaseViewHolder<User> implements View.OnClickListener {

    private ImageView imgAvatar;
    private TextView txtName;

    private User user;

    public UserViewHolder(@NonNull ViewGroup parent) {
        super(getItemView(parent, R.layout.view_user_item));
        findView(itemView);
    }

    private void findView(View view) {
        imgAvatar = view.findViewById(R.id.img_avatar);
        txtName = view.findViewById(R.id.txt_name);
    }

    @Override
    public void bind(final User user) {
        this.user = user;
        txtName.setText(user.getName());
        itemView.setOnClickListener(this);

        Glide.with(context)
                .load(user.getAvatarUrl())
                .into(imgAvatar);
    }

    @Override
    public void onClick(View v) {
//        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//        transaction.add(R.id.box_fragment, UserFragment.newInstance(user.getName()));
//        transaction.commit();

        Navigation.findNavController(v).navigate(
                UsersFragmentDirections.actionUsersFragmentToUserFragment(user.getName()));
    }
}