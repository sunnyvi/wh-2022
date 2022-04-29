<template>
  <div style="text-align: right; font-size: 12px;border-bottom: 1px solid #ccc;line-height: 60px;display: flex;">
    <div style="text-align: left;width: 50%;font-size: 20px">
      <span :class="collapseBtnClass" style="cursor: pointer" @click="collapse"></span>
    </div>
    <div style="text-align: right;width: 50%">
      <el-dropdown style="cursor: pointer">
        <i class="el-icon-setting" style="margin-right: 15px"></i>
        <el-dropdown-menu slot="dropdown">
          <el-dropdown-item>用户信息</el-dropdown-item>
          <el-dropdown-item>退出</el-dropdown-item>
        </el-dropdown-menu>
      </el-dropdown>
      <span>黑蚊子多</span>
      <i class="el-icon-arrow-down" style="margin-left: 5px"></i>
    </div>
  </div>
</template>

<script>
export default {
  name: "Header",
  props: {
    collapseBtnClass: String,
    collapse:Function

  }
}
</script>

<style scoped>
.el-header {
  height: 70px;
}

</style>