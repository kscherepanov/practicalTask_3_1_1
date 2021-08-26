package com.practicalTask.practicalTask_3_1_1.dao;

import com.practicalTask.practicalTask_3_1_1.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAll();

    User getById(Long id);

    User getByEmail(String email);

    User getByUserName(String username);

    void delete(Long id);

    void update(User user);

    void create(User user);
}
