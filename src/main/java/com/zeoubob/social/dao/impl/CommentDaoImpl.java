package com.zeoubob.social.dao.impl;

import com.zeoubob.social.dao.CommentDao;
import com.zeoubob.social.dto.CommentRequest;
import com.zeoubob.social.model.Comment;
import com.zeoubob.social.rowmapper.CommentRowMapper;
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
public class CommentDaoImpl implements CommentDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<Comment> getComments(Integer postId) {
        String sql = "SELECT comment_id, user_id, post_id, content, created_at " +
                "FROM comment WHERE post_id = :postId";

        Map<String, Object> map = new HashMap<>();
        map.put("postId", postId);

        List<Comment> commentList = namedParameterJdbcTemplate.query(sql, map, new CommentRowMapper());

        return commentList;
    }

    @Override
    public Comment getCommentById(Integer commentId) {
        String sql = "SELECT comment_id, user_id, post_id, content, created_at " +
                "FROM comment WHERE comment_id = :commentId";

        Map<String, Object> map = new HashMap<>();
        map.put("commentId", commentId);

        List<Comment> commentList = namedParameterJdbcTemplate.query(sql, map, new CommentRowMapper());

        if (commentList.size() > 0) {
            return commentList.get(0);
        } else {
            return null;
        }
    }

    @Override
    public Integer createComment(CommentRequest commentRequest) {
        String sql = "INSERT INTO comment(user_id, post_id, content, created_at) " +
                "VALUES (:userId, :postId, :content, :createdAt)";

        Map<String, Object> map = new HashMap<>();
        map.put("userId", commentRequest.getUserId());
        map.put("postId", commentRequest.getPostId());
        map.put("content", commentRequest.getContent());

        Date now = new Date();
        map.put("createdAt", now);

        KeyHolder keyHolder = new GeneratedKeyHolder();

        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder);

        int commentId = keyHolder.getKey().intValue();

        return commentId;
    }
}
