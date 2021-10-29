<%--组长写--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>销售信息管理</title>
    <!--引入element css-->
    <link href="../static/element-ui/index.css" rel="stylesheet">
</head>
<body>
<div id="app">
    <b>加油站营业额</b>
    <el-table :data="tableData" stripe style="width: 90%">
        <el-table-column prop="" type="index" label="序号" width="200px" ></el-table-column>
        <el-table-column prop="sMoney" label="营业额" align="right"></el-table-column>
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
            //定义模型，与表单匹配
            mymodel:{
                sId:'',
                sMoney:''
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
                axios.get("/sales").then(res=>{
                    this.tableData=res.data;
                });
            },
        }
    });
</script>
</body>
</html>