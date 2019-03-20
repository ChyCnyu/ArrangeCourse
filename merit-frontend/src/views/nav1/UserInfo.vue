<template>
  <el-card id="my-info" class="box-card" v-if="!loading" v-loading="loading">
    <div slot="header" class="clearfix">
      <span class="user-name">油瓶大佬</span>
      <el-button style="float: right; padding: 3px 0" type="text"><i class="fa fa-pencil"></i>修改</el-button>
    </div>
    <div class="text item">
      账号：201631063222
    </div>
    <div class="text item">
      邮箱：youp@yypp.com
    </div>
    <div class="text item">
      手机号：13123988923
    </div>
    <div class="text item">
      角色：管理员
    </div>
  </el-card>
</template>
<script>
	export default {
		data() {
      return {
        ownInfo: this.$store.state.ownInfo,
        loading: true,
      }
    }, mounted () {
      this.$store.dispatch('fetchOwnInfo').then((() => {
        this.loading = false
      }).bind(this))
    },
    methods: {
		  getRoleName(role) {
		    if (role == 'student') {
		      return '学生'
        } else if (role == 'teacher') {
		      return '老师'
        } else {
		      return '管理员'
        }
      }
    }
	}
</script>

<style scoped>
  #my-info {
    width: 450px;
    margin-top: 20px
  }
  #my-info .text.item {
    padding: 4px 2px
  }
  .user-name {
    font-size: 1.3em
  }
</style>
