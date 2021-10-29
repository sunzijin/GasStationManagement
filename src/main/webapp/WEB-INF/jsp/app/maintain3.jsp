<%--黄翔写--%>
<!DOCTYPE html>
<html lang="en">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<head>
    <meta charset="UTF-8">
    <title>临时维修</title>
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
            <b>临时维修</b>&nbsp;&nbsp;&nbsp;&nbsp;
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
                        prop="wxType"
                        label="维修类型"
                        width="400"
                        align="center">
                </el-table-column>
                <el-table-column
                        prop="wxMoney"
                        label="维修价格"
                        width=""
                        align="center">
                </el-table-column>
                <el-table-column label="操作" align="right">
                    <template slot-scope="scope">
                        <el-button plain type="primary" @click="onweixiu(scope.$index)">维修</el-button>
                    </template>
                </el-table-column>
            </el-table>
        </div>
    </div>
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
                        wxType:'补轮胎',
                        wxMoney:400
                    },
                    {
                        wxType:'打气',
                        wxMoney:20
                    },
                    {
                        wxType:'加水',
                        wxMoney:50
                    },
                    {
                        wxType:'换机油',
                        wxMoney:200
                    }
                ],
                tempsMoney:'',
                /*mymodel: {
                    wxMoney:''
                },*/
                //设置一个变量，保存哪行数据被选中了
                selectItemIndex:-1
            }
        },
        mounted: function () {
            //初始化表格
            this.initTable();
        },
        sle: function(delay){
          for(var t=Date.now();Date.now()-t<=d;);
        },
        methods: {
            //初始化表格
            initTable:function(){
            //     //通过axios调用服务器json服务
            //     axios.get("/sales/").then(res => {
            //         this.tableData = res.data;
            //     });
                axios.get("/sales").then(res=>{
                    this.tempsMoney=res.data[0].sMoney;
                });
            },
            //响应维修按钮
            onweixiu:function (index) {

                this.$confirm('确认维修吗?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    // 维修
                    this.mymodel={
                        sId:'1',
                        sMoney:this.tempsMoney+this.tableData[index].wxMoney
                    }
                        axios.put("/sales/", this.mymodel).then(res => {
                            // 操作成功
                            this.$message({
                                message: "维修付费成功!",
                                type: "success"
                            });
                            this.sle(1000);
                            window.location.reload(true);
                        });
                }).catch(() => {
                });
            }

        }
    });
</script>
</body>
</html>

