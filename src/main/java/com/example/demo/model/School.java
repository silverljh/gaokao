package com.example.demo.model;

import lombok.Data;

@Data
public class School {

  private long rank;              //名次
  private long scid;                //primary key
  private String name;              //高校名称
  private String areaname;           //地区名称
  private long areaid;              //地区id
  private String description;       //描述、简介
  private String acronym;          //英文缩写
  private String region;           //地区
  private long reid;
  private String usedname;          //曾用名
  private String type;              //类型
  private long foundingYear;        //建校时间
  private String department;
  private String iscombine;
  private long is985;
  private long is211;
  private long isDoubleFirstClass;
  private long firstClassNum;
  private long facultyNum;
  private long academicianNum;
  private long changjiangScholarNum;
  private long teachersNum;
  private long undergraProNum;
  private long postgraProNum;
  private long doctorProNum;
  private long mainLabNum;
  private long undergraEnrollNum;
  private long postgraEnrollNum;
  private String schoolWeb;               //学校网站

}
