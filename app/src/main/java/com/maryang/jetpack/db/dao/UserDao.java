package com.maryang.jetpack.db.dao;

import androidx.room.*;
import com.maryang.jetpack.data.entity.User;
import io.reactivex.Observable;

import java.util.List;

@Dao
public interface UserDao {

    @Query("SELECT * FROM user")
    Observable<List<User>> listUsers();

    @Query("SELECT * FROM user WHERE id = :userId")
    User getUser(long userId);

    @Insert
    long insert(User user);

    @Update
    void update(User user);

    @Delete
    void delete(User user);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    List<Long> insert(List<User> users);

    @Update(onConflict = OnConflictStrategy.IGNORE)
    void update(List<User> users);
}
