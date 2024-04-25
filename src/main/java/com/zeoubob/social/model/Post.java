package com.zeoubob.social.model;

import lombok.Data;

import java.util.Date;

@Data
public class Post {

    private Integer postId;
    private Integer userId;
    private String content;
    private String image;
    private Date createdAt;

}
