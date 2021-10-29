<%--黄翔写--%>
<!DOCTYPE html>
<html lang="en">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<head>
    <meta charset="UTF-8">
    <title>会员加油</title>
    <!--2.1 引入element ui-->
    <link rel="stylesheet"
          href="../../../static/element-ui/index.css">
    <link rel="stylesheet"
          href="../../../static/custom/el-custom.css">
</head>
<body>
<!--挂载vue实例-->
<div id="app">
    <!--页面内容区域-->
    <div class="mx-main-content">
        <div class="mx-table-title">
            <b>会员加油</b>&nbsp;&nbsp;&nbsp;&nbsp;
        </div>
        <div class="el-divider">
            <el-divider></el-divider>
        </div>
        <div class="mx-table-content">
            <!--      v-if=v-if"tableData.length > 0"-->
            <el-table
                    :data="tableData"
                    stripe
                    style="width: 100%">
                <el-table-column
                        type="index"
                        prop=""
                        label="序号"
                        width="90"
                        align="center">
                </el-table-column>
                <el-table-column
                        prop="gName"
                        label="油品型号"
                        width="200"
                        align="center">
                </el-table-column>
                <el-table-column
                        prop="gType"
                        label="油品类型"
                        width="200"
                        align="center">
                </el-table-column>
                <el-table-column
                        prop="gVMoney"
                        label="会员油价"
                        width="200"
                        align="center">
                </el-table-column>
                <el-table-column label="操作" align="right">
                    <template slot-scope="scope">
                        <el-button plain type="primary" @click="onRefuel(scope.$index)">加油</el-button>
                    </template>
                </el-table-column>
            </el-table>
        </div>
    </div>
    <el-dialog
            width="80%"
            :title="dialog.title"
            :visible.sync="dialog.show"
            :close-on-click-modal='false'
            :close-on-press-escape='false'
            :modal-append-to-body='false'>
        <!--使用el-form组件进行数据添加和修改-->
        <el-form
                ref="myform"
                :model="mymodel"
                label-width="150px"
                style="margin:10px;width:auto;">
            <el-form-item prop='gasnum' label="加油数量/L:">
                <el-col :span="15">
                    <el-input type="text" min="0" v-model="mymodel.gasnum"></el-input>
                </el-col>
            </el-form-item>
            <el-form-item class="text_right">
                <el-button type="primary" @click='onSubmitAddL("myform")'>加油送礼</el-button>
                <el-button type="primary" @click='onSubmitAddX("myform")'>加油洗车</el-button>
                <el-button @click="dialog.show = false">取 消</el-button>
            </el-form-item>
        </el-form>
    </el-dialog>
</div>
<!--1 引入vue-->
<script src="../../../static/vue/vue.js"></script>
<!--2.2 引入element ui-->
<script src="../../../static/element-ui/index.js"></script>
<!--3 引入axois-->
<script src="../../../static/axios/axios.js"></script>
<script src="../../../static/mx-config.js"></script>
<script>
    // 定义vue实例
    var app = new Vue({
        el: "#app",
        data: function () {
            return {
                tableData:[
                    {
                        gName:'111',
                        gType:'111',
                        gVMoney:'111'
                    }
                ],
                tempsMoney:'',
                dialog:{
                    title:'',
                    show:false
                },
                mymodel: {
                    gasnum:''
                },
                mymodel1:{
                    gId:'',
                    gName: '',
                    gType: '',
                    gVMoney: '',
                },
                //设置一个变量，保存哪行数据被选中了
                selectItemIndex:-1
            }
        },
        mounted: function () {
            //初始化表格
            this.initTable();
        },
        methods: {
            //初始化表格
            initTable:function(){
                //通过axios调用服务器json服务
                axios.get("/gas/").then(res => {
                    this.tableData = res.data;
                });
            },
            //响应加油按钮
            onRefuel:function (index) {
                this.$confirm('确认加此号油吗?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    // 加油
                    this.mymode={
                        gasnum:''
                    }
                    this.mymodel1={
                        gId:this.tableData[index].gId,
                        gName:this.tableData[index].gName,
                        gType:this.tableData[index].gType,
                        gVMoney:this.tableData[index].gVMoney
                    }
                    axios.get("/sales").then(res=>{
                        this.tempsMoney=res.data[0].sMoney;
                    });
                    this.dialog.title="加油";
                    this.dialog.show = true;
                }).catch(() => {

                });
                this.mymodel={
                    gasnum: ''
                }
            },
            //响应注册用户对话框 保存按钮
            onSubmitAddL:function (index) {
                this.mymodel2={
                    sId:'1',
                    sMoney:this.tempsMoney+(this.mymodel1.gVMoney*this.mymodel.gasnum)
                }
                if(this.mymodel.gasnum<=0)
                {
                    this.$message({
                        message: "请输入正确的加油数量！",
                        type: "error"
                    });
                }
                else{
                    //把表单数据提交到 后台 ，保存到数据库
                    //添加,调用post方法
                    axios.put("/sales/", this.mymodel2).then(res => {
                        // 操作成功
                        this.$message({
                            message: "此次加油费用为:"+this.mymodel1.gVMoney*this.mymodel.gasnum+"元，并可以到商店兑换礼品！",
                            type: "success"
                        });
                        //方法1:更新table
                        // this.tableData.push(res.data);
                        //方法2:更新table:在最后添加一个元素,0表示添加
                        //this.tableData.splice(this.tableData.length,0,res.data);
                        //方法3 重新加载
                        //this.initTable();
                        //关闭对话框
                        this.dialog.show = false;
                    });
                }
            },
            onSubmitAddX:function (index) {
                this.mymodel2={
                    sId:'1',
                    sMoney:this.tempsMoney+(this.mymodel1.gVMoney*this.mymodel.gasnum)
                }
                if(this.mymodel.gasnum<=0)
                {
                    this.$message({
                        message: "请输入正确的加油数量！",
                        type: "error"
                    });
                }else{
                    //把表单数据提交到 后台 ，保存到数据库
                    //添加,调用post方法
                    axios.put("/sales/", this.mymodel2).then(res => {
                        // 操作成功
                        this.$message({
                            message: "此次加油费用为:"+this.mymodel1.gVMoney*this.mymodel.gasnum+"元，并获得洗车卷一张！",
                            type: "success"
                        });
                        //方法1:更新table
                        // this.tableData.push(res.data);
                        //方法2:更新table:在最后添加一个元素,0表示添加
                        //this.tableData.splice(this.tableData.length,0,res.data);
                        //方法3 重新加载
                        //this.initTable();
                        //关闭对话框
                        this.dialog.show = false;
                    });
                }
            }
        }
    });
</script>
</body>
</html>
