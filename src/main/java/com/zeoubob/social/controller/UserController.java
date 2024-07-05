package com.zeoubob.social.controller;

import com.zeoubob.social.dao.UserDao;
import com.zeoubob.social.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
//@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserDao user1Dao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        // 省略參數檢查 (ex: email 是否被註冊過)

        // hash 原始密碼
        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);

        // 在資料庫中插入 user 數據
        Integer userId = user1Dao.createUser(user);

        return "註冊成功";
    }

    @PostMapping("/userLogin")
    public String userLogin(Authentication authentication) {
        // 帳號密碼驗證由 Spring Security 處理，能執行到這裡表示已經登入成功

        // 取得使用者的帳號
        String username = authentication.getName();

        // 取得使用者的權限
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        return "登入成功！帳號 " + username + " 的權限為: " + authorities;
    }
}
