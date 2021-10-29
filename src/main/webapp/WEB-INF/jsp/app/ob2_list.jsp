<%--张昊写--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>商品管理</title>
    <!--2.1 引入element ui-->
    <link rel="stylesheet"
          href="../static/element-ui/index.css">
    <link rel="stylesheet"
          href="../static/custom/el-custom.css">
</head>
<body>
<!--挂载vue实例-->
 <div id="app">
    <!--页面内容区域-->
    <div class="mx-main-content">
        <div class="mx-table-title">
            商品列表&nbsp;&nbsp;&nbsp;
            <el-button type="primary" size="mini" @click="onAdd()">添加</el-button>
        </div>
        <div class="el-divider">
            <el-divider></el-divider>
        </div>
        <div class="mx-table-content">
            <!--      v-if=v-if"tableData.length > 0"-->
            <el-table :data="tableData" stripe style="width: 90%">
                <el-table-column type="index" prop="" label="序号" width="50px"></el-table-column>
                <el-table-column prop="oName" label="商品名称" width="150px"></el-table-column>
                <el-table-column prop="oCount" label="商品数量" width="150px"></el-table-column>
                <el-table-column prop="oPrice" label="商品价格" width="150px"></el-table-column>
                <el-table-column prop="oFactory" label="生产厂" width="150px"></el-table-column>
                <el-table-column prop="" label="操作" align="right">
                    <template slot-scope="scope">
                        <el-button plain size="mini"  type="primary" @click="onEdit(scope.$index)">补货</el-button>
                        <el-button plain size="mini"  type="danger" @click="onDelete(scope.$index)">下架</el-button>
                    </template>
                </el-table-column>
            </el-table>
        </div>
    </div>
    <!--注册用户对话框-->
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
            <el-form-item label="商品名称" required>
                <el-col :span="15">
                    <el-form-item prop='oName'>
                        <el-input type="string" v-model="mymodel.oName"></el-input>
                    </el-form-item>
                </el-col>
            </el-form-item>
            <el-form-item prop='oCount' label="商品数量:">
                <el-col :span="15">
                    <el-input type="int" v-model="mymodel.oCount"></el-input>
                </el-col>
            </el-form-item>
            <el-form-item prop='oPrice' label="商品价格:">
                <el-col :span="15">
                    <el-input type="float" v-model="mymodel.oPrice"></el-input>
                </el-col>
            </el-form-item>
            <el-form-item prop='oFactory' label="生产厂:">
                <el-col :span="15">
                    <el-input type="string" v-model="mymodel.oFactory"></el-input>
                </el-col>
            </el-form-item>
            <el-form-item class="text_right">
                <el-button type="primary" @click='onSubmitAdd("myform")'>保 存</el-button>
                <el-button @click="dialog.show = false">取 消</el-button>
            </el-form-item>
        </el-form>
    </el-dialog>
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
            <el-form-item label="商品名称" required>
                <el-col :span="15">
                    <el-form-item prop='oName'>
                        <el-input type="string" readonly v-model="mymodel.oName"></el-input>
                    </el-form-item>
                </el-col>
            </el-form-item>
            <el-form-item prop='oCount' label="商品数量:">
                <el-col :span="15">
                    <el-input type="int" min="0" v-model="mymodel.oCount"></el-input>
                </el-col>
            </el-form-item>
            <el-form-item prop='oPrice' label="商品价格:">
                <el-col :span="15">
                    <el-input type="float" min="0" v-model="mymodel.oPrice"></el-input>
                </el-col>
            </el-form-item>
            <el-form-item prop='oFactory' label="生产厂:">
                <el-col :span="15">
                    <el-input type="string" v-model="mymodel.oFactory"></el-input>
                </el-col>
            </el-form-item>
            <el-form-item class="text_right">
                <el-button type="primary" @click='onSubmitEdit("myformedit")'>保 存</el-button>
                <el-button @click="dialogEdit.show = false">取 消</el-button>
            </el-form-item>
        </el-form>
    </el-dialog>
</div>
<!--1 引入vue-->
<script src="../static/vue/vue.js"></script>
<!--2.2 引入element ui-->
<script src="../static/element-ui/index.js"></script>
<!--3 引入axois-->
<script src="../static/axios/axios.js"></script>
<script src="../static/mx-config.js"></script>
<script>
    // 定义vue实例
    var app = new Vue({
        el: "#app",
        data: function () {
            return {
                tableData:[
                    // {
                    //     oName:'润滑油',
                    //     oCount:'100',
                    //     oPrice:'100',
                    //     oFactory:'壳牌',
                    // },
                ],
                //控制对话框
                dialog:{
                    title:'',
                    show:false
                },
                dialogEdit:{
                    title:'',
                    show: false
                },
                //定义模型，与表单匹配
                mymodel:{
                    oName: '',
                    oCount: '',
                    oPrice:'',
                    oFactory:'',
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
                axios.get("/ob/").then(res => {
                    this.tableData = res.data;
                });
            },
            //响应添加按钮
            onAdd:function () {
                //清空表单
                this.mymodel = {
                    oName: '',
                    oCount: '',
                    oPrice:'',
                    oFactory:'',
                };
                //alert("注册用户");
                this.dialog.title="添加商品";
                this.dialog.show = true;
            },
            //响应注册用户对话框 保存按钮
            onSubmitAdd:function (form) {
                //把表单数据提交到 后台 ，保存到数据库
                //添加,调用post方法
                axios.post("/ob/", this.mymodel).then(res => {
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
            //响应修改按钮
            onEdit:function (index) {
                //进行数据回填---通过选中的index获得tableData里面的数据
                this.mymodel = {
                    oId:this.tableData[index].oId,
                    oName: this.tableData[index].oName,
                    oCount: this.tableData[index].oCount,
                    oPrice:this.tableData[index].oPrice,
                    oFactory:this.tableData[index].oFactory,
                };
                //保存被选中的行 索引值
                this.selectItemIndex = index;
                //设置对话框可见
                this.dialogEdit.title = '修改商品信息';
                this.dialogEdit.show = true;
            },
            //响应修改对话框 保存按钮
            onSubmitEdit:function (form) {
                //保存到数据库
                axios.put("/ob/", this.mymodel).then(res =>{
                    // 操作成功
                    this.$message({
                        message: "保存成功！",
                        type: "success"
                    });
                    // 方法1:更新指定索引的元素
                    this.tableData.splice(this.selectItemIndex, 1, res.data);
                    // 方法2:数据重新从服务器加载table数据,这种方法效率差
                    // this.initTable();
                    // 关闭对话框
                    this.dialogEdit.show = false;
                })
            },
            //响应删除按钮
            onDelete:function (index) {
                //删除被选中的数据
                this.$confirm('确认下架该数据吗?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    // 删除
                    axios.delete("/ob/" + this.tableData[index].oId).then(res => {
                        if (res.data == 200){
                            this.$message("下架成功");
                            // 删除table起始下标为1，长度为1的一个值
                            this.tableData.splice(index, 1);
                        }
                    });
                }).catch(() => {
                });
            }
        }
    });
</script>
 </div>
</body>
</html>