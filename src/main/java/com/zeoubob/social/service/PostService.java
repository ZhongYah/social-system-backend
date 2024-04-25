package com.zeoubob.social.service;

import com.zeoubob.social.dto.PostRequest;
import com.zeoubob.social.model.Post;

import java.util.List;

public interface PostService {

    List<Post> getPosts();

    Post getPostById(Integer postId);

    Integer createPost(PostRequest postRequest);

    void updatePost(Integer postId, PostRequest postRequest);

    void deletePostById(Integer postId);
}
