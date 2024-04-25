package com.zeoubob.social.rowmapper;

import com.zeoubob.social.model.Comment;
import com.zeoubob.social.model.Post;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CommentRowMapper implements RowMapper<Comment> {

    @Override
    public Comment mapRow(ResultSet resultSet, int i) throws SQLException {
        Comment comment = new Comment();

        comment.setCommentId(resultSet.getInt("comment_id"));
        comment.setUserId(resultSet.getInt("user_id"));
        comment.setPostId(resultSet.getInt("post_id"));
        comment.setContent(resultSet.getString("content"));
        comment.setCreatedAt(resultSet.getTimestamp("created_at"));

        return comment;
    }
}
