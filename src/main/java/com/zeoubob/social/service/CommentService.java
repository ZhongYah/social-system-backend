package com.zeoubob.social.service;

import com.zeoubob.social.dto.CommentRequest;
import com.zeoubob.social.model.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> getComments(Integer postId);

    Comment getCommentById(Integer commentId);

    Integer createComment(CommentRequest commentRequest);
}
