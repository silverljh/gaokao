package com.example.demo.model;

import lombok.Data;

@Data
public class User {
    private long id;                    //primary key
    private String userName;            //用户名
    private String passWord;            //密码
    private String userphone;           //联系方式
}
