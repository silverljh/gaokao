package com.example.demo.model;

import lombok.Data;

@Data
public class Schoolscore {
  //高校录取文理科最低分及最高分（年份）
  private long scid;
  private long sort;
  private String name;    //高校名称
  private long minScore;  //最低分
  private long minRank;    //最低位次
  private long batch;
  private long year;        //年份
}
