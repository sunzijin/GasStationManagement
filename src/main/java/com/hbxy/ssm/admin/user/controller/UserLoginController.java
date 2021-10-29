package com.hbxy.ssm.admin.user.controller;

import com.hbxy.ssm.admin.user.model.UserLogin;
import com.hbxy.ssm.admin.user.model.UserLoginExample;
import com.hbxy.ssm.admin.user.service.UserLoginService;
import com.hbxy.ssm.util.EncryptUtil;
import com.hbxy.ssm.util.IdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.List;

@Controller
public class UserLoginController {
    //注入service
    //方法一：通过autowired
    @Autowired
    UserLoginService userLoginService;
//    //方法二：通过构造器注入service
//    public UserLoginController(UserLoginService userLoginService){
//        this.userLoginService=userLoginService;
//    }


    @GetMapping("/userlist")
    public String userlist(){
        return "admin/user_list";
    }


    @GetMapping("/user")
    @ResponseBody
    public List<UserLogin> SelectUser(){
        //构造查询条件
        //创建查询条件类
        UserLoginExample example=new UserLoginExample();
        //创建条件构造器
        UserLoginExample.Criteria criteria=example.createCriteria();
        //通过criteria设置条件
        //criteria.andUserTypeEqualTo("1");
        //criteria.andCurrentStatusEqualTo("0");


        //2根据条件查询
        List<UserLogin> list=userLoginService.selectByExample(example);
        return list;
    }

    //设计到两个或两个以上的表的数据库操作：insert、delete、update
    //必须添加事务管理：使用spring的注解@Transactional
    @PostMapping("/user")
    @ResponseBody
    //@Transactional
    public UserLogin insertUser(@RequestBody UserLogin userLogin, HttpSession session){
        String id = IdUtil.nextId().toString();//雪花
        userLogin.setUserId(id);
        userLoginService.insertSelective(userLogin);

        return userLogin;
    }

    @PutMapping("/user")
    @ResponseBody
    //@Transactional
    public UserLogin updateUser(@RequestBody UserLogin userLogin){

        userLoginService.updateByPrimaryKeySelective(userLogin);

        return userLoginService.selectByPrimaryKey(userLogin.getUserId());
    }

    @DeleteMapping("/user/{id}")
    @ResponseBody
    public String delUser(@PathVariable("id") String userId){
        //真（硬）删除
        userLoginService.deleteByPrimaryKey(userId);

        //假删除
//        UserLogin userLogin = userLoginService.selectByPrimaryKey(userId);
//        userLogin.setCurrentStatus("99");//99-删除状态
//        userLoginService.updateByPrimaryKeySelective(userLogin);
        //返回状态码：由前后端约定
        return "200";
    }
}
