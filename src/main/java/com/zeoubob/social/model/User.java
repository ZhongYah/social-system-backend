package com.zeoubob.social.model;

import lombok.Data;

@Data
public class User {

    private Integer userId;
    private String userName;
    private String phone;
    private String email;
    private String password;
    private String coverImage;
    private String biography;

}
