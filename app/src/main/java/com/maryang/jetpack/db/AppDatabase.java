package com.maryang.jetpack.db;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import com.maryang.jetpack.data.entity.User;
import com.maryang.jetpack.db.dao.UserDao;
import com.maryang.jetpack.ui.base.BaseApplication;

@Database(entities = {User.class}, version = 1)
@TypeConverters(DateTypeConverter.class)
public abstract class AppDatabase extends RoomDatabase {

    public abstract UserDao userDao();

    private static AppDatabase instance;

    public static synchronized AppDatabase get() {
        if (instance == null) {
            instance = Room.databaseBuilder(
                    BaseApplication.get(), AppDatabase.class, "app_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
