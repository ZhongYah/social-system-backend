package com.zeoubob.social.dao.impl;

import com.zeoubob.social.dao.PostDao;
import com.zeoubob.social.model.Post;
import com.zeoubob.social.rowmapper.PostRowMapper;
import com.zeoubob.social.dto.PostRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class PostDaoImpl implements PostDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<Post> getPosts() {
        String sql = "SELECT post_id, user_id, content, image, created_at FROM post";

        Map<String, Object> map = new HashMap<>();

        List<Post> postList = namedParameterJdbcTemplate.query(sql, map, new PostRowMapper());

        return postList;
    }

    @Override
    public Post getPostById(Integer postId) {
        String sql = "SELECT post_id, user_id, content, image, created_at " +
                "FROM post WHERE post_id = :postId";

        Map<String, Object> map = new HashMap<>();
        map.put("postId", postId);

        List<Post> postList = namedParameterJdbcTemplate.query(sql, map, new PostRowMapper());

        if (postList.size() > 0) {
            return postList.get(0);
        } else {
            return null;
        }
    }

    @Override
    public Integer createPost(PostRequest postRequest) {
        String sql = "INSERT INTO post(user_id, content, image, created_at) " +
                "VALUES (:userId, :content, :image, :createdAt)";

        Map<String, Object> map = new HashMap<>();
        map.put("userId", postRequest.getUserId());
        map.put("content", postRequest.getContent());
        map.put("image", postRequest.getImage());

        Date now = new Date();
        map.put("createdAt", now);

        KeyHolder keyHolder = new GeneratedKeyHolder();

        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder);

        int postId = keyHolder.getKey().intValue();

        return postId;
    }

    @Override
    public void updatePost(Integer postId, PostRequest postRequest) {
        String sql = "UPDATE post SET user_id = :userId, content = :content, " +
                "image = :image WHERE post_id = :postId ";

        Map<String, Object> map = new HashMap<>();
        map.put("postId", postId);

        map.put("userId", postRequest.getUserId());
        map.put("content", postRequest.getContent());
        map.put("image", postRequest.getImage());

        namedParameterJdbcTemplate.update(sql, map);
    }

    @Override
    public void deletePostById(Integer postId) {
        String sql = "DELETE FROM post WHERE post_id = :postId ";

        Map<String, Object> map = new HashMap<>();
        map.put("postId", postId);

        namedParameterJdbcTemplate.update(sql, map);
    }
}
