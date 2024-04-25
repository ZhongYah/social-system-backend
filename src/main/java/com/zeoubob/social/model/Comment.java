package com.zeoubob.social.model;

import lombok.Data;

import java.util.Date;

@Data
public class Comment {

    private Integer commentId;
    private Integer userId;
    private Integer postId;
    private String content;
    private Date createdAt;

}
