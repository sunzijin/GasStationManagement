<%--郭赵虎写--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户反馈</title>
    <!--引入element css-->
    <link rel="stylesheet" href="../static/element-ui/index.css">
    <link rel="stylesheet" href="../static/custom/el-custom.css">
</head>
<body>
<!--挂载vue实例-->
<div id="app">
    <!--页面内容区域-->
    <div class="mx-main-content">
        <div class="mx-table-title">
            <b>反馈信息</b>
            <el-button type="primary" size="mini" @click="onAdd()">添加反馈</el-button>
        </div>
        <div class="el-divider">
            <el-divider></el-divider>
        </div>
        <div class="mx-table-content">
            <el-table :data="tableData" stripe style="width: 90%">
                <el-table-column prop="" type="index" label="序号" width="80px"></el-table-column>
                <el-table-column prop="aDialog" label="内容" align="right"></el-table-column>
            </el-table>
        </div>
    </div>
    <!--反馈用户对话框-->
    <el-dialog
            width="70%"
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
                style="margin:50px;width:auto;">

            <el-form-item label="反馈内容" required>
                <el-col :span="15">
                    <el-form-item prop='aDialog'>
                        <!--<el-input type="string" v-model="mymodel.aId"></el-input>-->

                        <el-input
                                type="textarea"
                                :rows="5"
                                placeholder="请输入内容"
                                v-model="mymodel.aDialog">
                        </el-input>

                    </el-form-item>
                </el-col>
            </el-form-item>

            <el-form-item class="text_right">
                <el-button type="primary" @click='onSubmitAdd("myform")'>提交</el-button>
                <el-button @click="dialog.show = false">取 消</el-button>
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
        el: "#app",
        data: {
            tableData: [
                {
                    aId: '1',
                    aDialog: '1'
                }
            ],
            dialog: {
                title: '',
                show: false
            },
            //控制对话框
            //定义模型，与表单匹配
            mymodel: {
                aDialog: ''
            },
            //设置一个变量，保存哪行数据被选中了
            selectItemIndex: -1
        },
        mounted: function () {
            //初始化表格
            this.initTable();
        },
        methods: {
            //初始化表格
            initTable: function () {
                axios.get("/advise").then(res => {
                    this.tableData = res.data;
                });
            },


            //响应添加按钮
            onAdd: function () {
                //清空表单
                this.mymodel = {
                    aDialog: ''
                };

                //alert("用户反馈");
                this.dialog.title = "用户反馈";
                this.dialog.show = true;
            },
            //响应用户反馈对话框 保存按钮
            onSubmitAdd: function (form) {
                //把表单数据提交到 后台 ，保存到数据库
                //添加,调用post方法
                axios.post("/advise/", this.mymodel).then(res => {
                    // 操作成功
                    this.$message({
                        message: "保存成功！",
                        type: "success"
                    });
                    //方法1:更新table
                    this.tableData.push(res.data);
                    //方法2:更新table:在最后添加一个元素,0表示添加
                    //this.tableData.splice(this.tableData.length,0,res.data);
                    //方法3 重新加载
                    //this.initTable();

                    //关闭对话框
                    this.dialog.show = false;

                });
            },


        }
    });
</script>

<script>
    export default {
        data() {
            return {
                textarea: ''
            }
        }
    }
</script>

</body>
</html>