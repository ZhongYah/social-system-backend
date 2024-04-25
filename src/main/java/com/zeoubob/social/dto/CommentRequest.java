package com.zeoubob.social.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CommentRequest {

    @NotNull
    private Integer userId;

    @NotNull
    private Integer postId;

    @NotNull
    private String content;

}
