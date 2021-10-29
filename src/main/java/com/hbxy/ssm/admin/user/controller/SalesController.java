package com.hbxy.ssm.admin.user.controller;

import com.hbxy.ssm.admin.user.model.Gas;
import com.hbxy.ssm.admin.user.model.GasExample;
import com.hbxy.ssm.admin.user.model.Sales;
import com.hbxy.ssm.admin.user.model.SalesExample;
import com.hbxy.ssm.admin.user.service.GasService;
import com.hbxy.ssm.admin.user.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class SalesController {
    //注入service
    //方法一：通过autowired
    @Autowired
    SalesService salesService;
//    //方法二：通过构造器注入service
//    public UserLoginController(UserLoginService userLoginService){
//        this.userLoginService=userLoginService;
//    }

    @GetMapping("/saleslist")
    public String saleslist(){
        return "admin/sales_list";
    }

    @GetMapping("/maintain3")
    public String maintain(){
        return "app/maintain3";
    }

    @GetMapping("/sales")
    @ResponseBody
    public List<Sales> SelectSales(){
        //构造查询条件
        //创建查询条件类
        SalesExample example=new SalesExample();
        //创建条件构造器
        SalesExample.Criteria criteria=example.createCriteria();
        //通过criteria设置条件
        //criteria.andUserTypeEqualTo("1");
        //criteria.andCurrentStatusEqualTo("0");


        //2根据条件查询
        List<Sales> list=salesService.selectByExample(example);
        return list;
    }

    //设计到两个或两个以上的表的数据库操作：insert、delete、update
    //必须添加事务管理：使用spring的注解@Transactional

    @PutMapping("/sales")
    @ResponseBody
    //@Transactional
    public Sales updateSales(@RequestBody Sales sales){

        salesService.updateByPrimaryKeySelective(sales);

        return salesService.selectByPrimaryKey(sales.getsId());
    }

}
