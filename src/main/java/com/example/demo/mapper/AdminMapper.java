package com.example.demo.mapper;

import com.example.demo.model.*;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AdminMapper {

    //1、添加用户
    @Insert("insert into admin (adminName,passWord,adminPhone) values (#{adminName},#{passWord},#{adminPhone})")
    void add_admin(String adminName, String passWord, String adminPhone);

    //2. 查找用户
    @Select("select * from admin where adminName=#{adminName} and passWord=#{passWord}")
    Admin select(String adminName, String passWord);

    @Select("select * from admin where adminName=#{adminName}")
    Admin get_user(String adminName);

    //3、修改用户信息
    @Update("update admin set passWord=#{passWord},adminPhone=#{adminPhone} where adminName=#{adminName}")
    void update_user(String adminName, String passWord, String adminPhone);


    //4、添加高校
    @Insert("insert into school (name,description,schoolWeb) values (#{name},#{description},#{schoolWeb})")
    void admin_add_school(String name, String description, String schoolWeb);

    //5、删除高校
    @Delete("delete from school where name=#{name}")
    void admin_delete_school(String name);

    //6、修改高校信息
    @Update("update school set description=#{description},schoolWeb=#{schoolWeb} where name=#{name}")
    void admin_update_school(String name, String description, String schoolWeb);

    //7、查找高校
    @Select("select * from school where name=#{name}")
    School admin_get_school(String name);


    //8、查找专业信息
    @Select("select * from profession where proname=#{proname}")
    Profession admin_get_profession(String proname);


    //9、添加专业
    @Insert("insert into profession (proname,code,description) values (#{proname},#{code},#{description})")
    void admin_add_profession(String proname, String code, String description);


    //10、删除专业
    @Delete("delete from profession where proname=#{proname}")
    void admin_delete_profession(String proname);


    //11、修改专业信息
    @Update("update profession set code=#{code},description=#{description} where proname=#{proname}")
    void admin_update_profession(String proname, String code, String description);



}
