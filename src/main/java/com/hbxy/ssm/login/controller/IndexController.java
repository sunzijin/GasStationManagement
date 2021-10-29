package com.hbxy.ssm.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

@Controller
public class IndexController {
    //系统默认首页跳转到login.jsp页面
    @RequestMapping("/")
    public String index(Model model, HttpServletResponse response) {
        return "/login";
    }

    //后台管理控制台（系统管理员）：页面框架
    @GetMapping("/admin/index")
    public String adminIndex(){
        return "/admin/admin_index";
    }
    //后台管理控制台（系统管理员）：介绍页面
    @GetMapping("/admin/home")
    public String adminHome(){
        return "/admin/admin_home";
    }
    //前台应用（普通用户）：页面框架
    @GetMapping("/app/index1")
    public String appIndex1(){
        return "/app/app_index1";
    }
    //前台应用（普通用户）：介绍页面
    @GetMapping("/app/home1")
    public String appHome1(){
        return "/app/app_home1";
    }
    //前台应用（普通用户）：页面框架
    @GetMapping("/app/index2")
    public String appIndex2(){
        return "/app/app_index2";
    }
    //前台应用（普通用户）：介绍页面
    @GetMapping("/app/home2")
    public String appHome2(){
        return "/app/app_home2";
    }
    //前台应用（普通用户）：页面框架
    @GetMapping("/app/index3")
    public String appIndex3(){
        return "/app/app_index3";
    }
    //前台应用（普通用户）：介绍页面
    @GetMapping("/app/home3")
    public String appHome3(){
        return "/app/app_home3";
    }
    @GetMapping("/help3")
    public String help3(){ return "/app/help3";}
}
