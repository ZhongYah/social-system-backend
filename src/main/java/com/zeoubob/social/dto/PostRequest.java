package com.zeoubob.social.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class PostRequest {

    @NotNull
    private Integer userId;

    @NotNull
    private String content;

    private String image;

}
