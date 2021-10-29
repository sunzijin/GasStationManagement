<%--郭赵虎写--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>紧急救援</title>
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
            <el-table :data="tableData">
                <el-table-column property="data" label="故障类型" align="left" width="300"></el-table-column>
                <el-table-column property="name" label="处理方法" align="left" width=""></el-table-column>
            </el-table>
            <!--使用el-form组件进行数据添加和修改-->
            <el-form
                    ref="myform"
                    :model="mymodel"
                    label-width="150px"
                    style="margin:50px;width:auto;">
                <el-form-item label="" required>
                </el-form-item>
            </el-form>
        </div>
    </div>
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
                    data: '火灾',
                    name: '就近灭火器灭火，或者沙土掩盖，关闭加油电源 严重拨打119'
                },
                {
                    data: '下大雨有汛情',
                    name: '提前做好下水道清理工作，讲易受潮物质转移到高处，定期检查排水孔，有问题及时解决'
                },
                {
                    data: '遭遇高强度频繁闪电雷击',
                    name: '在加油时，立即停止加油，迅速关闭电源，疏散群众。'
                },
                {
                    data: '发生地震',
                    name: '及时停止加油，跑到空旷处避灾'
                },
                {
                    data: '油泄漏',
                    name: '及时清理回收防止土壤污染，起火'
                },
                {
                    data: '卸油时发生混油',
                    name: '立即关闭卸油阀，停止卸油'
                },
                {
                    data: '油品质量纠纷',
                    name: '加油人员及时向店长汇报，及时取样，确认无误，向顾客解释'
                }
            ],
            dialog: {
                title: '',
                show: false
            },
        },
        mymodel:{
            data: '',
            name: ''
        },
        methods: {

            //响应添加按钮
            onAdd: function () {
                //清空表单
                //alert("紧急救援");
                this.dialog.title = "";
                this.dialog.show = true;
            },
        }
    });
</script>
</body>
</html>