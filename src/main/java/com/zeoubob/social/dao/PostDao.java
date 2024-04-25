package com.zeoubob.social.dao;

import com.zeoubob.social.model.Post;
import com.zeoubob.social.dto.PostRequest;

import java.util.List;

public interface PostDao {

    List<Post> getPosts();

    Post getPostById(Integer postId);

    Integer createPost(PostRequest postRequest);

    void updatePost(Integer postId, PostRequest postRequest);

    void deletePostById(Integer postId);
}
