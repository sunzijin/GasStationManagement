package com.hbxy.ssm.admin.user.controller;

import com.hbxy.ssm.admin.user.model.Ob;
import com.hbxy.ssm.admin.user.model.ObExample;
import com.hbxy.ssm.admin.user.service.ObService;
import com.hbxy.ssm.util.IdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ObController {
    //注入service
    //方法一：通过autowired
    @Autowired
    ObService obService;
//    //方法二：通过构造器注入service
//    public UserLoginController(UserLoginService userLoginService){
//        this.userLoginService=userLoginService;
//    }

    @GetMapping("/oblist2")
    public String oblist2(){
        return "app/ob2_list";
    }

    @GetMapping("/oblist1")
    public String oblist1(){
        return "app/ob1_list";
    }

    @GetMapping("/ob")
    @ResponseBody
    public List<Ob> SelectOb(){
        //构造查询条件
        //创建查询条件类
        ObExample example=new ObExample();
        //创建条件构造器
        ObExample.Criteria criteria=example.createCriteria();
        //通过criteria设置条件
        //criteria.andUserTypeEqualTo("1");
        //criteria.andCurrentStatusEqualTo("0");


        //2根据条件查询
        List<Ob> list=obService.selectByExample(example);
        return list;
    }

    //设计到两个或两个以上的表的数据库操作：insert、delete、update
    //必须添加事务管理：使用spring的注解@Transactional
    @PostMapping("/ob")
    @ResponseBody
    //@Transactional
    public Ob insertOb(@RequestBody Ob ob, HttpSession session){
        String id = IdUtil.nextId().toString();//雪花
        ob.setoId(id);

        obService.insertSelective(ob);

        return ob;
    }

    @PutMapping("/ob")
    @ResponseBody
    //@Transactional
    public Ob updateOb(@RequestBody Ob ob){

        obService.updateByPrimaryKeySelective(ob);

        return obService.selectByPrimaryKey(ob.getoId());
    }

    @DeleteMapping("/ob/{id}")
    @ResponseBody
    public String delOb(@PathVariable("id") String obId){
        //真（硬）删除
        obService.deleteByPrimaryKey(obId);

        //假删除
//        UserLogin userLogin = userLoginService.selectByPrimaryKey(userId);
//        userLogin.setCurrentStatus("99");//99-删除状态
//        userLoginService.updateByPrimaryKeySelective(userLogin);
        //返回状态码：由前后端约定
        return "200";
    }
}
