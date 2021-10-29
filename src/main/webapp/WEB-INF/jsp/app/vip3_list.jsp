<%--组长写--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>VIP管理</title>
  <!--引入element css-->
  <link href="../static/element-ui/index.css" rel="stylesheet">
</head>
<body>
<div id="app">
  <b>VIP列表</b>
  <el-table :data="tableData" stripe style="width: 90%">
    <el-table-column prop="" type="index" label="序号" width="50px"></el-table-column>
    <el-table-column prop="vId" label="会员账号" width="100px"></el-table-column>
    <el-table-column prop="vName" label="姓名" width="100px"></el-table-column>
    <el-table-column prop="vSex" label="性别" width="100px"></el-table-column>
    <el-table-column prop="vPhone" label="电话" width="100px"></el-table-column>
    <el-table-column prop="" label="操作">
      <template slot-scope="scope">
        <el-button type="primary" plain size="mini" @click="onTiao()">加油</el-button>
      </template>
    </el-table-column>
  </el-table>
</div>
<!--引入vue、element、axios-->
<script src="../static/vue/vue.js"></script>
<script src="../static/element-ui/index.js"></script>
<script src="../static/axios/axios.js"></script>
<script src="../static/mx-config.js"></script>
<script>
  const myapp=new Vue({
    el:"#app",
    data:{
      tableData:[
        // {
        //   userId:'1111111',
        //   userLoginId:'admin',
        //   currentPassword:'1111',
        //   userName:'系统管理员admin',
        //   email:'admin@hbxy.cn',
        //   mobile:'18888888888',
        //   userType:'1',
        //   currentStatus:'0'
        // },
        // {
        //   userId:'22222',
        //   userLoginId:'zhansan',
        //   currentPassword:'1111',
        //   userName:'张三',
        //   email:'zhangsan@hbxy.cn',
        //   mobile:'18888888888',
        //   userType:'0',
        //   currentStatus:'0'
        // },
        // {
        //   userId:'33333',
        //   userLoginId:'lisi',
        //   currentPassword:'1111',
        //   userName:'李四',
        //   email:'lisi@hbxy.cn',
        //   mobile:'18888888888',
        //   userType:'0',
        //   currentStatus:'1'
        // }
      ],
      //控制对话框
      dialog:{
        title:'',
        show:false
      },
      dialogEdit:{
        title:'',
        show:false
      },
      //定义模型，与表单匹配
      mymodel:{
        vId:'',
        vName:'',
        vSex:'',
        vPhone:''
      },
      //设置一个变量，保存哪行数据被选中了
      selectItemIndex:-1
    },
    mounted:function(){
      //初始化表格
      this.initTable();
    },
    methods:{
      //初始化表格
      initTable:function(){
        axios.get("/vip").then(res=>{
          this.tableData=res.data;
        });
      },
      onTiao:function () {
        //进行界面跳转
        window.location.href='/vgas3';
      }
    }
  });
</script>
</body>
</html>