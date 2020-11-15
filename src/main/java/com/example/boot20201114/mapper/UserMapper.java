package com.example.boot20201114.mapper;

import com.example.boot20201114.po.User;

import java.util.List;

public interface UserMapper {
    void insert(User user);
    void insertBatch(List<User> users);
}
