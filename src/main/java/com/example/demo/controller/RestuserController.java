package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
public class RestuserController {

    @Autowired
    private UserMapper userMapper;

    //<--------------用户登录--------------->
    //1、用户注册
    @RequestMapping("/rest/user/add_user")
    public String add_user(String userName, String passWord, String userPhone, Map<String, Object> map)
    {
        //先查找
        User user = userMapper.select(userName,passWord);
        if(user!=null)    //有该用户，不能注册
        {
            map.put("msg","该用户已存在！");
        }
        else
        {
            userMapper.add_user(userName, passWord, userPhone);
            map.put("msg","注册成功！");
        }
        return JSON.toJSONString(map);
    }

    //2. 用户登录
    @RequestMapping("/rest/user/login")
    public String login(HttpServletRequest request,Map<String,Object> map){
        String userName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");

        //先查找
        User user = userMapper.select(userName,passWord);
        if(user !=null)    //有该用户，不能注册
        {
            map.put("msg","登陆成功！");
            return JSON.toJSONString(map);
        }
        else
        {
            map.put("msg","该用户未注册，请先注册");
            return JSON.toJSONString(map);
        }

    }

    //3.用户修改信息
    @RequestMapping("/rest/user/update_user")
    public String update_user(String userName,String passWord,String userPhone,Map<String,Object> map)
    {
        //先查询
        User user = userMapper.get_user(userName);
        if(user!=null)     //有该用户，可以修改
        {
            userMapper.update_user(userName, passWord, userPhone);
            //map.put("msg",user);
            map.put("msg","密码重置成功，请使用新密码登录");
            return JSON.toJSONString(map);
        } else {
            map.put("msg","该用户不存在！");
            return JSON.toJSONString(map);
        }

    }


    //<----------------用户使用功能-------------------->
    //1.查找一个高校信息
    @RequestMapping("/rest/user/get_school")
    public String get_school( String name, Map<String,Object> map)
    {
        School school = userMapper.get_school(name);
        if(school != null){
            map.put("msg",school);
            return  JSON.toJSONString(map);
        }else{
            map.put("msg","该高校不存在，请重新输入");
            return  JSON.toJSONString(map);
        }

    }

    //2.查询一个专业信息
    @RequestMapping("/rest/user/get_profession")
    public String get_profession(String proname,Map<String,Object> map)
    {
        Profession profession = userMapper.get_profession(proname);
        if (profession != null){
            map.put("msg",profession);
            return JSON.toJSONString(map);
        }else {
            map.put("msg","该专业不存在，请重新输入");
            return JSON.toJSONString(map);
        }

    }

    //3.查询高校往年录取最低分和最低排名
    @RequestMapping("/rest/user/get_schoolscore")
    public String get_schoolscore(String name,Map<String,Object> map)
    {
        List<Schoolscore> list = userMapper.get_schoolscore(name);
        if(list != null){
            map.put("msg",list);

        }else{
            map.put("msg","该高校不存在，请重新输入！");

        }
        return JSON.toJSONString(map);
    }

    //4.查询某所高校有哪些专业及录取分
    @RequestMapping("/rest/user/get_school_profession")
    public String get_school_profession(String name,Map<String,Object> map)
    {
        List<Gaokao> list = userMapper.get_school_profession(name);
        if(list != null){
            map.put("msg",list);
            return JSON.toJSONString(map);
        }else {
            map.put("msg","该高校不存在，请重新输入！");
            return JSON.toJSONString(map);
        }

    }
    //5.查询哪些学校都有某个专业及录取分
    @RequestMapping("/rest/user/get_profession_school")
    public String get_profession_school(String proname,Map<String,Object> map)
    {
        List<Gaokao> list = userMapper.get_profession_school(proname);
        if (list != null){
            map.put("msg",list);
            return JSON.toJSONString(map);
        }else{
            map.put("msg","输入信息有误，请重新输入");
            return JSON.toJSONString(map);
        }

    }

    //6.查询某个高校的某个专业的录取分
    @RequestMapping("/rest/user/getschoolprofession")
    public String getschoolprofession(String proname,String name,Map<String,Object> map)
    {
        List<Gaokao> list = userMapper.getschoolprofesson(proname, name);
        if (list != null){
            map.put("msg",list);
            return JSON.toJSONString(map);
        }else{
            map.put("msg","输入信息有误，请重新输入");
            return JSON.toJSONString(map);
        }

    }
}
