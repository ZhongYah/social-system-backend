package com.zeoubob.social.service.impl;

import com.zeoubob.social.dao.CommentDao;
import com.zeoubob.social.dto.CommentRequest;
import com.zeoubob.social.model.Comment;
import com.zeoubob.social.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;


    @Override
    public List<Comment> getComments(Integer postId) {
        return commentDao.getComments(postId);
    }

    @Override
    public Comment getCommentById(Integer commentId) {
        return commentDao.getCommentById(commentId);
    }

    @Override
    public Integer createComment(CommentRequest commentRequest) {
        return commentDao.createComment(commentRequest);
    }
}
