<template>
  <section>
    <!--工具条-->
    <el-col :span="24" class="toolbar" style="padding-bottom: 0px;">
      <el-form :inline="true" :model="filters">
        <el-form-item>
          <el-input v-model="filters.clazzId" placeholder="教学班号"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" v-on:click="getArrangement">查询</el-button>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="handleAdd">新增</el-button>
        </el-form-item>
      </el-form>
    </el-col>

    <el-table :data="arrangements" highlight-current-row v-loading="listLoading" @selection-change="" style="width: 100%;">
      <el-table-column type="selection" width="55">
      </el-table-column>
      <el-table-column prop="id" width="80" label="ID" sortable></el-table-column>
      <!--<el-table-column prop="clazzId" width="120" label="班级号"></el-table-column>-->
      <el-table-column label="安排" width="200">
        <template slot-scope="scope">
          第{{scope.row.week}}周星期{{scope.row.weekDay}}第{{scope.row.seq}}节课
        </template>
      </el-table-column>
      <el-table-column label="操作" width="150">
        <template scope="scope">
          <el-button size="small" @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
          <el-button type="danger" size="small" @click="handleDel(scope.$index, scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <!--工具条-->
    <el-col :span="24" class="toolbar">
    </el-col>

    <!--编辑界面-->
    <!--<el-dialog title="编辑" v-model="editFormVisible" :close-on-click-modal="false">-->
    <!--<div slot="footer" class="dialog-footer">-->
    <!--<el-button @click.native="editFormVisible = false">取消</el-button>-->
    <!--<el-button type="primary" @click.native="editSubmit" :loading="editLoading">提交</el-button>-->
    <!--</div>-->
    <!--</el-dialog>-->
  </section>
</template>

<script>
  export default {
    data() {
      return {
        filters: {
          clazzId: ''
        },
        arrangements: null
      }
    },
    methods: {
      getArrangement() {
        this.arrangements = this.$store.state.arrangements
      }
    },
    mounted() {
      this.$message({message: '输入教学班号进行查询', type: 'warning'})
    }
  }

</script>

<style scoped>

</style>
