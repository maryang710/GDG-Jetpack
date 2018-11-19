package com.maryang.jetpack.data.source;

import com.maryang.jetpack.data.entity.User;
import com.maryang.jetpack.db.AppDatabase;
import com.maryang.jetpack.db.dao.UserDao;
import io.reactivex.Observable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserLocalSource {

    private AppDatabase db = AppDatabase.get();
    private UserDao dao = db.userDao();

    public Observable<List<User>> listUsers() {
        return dao.listUsers();
    }

    public void save(List<User> users) {
        for (User user : users) {
            Date date = new Date();
            user.setCreatedAt(date);
            user.setUpdatedAt(date);
        }
        List<Long> ids = dao.insert(users);

        List<User> updateUsers = new ArrayList<>();
        for (int i = 0; i < users.size(); i++) {
            if (ids.get(i) == -1) updateUsers.add(users.get(i));
        }
        dao.update(updateUsers);
    }
}