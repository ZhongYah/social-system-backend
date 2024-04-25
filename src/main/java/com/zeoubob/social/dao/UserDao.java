package com.zeoubob.social.dao;

import com.zeoubob.social.model.User;

public interface UserDao {

    // 基本 user用手機門號登入的 操作
    User getUserByPhone(String phone);

    Integer createUser(User user);
}
