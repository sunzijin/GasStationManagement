<%--商品销售功能-----孙子晋小组张秩负责--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>首页</title>
  <!--2.1 引入element ui-->
  <link rel="stylesheet"
        href="/static/element-ui/index.css">
  <!--在element-UI中使用fontawesome-->
  <link href="/static/fontawesome/css/all.min.css"
        rel="stylesheet">
  <style type="text/css">
    /*在element-UI中使用fontawesome*/
    [class^="el-icon-fa"], [class*=" el-icon-fa"] {
      display:inline-block;
      font-family:"FontAwesome"!important;
      font-style:normal;
      font-weight:normal;
      line-height:1;
      -webkit-font-smoothing:antialiased;
      -moz-osx-font-smoothing:grayscale
    }
    html, body {
      margin: 0;
      padding: 0;
      height: 100%;
      font-size: 14px;
      /* html默认高度只有一行, 需要显式声明高度*/
    }

    /*布局开始*/
    .body-container {
      box-sizing: border-box;
      height: 100vh;
      width: 1200px;
      margin: auto;
      padding: 0;
      border-style: solid;
      border-color: #eee;
      border-width: 0;
    }

    .el-header {
      box-sizing: border-box;
      margin: 0;
      padding: 0;
      border: 0;
      background-color: #333333;
      color: #FFFFCC;
      text-align: right;
      line-height: 56px;
    }

    .main-container {
      box-sizing: border-box;
      height: calc(100% - 56px);
      width: 100%;
      margin: 0;
      padding: 0;
      border: 0;
    }

    .el-aside {
      margin: 0;
      padding: 0;
      height: 100%;
      box-sizing: border-box;
      border: 0;
    }

    .el-main {
      box-sizing: border-box;
      margin: 0;
      padding: 10px;
      height: 100%;
      width: calc(100% - 230px);
      border-right: 1px solid #eee;
    }

    /*布局结束*/
    /*菜单导航开始*/
    /*logo*/
    .logo-title {
      width: 230px;
      height: 56px;
      line-height: 56px;
      text-align: center;
      background-color: #333333;
      color: #FFFFCC;
    }

    .el-menu {
      margin: 0;
      padding: 0;
      width: 100%;
      height: 100%;
      border: 0;
      background-color: #333333;
    }

    .el-submenu {
      margin: 0;
      padding: 0;
      border: 0;
    }

    /*打开,选中子菜单*/
    .el-submenu.is-opened, .el-submenu.is-active {
      background-color: #333333;
    !important /*!important使得优先级最大*/
    }

    /*鼠标滑过子菜单标题*/
    .el-submenu__title:hover {
      background-color: #333333;
    !important /*!important使得优先级最大*/
    }

    /*鼠标滑过菜单项*/
    .el-menu-item:hover {
      cursor: pointer;
      background-color: #FFFFCC;
    }

    /*选中激活菜单项*/
    .el-menu-item.is-active {
      cursor: pointer;
      background-color: #FFFFCC;
    }

    /*菜单导航结束*/
    /*内容框架定义*/
    .mx-iframe {
      width: 100%;
      height: 100%;
    }

    /*内容框架定义结束*/
  </style>
</head>
<body>
<div id="app">
  <el-container class="body-container">
    <el-header height="56px">
      <div style="width:100%;box-sizing:border-box;margin: 0;padding: 0">
        <el-row :gutter="20">
          <el-col :span="4" style="text-align: center;font-size: large">
            销售管理
          </el-col>
          <el-col :span="16">&nbsp;</el-col>
          <el-col :span="4">
            <span style="text-align: right; font-size: 12px; padding-right:10px">
                <i class="fa fa-user-circle"></i>
                {{ userInfo.userName }}&nbsp;&nbsp;
                <i title="退出系统" @click="logout" style="cursor: pointer" class="fa fa-sign-out-alt"></i>
            </span>
          </el-col>
        </el-row>
      </div>
    </el-header>
    <el-container class="main-container">
      <!--左侧导航-->
      <el-aside width="230px">
        <el-menu text-color="#BFCBD9"
                 active-text-color="#BFCBD9"
                 :default-active="activeMenuItem">
          <el-submenu index="1">
            <template slot="title">购买商品</template>
            <el-menu-item index="1-1" @click="menuItemClick('https://www.hao123.com/','百度')">百度一下，你就知道</el-menu-item>
            <el-menu-item index="1-2" @click="menuItemClick('/oblist1','商品销售')">商品销售</el-menu-item>
          </el-submenu>
          <el-submenu index="2">
            <template slot="title">紧急救援</template>
            <el-menu-item index="2-1" @click="menuItemClick('/help3','紧急求救')">紧急求救</el-menu-item>
          </el-submenu>
        </el-menu>
      </el-aside>
      <el-main>
        <iframe name="mxiframe" id="mxiframe" class="mx-iframe"
                src="/app/home1"
                frameborder="0"
                align="left"
                scrolling="auto">
          <p>您的浏览器不支持iframe标签,请换成chrome或firefox浏览器使用本应用</p>
        </iframe>
      </el-main>
    </el-container>
  </el-container>
</div>
<!--1 引入vue-->
<script src="/static/vue/vue.js"></script>
<!--2.2 引入element ui-->
<script src="/static/element-ui/index.js"></script>
<!--3 引入axios-->
<script src="/static/axios/axios.js"></script>
<script src="/static/mx-config.js"></script>
<script>
  const app = new Vue({
    el: "#app",
    data: function () {
      return {
        //激活的菜单项
        activeMenuItem: "1,1",
        activeMenuItem: "1,2",
        activeMenuItem:"2,1",
        userInfo: {
          userId: '',
          userLoginId: '',
          currentPassword: '',
          userName: ''
        }
      }
    },
    mounted() {
      this.userInfo = JSON.parse(localStorage.getItem('userInfo'))
    },
    methods: {
      menuSelect: function (key, keyPath) {
        //this.activeMenuItem = key;
        //console.log(key, keyPath);
      },
      //点击导航菜单项,添加一个标签,加载指定的url页面
      menuItemClick: function (url, menuName) {
        const myframe = document.getElementById('mxiframe');
        myframe.src = url;
      },
      logout: function () {
        axios.get("/logout").then(res =>{
          console.log(res.data)
          localStorage.removeItem('userInfo');
          window.location.href = '/login';
        });
      }
    }
  });

</script>
</body>
</html>