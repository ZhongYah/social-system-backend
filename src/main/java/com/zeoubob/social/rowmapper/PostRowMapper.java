package com.zeoubob.social.rowmapper;

import com.zeoubob.social.model.Post;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PostRowMapper implements RowMapper<Post> {

    @Override
    public Post mapRow(ResultSet resultSet, int i) throws SQLException {
        Post post = new Post();

        post.setPostId(resultSet.getInt("post_id"));
        post.setUserId(resultSet.getInt("user_id"));
        post.setContent(resultSet.getString("content"));
        post.setImage(resultSet.getString("image"));
        post.setCreatedAt(resultSet.getTimestamp("created_at"));

        return post;
    }
}
