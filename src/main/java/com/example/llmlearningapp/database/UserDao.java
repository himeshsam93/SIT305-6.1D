package com.example.llmlearningapp.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface UserDao {

    @Insert
    void insert(User user);

    @Query("SELECT * FROM User WHERE username=:u AND password=:p LIMIT 1")
    User login(String u, String p);
}