package com.hbxy.ssm.admin.user.controller;

import com.hbxy.ssm.admin.user.model.Advise;
import com.hbxy.ssm.admin.user.model.AdviseExample;
import com.hbxy.ssm.admin.user.service.AdviseService;
import com.hbxy.ssm.util.IdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AdviseController {
    //注入service
    //方法一：通过autowired
    @Autowired
    AdviseService adviseService;
//    //方法二：通过构造器注入service
//    public UserLoginController(UserLoginService userLoginService){
//        this.userLoginService=userLoginService;
//    }

    @GetMapping("/feedback3")
    public String feedbacklist(){
        return "app/feedback3";
    }

    @GetMapping("/adviselist")
    public String adviselist(){
        return "admin/advise_list";
    }


    @GetMapping("/advise")
    @ResponseBody
    public List<Advise> SelectAdvise(){
        //构造查询条件
        //创建查询条件类
        AdviseExample example=new AdviseExample();
        //创建条件构造器
        AdviseExample.Criteria criteria=example.createCriteria();
        //通过criteria设置条件
        //criteria.andUserTypeEqualTo("1");
        //criteria.andCurrentStatusEqualTo("0");


        //2根据条件查询
        List<Advise> list=adviseService.selectByExample(example);
        return list;
    }

    //设计到两个或两个以上的表的数据库操作：insert、delete、update
    //必须添加事务管理：使用spring的注解@Transactional
    @PostMapping("/advise")
    @ResponseBody
    //@Transactional
    public Advise insertAdvise(@RequestBody Advise advise, HttpSession session){
        String id = IdUtil.nextId().toString();//雪花
        advise.setaId(id);

        adviseService.insertSelective(advise);

        return advise;
    }

}
