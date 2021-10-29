<%--组长写--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户反馈管理</title>
    <!--引入element css-->
    <link href="../static/element-ui/index.css" rel="stylesheet">
</head>
<body>
<div id="app">
    <b>用户反馈</b>
    <el-table :data="tableData" stripe style="width: 90%">
        <el-table-column prop="" type="index" label="序号" align="center" ></el-table-column>
        <el-table-column prop="" label="操作" align="right">
            <template slot-scope="scope">
                <el-button type="primary" plain size="mini" @click="onSee(scope.$index)">查看</el-button>
            </template>
        </el-table-column>
    </el-table>
    <!--查看信息信息对话框-->
    <el-dialog
            width="80%"
            :title="dialog.title"
            :visible.sync="dialog.show"
            :close-on-click-modal='false'
            :close-on-press-escape='false'
            :modal-append-to-body='false'>

        <!--使用el-form组件进行数据添加和修改-->
        <!--:rules="myrulesEdit"设置表单检验规则-->
        <el-form
                ref="myformedit"
                :model="mymodel"
                label-width="150px"
                style="margin:10px;width:auto;">
            <el-form-item hidden prop='aId' label="ID:">
                <el-input type="string" v-model="mymodel.aId"></el-input>
            </el-form-item>
            <!--查看-->
            <el-form-item label="用户反馈">
                <el-col :span="15">
                    <el-form-item prop='aDialog'>
                        <el-input type="textarea" readonly :rows="10" v-model="mymodel.aDialog"></el-input>
                    </el-form-item>
                </el-col>
            </el-form-item>

            <el-form-item class="text_right">
                <el-button @click="dialog.show = false">退 出</el-button>
            </el-form-item>
        </el-form>

    </el-dialog>
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
                aId:'',
                aDialog:''
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
                axios.get("/advise").then(res=>{
                    this.tableData=res.data;
                });
            },
            onSee:function (index) {
                //进行数据回填---通过选中的index获得tableData里面的数据
                this.mymodel = {
                    aId:this.tableData[index].aId,
                    aDialog: this.tableData[index].aDialog
                }

                //保存被选中的行 索引值
                this.selectItemIndex = index;

                //设置对话框可见
                this.dialog.title = '查看用户反馈信息';
                this.dialog.show = true;
            }
        }
    });
</script>
</body>
</html>