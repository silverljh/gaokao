package com.example.demo.model;

import lombok.Data;

@Data
public class Gaokao {
    private long code;
    private long scid;
    private long sid;                //primary key
    private long average;
    private long year;             //年份
    private long min;
    private long schoolId;
    private long minSection;     //最低位次
    private long max;
    private String localProvinceName;     //省份
    private String localBatchName;       //本科层次
    private String spname;              //专业名称
    private String name;               //高校名称
    private String localTypeName;
    private long rank;
    private String proscore;
    private String areaname;          //地区
    private long is985;
    private long is211;
    private long isDoubleFirstClass;
    private String type;            //高校类型
}
