<%--组长写--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>工作人员管理</title>
  <!--引入element css-->
  <link href="../static/element-ui/index.css" rel="stylesheet">
</head>
<body>
<div id="app">
  <b>用户列表</b>
  <el-button @click="onAdd()" type="primary" size="mini">注册</el-button>

  <el-table :data="tableData" stripe style="width: 90%">
    <el-table-column prop="" type="index" label="序号" width="50px"></el-table-column>
    <el-table-column prop="userLoginId" label="账号" width="80px"></el-table-column>
    <el-table-column prop="userName" label="姓名" width="80px"></el-table-column>
    <el-table-column prop="mSex" label="性别" width="80px"></el-table-column>
    <el-table-column prop="mAge" label="年龄" width="80px"></el-table-column>
    <el-table-column prop="userType" label="用户类型" width="80px">
      <template slot-scope="scope">
        <span v-if="scope.row.userType=='店长'">店长</span>
        <span v-if="scope.row.userType=='服务人员'">服务人员</span>
        <span v-if="scope.row.userType=='补货人员'">补货人员</span>
        <span v-if="scope.row.userType=='销售人员'">销售人员</span>
      </template>
    </el-table-column>
    <el-table-column prop="mMoney" label="工资" width="80px"></el-table-column>
    <el-table-column prop="mPhone" label="电话" width="100px"></el-table-column>
    <el-table-column prop="" label="操作">
      <template slot-scope="scope">
        <el-button type="primary" plain size="mini" @click="onEdit(scope.$index)">修改</el-button>
        <el-button type="danger" plain size="mini" @click="onDelete(scope.$index)">删除</el-button>
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
      <el-form-item label="登录账号" required>
        <el-col :span="15">
          <el-form-item prop='userLoginId'>
            <el-input type="string" v-model="mymodel.userLoginId"></el-input>
          </el-form-item>
        </el-col>
      </el-form-item>
      <el-form-item label="登录密码" required>
        <el-col :span="15">
          <el-form-item prop='currentPassword'>
            <el-input type="password" v-model="mymodel.currentPassword"></el-input>
          </el-form-item>
        </el-col>
      </el-form-item>
      <el-form-item prop='userType' label="用户类型">
        <el-radio-group v-model="mymodel.userType">
          <el-radio-button label="店长"></el-radio-button>
          <el-radio-button label="补货人员"></el-radio-button>
          <el-radio-button label="销售人员"></el-radio-button>
          <el-radio-button label="服务人员"></el-radio-button>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="姓名" required>
        <el-col :span="15">
          <el-form-item prop='userName'>
            <el-input type="string" v-model="mymodel.userName"></el-input>
          </el-form-item>
        </el-col>
      </el-form-item>
      <el-form-item label="性别" required>
        <el-col :span="15">
          <el-form-item prop='mSex'>
            <el-radio v-model="mymodel.mSex" label="男">男</el-radio>
            <el-radio v-model="mymodel.mSex" label="女">女</el-radio>
          </el-form-item>
        </el-col>
      </el-form-item>
      <el-form-item label="年龄" required>
        <el-col :span="15">
          <el-form-item prop='mAge'>
            <el-input type="int" minlength="1" maxlength="3" min="0" v-model="mymodel.mAge"></el-input>
          </el-form-item>
        </el-col>
      </el-form-item>
      <el-form-item label="工资" required>
        <el-col :span="15">
          <el-form-item prop='mMoney'>
            <el-input type="float" min="0" v-model="mymodel.mMoney"></el-input>
          </el-form-item>
        </el-col>
      </el-form-item>
      <el-form-item label="电话" required>
        <el-col :span="15">
          <el-form-item prop='mPhone'>
            <el-input type="string" minlength="6" maxlength="11" v-model="mymodel.mPhone"></el-input>
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
      <el-form-item hidden prop='userId' label="ID:">
        <el-input type="string" v-model="mymodel.userId"></el-input>
      </el-form-item>
      <!--修改-->
      <el-form-item label="登录账号">
        <el-col :span="15">
          <el-form-item prop='userLoginId'>
            <el-input type="string" v-model="mymodel.userLoginId"></el-input>
          </el-form-item>
        </el-col>
      </el-form-item>
      <el-form-item prop='userType' label="账号类型">
        <!--使用label表示值-->
        <el-radio-group v-model="mymodel.userType">
          <el-radio-button label="店长">店长</el-radio-button>
          <el-radio-button label="补货人员">补货人员</el-radio-button>
          <el-radio-button label="销售人员">销售人员</el-radio-button>
          <el-radio-button label="服务人员">服务人员</el-radio-button>
        </el-radio-group>
      </el-form-item>

      <el-form-item label="姓名" required>
        <el-col :span="15">
          <el-form-item prop='userName'>
            <el-input type="string" v-model="mymodel.userName"></el-input>
          </el-form-item>
        </el-col>
      </el-form-item>
      <el-form-item label="年龄" required>
        <el-col :span="15">
          <el-form-item prop='mAge'>
            <el-input type="int" minlength="1" maxlength="3" min="0" v-model="mymodel.mAge"></el-input>
          </el-form-item>
        </el-col>
      </el-form-item>
      <el-form-item prop='mMoney' label="工资" required>
        <el-col :span="15">
          <el-input type="float"  min="0" v-model="mymodel.mMoney"></el-input>
        </el-col>
      </el-form-item>
      <el-form-item prop='mPhone' label="电话" required>
        <el-col :span="15">
          <el-input type="string" minlength="6" maxlength="11" v-model="mymodel.mPhone"></el-input>
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
        userId:'',
        userLoginId:'',
        currentPassword:'',
        userName:'',
        mSex:'',
        mAge:'',
        userType:'',
        mMoney:'',
        mPhone:''
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
        axios.get("/user").then(res=>{
          this.tableData=res.data;
        });
      },

      onAdd:function () {
        //清空表单
        this.mymodel={
          userId:'',
          userLoginId:'',
          currentPassword:'',
          userName:'',
          mSex:'',
          mAge:'',
          userType:'',
          mMoney:'',
          mPhone:''
        }
        this.dialog={
          title: '注册用户',
          show: true
        }
      },
      onEdit:function (index) {
        //进行数据回填---通过选中的index获得tableData里面的数据
        this.mymodel = {
          userId:this.tableData[index].userId,
          userLoginId: this.tableData[index].userLoginId,
          userName: this.tableData[index].userName,
          mAge: this.tableData[index].mAge,
          mPhone:this.tableData[index].mPhone,
          userType:this.tableData[index].userType,
          mMoney:this.tableData[index].mMoney
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
          axios.delete("/user/" + this.tableData[index].userId).then(res => {
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
        axios.post("/user/", this.mymodel).then(res => {
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
        axios.put("/user/", this.mymodel).then(res =>{
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