package com.example.demo.model;

import lombok.Data;

@Data
public class ScoreRank {
    //分数段及排名
  private long id;          //primary key
  private long score;       //分数
  private long rank;        //位次
  private long year;        //年份
  private String sort;      //分类
}
