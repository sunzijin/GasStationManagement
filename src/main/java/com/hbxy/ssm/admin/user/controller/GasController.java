package com.hbxy.ssm.admin.user.controller;

import com.hbxy.ssm.admin.user.model.Gas;
import com.hbxy.ssm.admin.user.model.GasExample;
import com.hbxy.ssm.admin.user.service.GasService;
import com.hbxy.ssm.util.IdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class GasController {
    //注入service
    //方法一：通过autowired
    @Autowired
    GasService gasService;
//    //方法二：通过构造器注入service
//    public UserLoginController(UserLoginService userLoginService){
//        this.userLoginService=userLoginService;
//    }

    @GetMapping("/gaslist")
    public String gaslist(){
        return "admin/gas_list";
    }

    @GetMapping("/vgas3")
    public String vgas(){
        return "app/vgas3";
    }

    @GetMapping("/ugas3")
    public String ugas(){
        return "app/ugas3";
    }

    @GetMapping("/gas")
    @ResponseBody
    public List<Gas> SelectGas(){
        //构造查询条件
        //创建查询条件类
        GasExample example=new GasExample();
        //创建条件构造器
        GasExample.Criteria criteria=example.createCriteria();
        //通过criteria设置条件
        //criteria.andUserTypeEqualTo("1");
        //criteria.andCurrentStatusEqualTo("0");


        //2根据条件查询
        List<Gas> list=gasService.selectByExample(example);
        return list;
    }

    //设计到两个或两个以上的表的数据库操作：insert、delete、update
    //必须添加事务管理：使用spring的注解@Transactional

    @PutMapping("/gas")
    @ResponseBody
    //@Transactional
    public Gas updateGas(@RequestBody Gas gas){

        gasService.updateByPrimaryKeySelective(gas);

        return gasService.selectByPrimaryKey(gas.getgId());
    }


}
