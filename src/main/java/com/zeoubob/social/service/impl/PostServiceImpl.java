package com.zeoubob.social.service.impl;

import com.zeoubob.social.model.Post;
import com.zeoubob.social.service.PostService;
import com.zeoubob.social.dao.PostDao;
import com.zeoubob.social.dto.PostRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PostServiceImpl implements PostService {

    @Autowired
    private PostDao postDao;

    @Override
    public List<Post> getPosts() {
        return postDao.getPosts();
    }

    @Override
    public Post getPostById(Integer postId) {
        return postDao.getPostById(postId);
    }

    @Override
    public Integer createPost(PostRequest postRequest) {
        return postDao.createPost(postRequest);
    }

    @Override
    public void updatePost(Integer postId, PostRequest postRequest) {
        postDao.updatePost(postId, postRequest);
    }

    @Override
    public void deletePostById(Integer postId) {
        postDao.deletePostById(postId);
    }
}
