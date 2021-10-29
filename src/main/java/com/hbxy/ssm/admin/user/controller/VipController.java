package com.hbxy.ssm.admin.user.controller;

import com.hbxy.ssm.admin.user.model.Vip;
import com.hbxy.ssm.admin.user.model.VipExample;
import com.hbxy.ssm.admin.user.service.VipService;
import com.hbxy.ssm.util.IdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class VipController {
    //注入service
    //方法一：通过autowired
    @Autowired
    VipService vipService;
//    //方法二：通过构造器注入service
//    public UserLoginController(UserLoginService userLoginService){
//        this.userLoginService=userLoginService;
//    }

    @GetMapping("/viplist")
    public String viplist(){
        return "admin/vip_list";
    }

    @GetMapping("/viplist3")
    public String viplist3(){
        return "app/vip3_list";
    }


    @GetMapping("/vip")
    @ResponseBody
    public List<Vip> SelectVip(){
        //构造查询条件
        //创建查询条件类
        VipExample example=new VipExample();
        //创建条件构造器
        VipExample.Criteria criteria=example.createCriteria();
        //通过criteria设置条件
        //criteria.andUserTypeEqualTo("1");
        //criteria.andCurrentStatusEqualTo("0");


        //2根据条件查询
        List<Vip> list=vipService.selectByExample(example);
        return list;
    }

    //设计到两个或两个以上的表的数据库操作：insert、delete、update
    //必须添加事务管理：使用spring的注解@Transactional
    @PostMapping("/vip")
    @ResponseBody
    //@Transactional
    public Vip insertVip(@RequestBody Vip vip, HttpSession session){
        String id = IdUtil.nextId().toString();//雪花
        vip.setvId(id);

        vipService.insertSelective(vip);

        return vip;
    }

    @PutMapping("/vip")
    @ResponseBody
    //@Transactional
    public Vip updateVip(@RequestBody Vip vip){

        vipService.updateByPrimaryKeySelective(vip);

        return vipService.selectByPrimaryKey(vip.getvId());
    }

    @DeleteMapping("/vip/{id}")
    @ResponseBody
    public String delVip(@PathVariable("id") String vipId){
        //真（硬）删除
        vipService.deleteByPrimaryKey(vipId);

        //假删除
//        UserLogin userLogin = userLoginService.selectByPrimaryKey(userId);
//        userLogin.setCurrentStatus("99");//99-删除状态
//        userLoginService.updateByPrimaryKeySelective(userLogin);
        //返回状态码：由前后端约定
        return "200";
    }
}
