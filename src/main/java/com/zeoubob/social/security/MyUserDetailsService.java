package com.zeoubob.social.security;

import com.zeoubob.social.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // 從資料庫中查詢 user 數據
        com.zeoubob.social.model.User user = userDao.getUserByPhone(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found for: " + username);

        } else {

            String userPhone = user.getPhone();
            String userPassword = user.getPassword();

            // 權限部分，先不用管
            List<GrantedAuthority> authorities = new ArrayList<>();

            // 轉換成 Spring Security 指定的 User 格式
            return new User(userPhone, userPassword, authorities);
        }
    }
}
