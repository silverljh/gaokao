package com.example.demo.model;

import lombok.Data;

@Data
public class Admin {
  private long id;
  private String adminName;
  private String passWord;
  private String adminPhone;
}
