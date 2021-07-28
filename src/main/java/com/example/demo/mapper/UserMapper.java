package com.example.demo.mapper;

import com.example.demo.model.*;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    //用户的方法

    //1、添加用户
    @Insert("insert into user (userName,passWord, userPhone) values (#{userName},#{passWord},#{userPhone})")
    void add_user(String userName, String passWord, String userPhone);

    //2. 查找用户
    @Select("select * from user where userName=#{userName} and passWord=#{passWord}")
    User select(String userName, String passWord);

    @Select("select * from user where userName=#{userName}")
    User get_user(String userName);

    //3、修改用户信息
    @Update("update user set passWord=#{passWord},userPhone=#{userPhone} where userName=#{userName}")
    void update_user(String userName, String passWord, String userPhone);

    //4、查询高校信息
    @Select("select * from school where name=#{name}")
    School get_school(String name);

    //5、查找专业信息
    @Select("select * from profession where proname=#{proname}")
    Profession get_profession(String proname);

    //6、查询高校往年录取最低分和最低排名
    @Select("select * from schoolscore where name=#{name}")
    List<Schoolscore> get_schoolscore(String name);

    //7、查询某所高校有哪些专业
    @Select("select * from gaokao where name=#{name}")
    List<SchoolProfession> get_schoolprofession(String name);

    //8、查询哪些学校都有某个专业
    @Select("select * from gaokao where profession_name=#{profession_name}")
    List<SchoolProfession> get_professionschool(String profession_name);

    //9、查询某所高校有哪些专业及录取分
    @Select("select * from gaokao,profession where gaokao.spname=profession.proname && gaokao.name=#{name} ")
    List<Gaokao> get_school_profession(String name);

    //10、查询哪些学校都有某个专业及录取分
    @Select("select * from gaokao,profession where gaokao.spname=profession.proname and profession.proname=#{proname}")
    List<Gaokao> get_profession_school(String proname);

    //11、查询某个高校的某个专业的录取分
    @Select("select * from gaokao,profession where gaokao.spname=profession.proname and profession.proname=#{proname} and gaokao.name=#{name}")
    List<Gaokao> getschoolprofesson(String proname,String name);

}
