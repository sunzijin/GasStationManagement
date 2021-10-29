<%--组长写--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>油品信息管理</title>
    <!--引入element css-->
    <link href="../static/element-ui/index.css" rel="stylesheet">
</head>
<body>
<div id="app">
    <b>油品列表</b>

    <el-table :data="tableData" stripe style="width: 90%">
        <el-table-column prop="" type="index" label="序号" width="50px"></el-table-column>
        <el-table-column prop="gName" label="油品型号" width="120px"></el-table-column>
        <el-table-column prop="gType" label="油品类型" width="120px">
            <template slot-scope="scope">
                <span v-if="scope.row.gType=='汽油'">汽油</span>
                <span v-if="scope.row.gType=='柴油'">柴油</span>
            </template>
        </el-table-column>
        <el-table-column prop="gUMoney" label="普通油价" width="120px"></el-table-column>
        <el-table-column prop="gVMoney" label="会员油价" width="120px"></el-table-column>
        <el-table-column prop="" label="操作">
            <template slot-scope="scope">
                <el-button type="primary" plain size="mini" @click="onEdit(scope.$index)">修改</el-button>
            </template>
        </el-table-column>
    </el-table>

    <!--修改用户信息对话框-->
    <el-dialog
            width="80%"
            :title="dialogEdit.title"
            :visible.sync="dialogEdit.show"
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
<%--            <el-form-item hidden prop='gId' label="ID:">--%>
<%--                <el-input type="string" v-model="mymodel.gId"></el-input>--%>
<%--            </el-form-item>--%>
            <!--修改-->
            <el-form-item prop='gUMoney' label="普通油价" required>
                <el-col :span="15">
                    <el-input type="float" v-model="mymodel.gUMoney"></el-input>
                </el-col>
            </el-form-item>
            <el-form-item prop='gVMoney' label="会员油价" required>
                <el-col :span="15">
                    <el-input type="float" v-model="mymodel.gVMoney"></el-input>
                </el-col>
            </el-form-item>

            <el-form-item class="text_right">
                <el-button type="primary" @click='onSubmitEdit("myformedit")'>保 存</el-button>
                <el-button @click="dialogEdit.show = false">取 消</el-button>
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
            dialogEdit:{
                title:'',
                show:false
            },
            //定义模型，与表单匹配
            mymodel:{
                gName:'',
                gType:'',
                gUMoney:'',
                gVMoney:''
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
                axios.get("/gas").then(res=>{
                    this.tableData=res.data;
                });
            },
            onEdit:function (index) {
                //进行数据回填---通过选中的index获得tableData里面的数据
                this.mymodel = {
                    gId: this.tableData[index].gId,
                    gName: this.tableData[index].gName,
                    gType:this.tableData[index].gType,
                    gUMoney:this.tableData[index].gUMoney,
                    gVMoney:this.tableData[index].gVMoney
                }

                //保存被选中的行 索引值
                this.selectItemIndex = index;

                //设置对话框可见
                this.dialogEdit.title = '修改油价';
                this.dialogEdit.show = true;
            },
            onSubmitEdit:function (form) {
                //保存到数据库
                axios.put("/gas/", this.mymodel).then(res =>{
                    // 操作成功
                    this.$message({
                        message: "修改成功！",
                        type: "success"
                    });

                    // 方法1:更新指定索引的元素
                    this.tableData.splice(this.selectItemIndex, 1, res.data);
                    // 方法2:数据重新从服务器加载table数据,这种方法效率差
                    // this.initTable();
                    // 关闭对话框
                    this.dialogEdit.show = false;
                })
            }
        }
    });
</script>
</body>
</html>