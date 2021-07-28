package com.example.demo.model;

import lombok.Data;

@Data
public class Profession {
  private String description;     //描述
  private String subject;         //学科
  private String major;           //专业分类
  private long pid;               //primary key
  private String proname;         //专业名称
  private String timelength;      //年限
  private String classes;
  private String job;
  private String graduate;
  private String code;            //专业代码
  private String sort;
}
