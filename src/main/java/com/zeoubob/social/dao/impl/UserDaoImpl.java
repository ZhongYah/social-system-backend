package com.zeoubob.social.dao.impl;

import com.zeoubob.social.dao.UserDao;
import com.zeoubob.social.model.User;
import com.zeoubob.social.rowmapper.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class UserDaoImpl implements UserDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    private UserRowMapper userRowMapper;

    @Override
    public User getUserByPhone(String phone) {
        String sql = "SELECT user_id, user_name, phone, email, password, cover_image, biography FROM user WHERE phone = :phone";

        Map<String, Object> map = new HashMap<>();
        map.put("phone", phone);

        List<User> userList = namedParameterJdbcTemplate.query(sql, map, userRowMapper);

        if (userList.size() > 0) {
            return userList.get(0);
        } else {
            return null;
        }
    }

    @Override
    public Integer createUser(User user) {
        String sql = "INSERT INTO `user`(user_name, phone, email, password, cover_image, biography) " +
                "VALUES (:userName, :phone, :email, :password, :coverImage, :biography)";

        Map<String, Object> map = new HashMap<>();
        map.put("userName", user.getUserName());
        map.put("phone", user.getPhone());
        map.put("email", user.getEmail());
        map.put("password", user.getPassword());
        map.put("coverImage", user.getCoverImage());
        map.put("biography", user.getBiography());

        KeyHolder keyHolder = new GeneratedKeyHolder();

        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder);

        int userId = keyHolder.getKey().intValue();

        return userId;
    }
}
