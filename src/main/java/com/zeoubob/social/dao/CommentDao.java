package com.zeoubob.social.dao;

import com.zeoubob.social.dto.CommentRequest;
import com.zeoubob.social.model.Comment;

import java.util.List;

public interface CommentDao {

    List<Comment> getComments(Integer postId);

    Comment getCommentById(Integer commentId);

    Integer createComment(CommentRequest commentRequest);
}
