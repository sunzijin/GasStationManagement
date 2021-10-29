<%--张秩写--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>商品管理</title>
    <!--引入element css-->
    <link href="../static/element-ui/index.css" rel="stylesheet">
</head>
<body>
<div id="app">
    <b>商品列表</b>
    <el-table :data="tableData" stripe style="width: 90%">
        <el-table-column prop="" type="index" label="序号" width="80px"></el-table-column>
<%--        <el-table-column prop="oId" label="商品编号" width="100"></el-table-column>--%>
        <el-table-column prop="oName" label="商品名" width="120"></el-table-column>
        <el-table-column prop="oCount" label="商品数量" width="120"></el-table-column>
        <el-table-column prop="oPrice" label="商品价格" width="150"></el-table-column>
        <el-table-column prop="oFactory" label="生产工厂" width="150"></el-table-column>
        <el-table-column prop="" label="操作">
            <template slot-scope="scope">
                <el-button size="mini" plain type="primary" @click="onEdit(scope.$index),onDat(scope.$index)">购买</el-button>
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
            <!--如果是修改,则账号为只读-->
<%--            <el-form-item label="商品编号">--%>
<%--                <el-col :span="15">--%>
<%--                    <el-form-item prop='oId' >--%>
<%--                        <el-input type="string" readonly v-model="mymodel.oId"></el-input>--%>
<%--                    </el-form-item>--%>
<%--                </el-col>--%>
<%--            </el-form-item>--%>
            <el-form-item label="商品名">
                <el-col :span="15">
                    <el-form-item prop='oName'>
                        <el-input type="string" readonly v-model="mymodel.oName"></el-input>
                    </el-form-item>
                </el-col>
            </el-form-item>

            <el-form-item label="商品价格">
                <el-col :span="15">
                    <el-form-item prop='oPrice'>
                        <el-input type="float" readonly v-model="mymodel.oPrice"></el-input>
                    </el-form-item>
                </el-col>
            </el-form-item>
            <el-form-item label="生产厂家">
                <el-col :span="15">
                    <el-form-item prop='oFactory'>
                        <el-input type="string" readonly v-model="mymodel.oFactory"></el-input>
                    </el-form-item>
                </el-col>
            </el-form-item>
            <br>
            <el-form-item label="购买数量">
                <el-col :span="15">
                    <el-form-item prop='oCount'>
                        <el-input type="int" min="0" v-model="mymodel.oCount"></el-input>
                    </el-form-item>
                </el-col>
            </el-form-item>

            <el-form-item class="text_right">
                <el-button type="primary" @click='onSubmitEdit("myformedit")'>购 买</el-button>
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
                {
                    oId: '',
                    oName: '',
                    oCount: '',
                    oPrice: '',
                    oFactory: '',
                    // sId:'1',
                    // sMoney: ''
                }
            ],
            dialogEdit:{
                title:'',
                show: false
            },
            //控制对话框
            //定义模型，与表单匹配
            mymodel:{
                oId: '',
                oName: '',
                oCount: '',
                oPrice: '',
                oFactory: '',
                sId: '1',
                sMoney: ''
            },
            tempsMoney:'',

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
                axios.get("/ob").then(res=>{
                    this.tableData=res.data;
                })
            },
            // 原数据库数据1
            onDat:function(index){
                this.mymodelO={
                    oId:this.tableData[index].oId,
                    oName: this.tableData[index].oName,
                    oCount: this.tableData[index].oCount,
                    oPrice: this.tableData[index].oPrice,
                    oFactory:this.tableData[index].oFactory,
                };
                //保存被选中的行 索引值
                this.selectItemIndex = index;
            },
            //响应修改按钮
            onEdit:function (index) {
                //进行数据回填---通过选中的index获得tableData里面的数据
                // 修改后的数据库数据
                this.mymodel = {
                    oId:this.tableData[index].oId,
                    oName: this.tableData[index].oName,
                    oCount: this.tableData[index].oCount,
                    oPrice: this.tableData[index].oPrice,
                    oFactory:this.tableData[index].oFactory
                };

                axios.get("/sales").then(res=>{
                    this.tempsMoney=res.data[0].sMoney;
                });

                //保存被选中的行 索引值
                this.selectItemIndex = index;
                //设置对话框可见
                this.dialogEdit.title = '购买商品信息';
                this.dialogEdit.show = true;
            },
            //响应修改对话框 保存按钮
            onSubmitEdit:function (form) {
                //购买的价格
                this.mymodel3={
                    sId:'1',
                    sMoney:this.tempsMoney+(this.mymodel.oCount*this.mymodel.oPrice)
                };
                //最新的商品数量
                this.mymodel2={
                    oId:this.mymodelO.oId,
                    oCount:(this.mymodelO.oCount)-(this.mymodel.oCount)
                };
                //保存到数据库
                axios.put("/ob/", this.mymodel2).then(res =>{
                    if(this.mymodel2.oCount<0){
                        this.$message({
                            message: "库存不足，购买失败！",
                            type: "error"
                        });
                    }
                    else if(this.mymodel.oCount<=0){
                        this.$message({
                            message: "请输入正确购买数！",
                            type: "error"
                        });
                    }
                    else{
                        // 操作成功
                        this.$message({
                            message: "购买成功！",
                            type: "success"
                        });
                        // 方法1:更新指定索引的元素
                        this.tableData.splice(this.selectItemIndex, 1, res.data);
                        // 方法2:数据重新从服务器加载table数据,这种方法效率差
                        // this.initTable();
                        // 关闭对话框
                        this.dialogEdit.show = false;
                    }
                });
                if(this.mymodel2.oCount >= 0 && this.mymodel.oCount > 0)
                {
                    axios.put("/sales/", this.mymodel3).then(res => {
                        // 操作成功
                        this.$message({
                            message: "消费成功！",
                            type: "success"
                        });
                        // 方法1:更新指定索引的元素
                        this.tableData.splice(this.selectItemIndex, 1, res.data);
                        // 方法2:数据重新从服务器加载table数据,这种方法效率差
                        // this.initTable();
                    });
                }

                }
            }
    }
    );
</script>
</body>
</html>