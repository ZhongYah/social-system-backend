package com.zeoubob.social.controller;

import com.zeoubob.social.dto.PostRequest;
import com.zeoubob.social.model.Post;
import com.zeoubob.social.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@Validated
@RestController
//@CrossOrigin(origins = "*")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/posts")
    public ResponseEntity<List<Post>> getPosts() {

        // Get post list
        List<Post> postList = postService.getPosts();

        return ResponseEntity.status(HttpStatus.OK).body(postList);
    }

    @GetMapping("/posts/{postId}")
    public ResponseEntity<Post> getPost(@PathVariable Integer postId) {
        Post post = postService.getPostById(postId);

        if (post != null) {
            return ResponseEntity.status(HttpStatus.OK).body(post);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/posts")
    public ResponseEntity<Post> createPost(@RequestBody @Valid PostRequest postRequest) {
        Integer postId = postService.createPost(postRequest);

        Post post = postService.getPostById(postId);

        return ResponseEntity.status(HttpStatus.CREATED).body(post);
    }

    @PutMapping("/posts/{postId}")
    public ResponseEntity<Post> updatePost(@PathVariable Integer postId,
                                           @RequestBody @Valid PostRequest postRequest) {

        // Check if the post exists
        Post post = postService.getPostById(postId);
        if (post == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        // 確認使用者修改自己的貼文
        if(!Objects.equals(post.getUserId(), postRequest.getUserId())){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        // Update post data
        postService.updatePost(postId, postRequest);

        Post updatedPost = postService.getPostById(postId);

        return ResponseEntity.status(HttpStatus.OK).body(updatedPost);
    }

    @DeleteMapping("users/{userId}/posts/{postId}")
    public ResponseEntity<?> deletePost(@PathVariable Integer userId,
                                        @PathVariable Integer postId) {
        // 確認使用者刪除自己的貼文
        Post post = postService.getPostById(postId);
        if(!Objects.equals(post.getUserId(), userId)){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        postService.deletePostById(postId);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
