<%--组长写--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>VIP管理</title>
  <!--引入element css-->
  <link href="../static/element-ui/index.css" rel="stylesheet">
</head>
<body>
<div id="app">
  <b>VIP列表</b>
  <el-button @click="onAdd()" type="primary" size="mini">注册</el-button>

  <el-table :data="tableData" stripe style="width: 90%">
    <el-table-column prop="" type="index" label="序号" width="50px"></el-table-column>
    <el-table-column prop="vId" label="会员账号" width="100px"></el-table-column>
    <el-table-column prop="vName" label="姓名" width="100px"></el-table-column>
    <el-table-column prop="vSex" label="性别" width="100px"></el-table-column>
    <el-table-column prop="vPhone" label="电话" width="100px"></el-table-column>
    <el-table-column prop="" label="操作">
      <template slot-scope="scope">
        <el-button type="primary" plain size="mini" @click="onEdit(scope.$index)">修改</el-button>
        <el-button type="danger" plain size="mini" @click="onDelete(scope.$index)">注销</el-button>
      </template>
    </el-table-column>
  </el-table>

  <!--定义用户注册对话框-->
  <el-dialog
      :title="dialog.title"
      :visible.sync="dialog.show"
      :close-on-click-modal="false"
      :close-on-press-escape="false"
      :modal-append-to-body="false"
      width="80%">

    <el-form ref="myform" :model="mymodel" label-width="150px" style="margin: 10px;width: auto;">
      <el-form-item label="姓名" required>
        <el-col :span="15">
          <el-form-item prop='vName'>
            <el-input type="string" v-model="mymodel.vName"></el-input>
          </el-form-item>
        </el-col>
      </el-form-item>
      <el-form-item label="性别" required>
        <el-col :span="15">
          <el-form-item prop='vSex'>
            <el-radio v-model="mymodel.vSex" label="男">男</el-radio>
            <el-radio v-model="mymodel.vSex" label="女">女</el-radio>
          </el-form-item>
        </el-col>
      </el-form-item>

      <el-form-item label="电话" required>
        <el-col :span="15">
          <el-form-item prop='vPhone'>
            <el-input type="string" minlength="6" maxlength="11" v-model="mymodel.vPhone"></el-input>
          </el-form-item>
        </el-col>
      </el-form-item>

      <el-form-item class="text_right">
        <el-button type="primary" @click='onSubmitAdd("myform")'>保存</el-button>
        <el-button @click="dialog.show=false">取消</el-button>
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
      <el-form-item hidden prop='vId' label="ID:">
        <el-input type="string" v-model="mymodel.vId"></el-input>
      </el-form-item>
      <!--修改-->
      <el-form-item label="会员账号">
        <el-col :span="15">
          <el-form-item prop='vId'>
            <el-input type="string" readonly v-model="mymodel.vId"></el-input>
          </el-form-item>
        </el-col>
      </el-form-item>

      <el-form-item label="姓名" required>
        <el-col :span="15">
          <el-form-item prop='vName'>
            <el-input type="string" v-model="mymodel.vName"></el-input>
          </el-form-item>
        </el-col>
      </el-form-item>
      <el-form-item prop='vPhone' label="电话" required>
        <el-col :span="15">
          <el-input type="string" minlength="6" maxlength="11" v-model="mymodel.vPhone"></el-input>
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
        vId:'',
        vName:'',
        vSex:'',
        vPhone:''
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
        axios.get("/vip").then(res=>{
          this.tableData=res.data;
        });
      },

      onAdd:function () {
        //清空表单
        this.mymodel={
          vId:'',
          vName:'',
          vSex:'',
          vPhone:''
        }
        this.dialog={
          title: '注册用户',
          show: true
        }
      },
      onEdit:function (index) {
        //进行数据回填---通过选中的index获得tableData里面的数据
        this.mymodel = {
          vId:this.tableData[index].vId,
          vName: this.tableData[index].vName,
          vPhone:this.tableData[index].vPhone
        }

        //保存被选中的行 索引值
        this.selectItemIndex = index;

        //设置对话框可见
        this.dialogEdit.title = '修改用户信息';
        this.dialogEdit.show = true;
      },
      onDelete:function (index) {
        //删除被选中的数据
        this.$confirm('确认删除该数据吗?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          // 删除
          axios.delete("/vip/" + this.tableData[index].vId).then(res => {
            if (res.data == 200){
              this.$message("删除成功");
              // 删除table起始下标为1，长度为1的一个值
              this.tableData.splice(index, 1);
            }
          });
        }).catch(() => {

        });
      },
      onSubmitAdd:function (form) {
        //把表单数据提交到 后台 ，保存到数据库
        //添加,调用post方法
        axios.post("/vip/", this.mymodel).then(res => {
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
      onSubmitEdit:function (form) {
        //保存到数据库
        axios.put("/vip/", this.mymodel).then(res =>{
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