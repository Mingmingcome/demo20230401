package com.example.demo.dao;

import com.example.demo.model.User;

/**
 * @who luhaoming
 * @when 2020/7/27 17:58
 * @what 用户Mapper
 */
public interface UserMapper {
    int saveUser(User user);

    User findUserById(final String userId);
}
