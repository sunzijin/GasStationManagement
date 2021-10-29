<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>登录</title>
  <!--2.1 引入element ui-->
  <link rel="stylesheet" href="/static/element-ui/index.css">
  <style>
    html, body{
      margin: 0;
      padding: 0;
      height:100%;
      font-size: 14px;
      /* html默认高度只有一行, 需要显式声明高度*/
    }
    .login {
      width:100%;
      height: 100%;
      margin:0;
      padding: 0;
      background-image: url("/static/custom/images/background.jpg");
      background-size: cover;
    }
    .loginCard {
      box-sizing: border-box;
      position: relative;
      top: 150px;
      width: 500px;
      margin: 0 auto;
      padding: 0 20px
    }
  </style>
</head>
<body>
<div id="app" class="login">
  <!--登录框div的样式-->
  <el-card class="loginCard" shadow="always">
    <el-form :model="mymodel"
             :rules="myrule"
             ref="loginForm">
      <el-form-item>
        <img src="/static/custom/images/my_gas.png" align="left" width="30%" height="30%">
        <font size="100px" style="font-weight:800;text-align: center" ><br>STATION</font>
      </el-form-item>

      <h2 style="text-align: center">小型加油站管理系统</h2>
      <el-form-item prop="userLoginId">
        <img src="/static/custom/images/my_regesit.png" width="10%" height="10%">
        <font><b>用户账号</b></font>
        <el-input
                type="text"
                v-model="mymodel.userLoginId"
                auto-complete="off"
                placeholder="登录账号">
        </el-input>
      </el-form-item>
      <el-form-item   prop="currentPassword">
        <img src="/static/custom/images/my_password.png" width="10%" height="10%">
        <font><b>用户密码</b></font>
        <el-input
                type="password"
                v-model="mymodel.currentPassword"
                auto-complete="off"
                placeholder="登录密码">
        </el-input>
      </el-form-item>
      <el-form-item align="center">copyright@ 2021海滨学院软件技术出品</el-form-item>
      <el-form-item>
        <el-button
                type="primary"
                @click="login('loginForm')"
                style="width: 100%">
          登 录
        </el-button>
      </el-form-item>
    </el-form>
  </el-card>
</div>
<!--1 引入vue-->
<script src="/static/vue/vue.js"></script>
<!--2.2 引入element ui-->
<script src="/static/element-ui/index.js"></script>
<!--3 引入axios-->
<script src="/static/axios/axios.js"></script>
<script src="/static/mx-config.js"></script>
<script>
  // 定义vue实例
  const app = new Vue({
    el: "#app",
    data:function()  {
      return{
        mymodel:{
          userId:'',
          userLoginId:'',
          currentPassword:'',
          userName:''
        },
        myrule:{
          userLoginId: [
            { required: true, message: '请输入登录账号', trigger: 'blur' },
          ],
          currentPassword: [
            { required: true, message: '请输入登录密码', trigger: 'blur' },
          ]
        }
      }
    },
    methods:{

      login:function (formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            //到后台验证用户
            axios.post('/login',this.mymodel).then(res =>{
              let loginInfo = res.data;
              if(loginInfo.loginStatus == '200') {
                //验证成功
                //创建一个本地会话，存放用户信息
                let userInfo = loginInfo.userInfo;
                localStorage.setItem("userInfo",JSON.stringify(userInfo));
                //如果是字符串，可以直接作为key-value设置
                localStorage.setItem("userName",userInfo.userName);
                localStorage.setItem("userId",userInfo.userId);
                //路由跳转:根据角色跳转到不同的入口
                if(userInfo.userType == '店长'){
                  //后台管理控制台（系统管理员）：页面框架
                  window.location.href='/admin/index';
                }else if(userInfo.userType == '销售人员'){
                  //前台应用（普通用户）：页面框架
                  window.location.href='/app/index1';
                }else if(userInfo.userType == '补货人员'){
                  //其他用户...
                  window.location.href='/app/index2';
                }
                else if(userInfo.userType == '服务人员'){
                  window.location.href='/app/index3';
                }
              } else {
                //验证失败
                this.$message({
                  message:'登录账号或密码错误，请重新登录！',
                  type:'error'
                })
                return false;
              }
            })
          } else {
            this.$message({
              message:'登录账号和密码不能为空！',
              type:'error'
            })
            return false;
          }
        });
      }
    }
  })
</script>
</body>
</html>