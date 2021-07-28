package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.mapper.AdminMapper;
import com.example.demo.model.Admin;
import com.example.demo.model.Profession;
import com.example.demo.model.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
public class RestadminController {

    @Autowired
    private AdminMapper adminMapper;

    //<------------管理员登录--------------->
    //1、用户注册
    @RequestMapping("/rest/admin/add_admin")
    public String add_user(String adminName, String passWord, String adminPhone, Map<String, Object> map)
    {
        //先查找
        Admin admin = adminMapper.select(adminName,passWord);
        if(admin!=null)    //有该用户，不能注册
        {
            map.put("msg","该用户已存在！");
            return JSON.toJSONString(map);
        }
        else
        {
            adminMapper.add_admin(adminName, passWord, adminPhone);
            map.put("msg","注册成功！");
            return JSON.toJSONString(map);
        }

    }

    //2. 用户登录
    @RequestMapping("/rest/admin/login")
    public String login(HttpServletRequest request, Map<String,Object> map){
        String adminName = request.getParameter("adminName");
        String passWord = request.getParameter("passWord");

        //先查找
        Admin admin = adminMapper.select(adminName,passWord);
        if(admin !=null)    //有该用户，不能注册
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
    @RequestMapping("/rest/admin/update_admin")
    public String update_user(String adminName,String passWord,String adminPhone,Map<String,Object> map)
    {
        //先查询
        Admin admin = adminMapper.get_user(adminName);
        if(admin!=null)     //有该用户，可以修改
        {
            adminMapper.update_user(adminName, passWord, adminPhone);
            map.put("msg","密码重置成功，请使用新密码登录");
        } else {
            map.put("msg","该用户不存在！");
        }
        return JSON.toJSONString(map);
    }

    //<---------------------管理员功能--------------------->
    //1.添加高校
    @RequestMapping("/rest/admin/add_school")
    public String admin_add_school(String name,String description,String schoolWeb,Map<Object,String> map)
    {
        //先查找
        School school = adminMapper.admin_get_school(name);
        if(school != null)     //有该高校，不能添加
        {
            map.put("msg","该高校已经存在！");
        }
        else
        {
            adminMapper.admin_add_school(name, description, schoolWeb);
            map.put("msg","添加高校成功");
        }
        return JSON.toJSONString(map);
    }

    //2.删除高校
    @RequestMapping("/rest/admin/delete_school")
    public String admin_delete_school(String name, Map<Object,String> map)
    {
        //先查找
        School school = adminMapper.admin_get_school(name);
        if(school != null)     //有该高校，可以删除
        {
            adminMapper.admin_delete_school(name);
            map.put("msg","高校删除成功");
        }
        else
        {
            map.put("msg","该高校不存在");
        }
        return JSON.toJSONString(map);
    }

    //3.修改高校信息
    @RequestMapping("/rest/admin/update_school")
    public String admin_update_school(String name,String description,String schoolWeb,Map<Object,String> map)
    {
        //先查找
        School school = adminMapper.admin_get_school(name);
        if(school!=null)     //有该高校，可以修改
        {
            adminMapper.admin_update_school(name, description, schoolWeb);
            map.put("msg","高校信息修改成功");
        }
        else
        {
            map.put("msg","高校不存在！");
        }
        return JSON.toJSONString(map);
    }
    //4.添加专业
    @RequestMapping("/rest/admin/add_profession")
    public String admin_add_profession(String proname,String code,String description,Map<Object,String> map)
    {
        //先查找
        Profession profession = adminMapper.admin_get_profession(proname);
        if(profession!=null)     //有该专业，不能添加
        {
            map.put("msg","该专业已存在！");
        }
        else
        {
            adminMapper.admin_add_profession(proname,code, description);
            map.put("msg","专业添加成功");
        }
        return JSON.toJSONString(map);
    }

    //5、修改专业信息
    @RequestMapping("/rest/admin/update_profession")
    public String admin_update_profession(String proname,String code,String description,Map<Object,String> map)
    {
        //先查找
        Profession profession = adminMapper.admin_get_profession(proname);
        if (profession != null)     //有该专业，可以修改
        {
            adminMapper.admin_update_profession(proname, code, description);
            map.put("msg","专业信息修改成功！");
        } else {
            map.put("msg","该专业不存在！");
        }
        return JSON.toJSONString(map);
    }
    //8、删除专业
    @RequestMapping("/rest/admin/delete_profession")
    public String admin_delete_profession(String proname,Map<Object,String> map)
    {
        //先查找
        Profession profession = adminMapper.admin_get_profession(proname);
        if(profession!=null)     //有该专业，可以删除
        {
            adminMapper.admin_delete_profession(proname);
            map.put("msg","该专业删除成功！");
        }
        else
        {
            map.put("msg","该专业不存在");
        }
        return JSON.toJSONString(map);
    }

}
