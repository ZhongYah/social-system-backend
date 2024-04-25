package com.zeoubob.social.controller;

import com.zeoubob.social.dto.CommentRequest;
import com.zeoubob.social.model.Comment;
import com.zeoubob.social.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@CrossOrigin(origins = "*")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/posts/{postId}/comments")
    public ResponseEntity<List<Comment>> getComments(@PathVariable Integer postId) {
        // Get comment list
        List<Comment> commentList = commentService.getComments(postId);

        return ResponseEntity.status(HttpStatus.OK).body(commentList);
    }

    @PostMapping("/comments")
    public ResponseEntity<Comment> createComment(@RequestBody @Valid CommentRequest commentRequest) {
        Integer commentId = commentService.createComment(commentRequest);

        Comment comment = commentService.getCommentById(commentId);

        return ResponseEntity.status(HttpStatus.CREATED).body(comment);
    }
}
