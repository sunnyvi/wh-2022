<template>
  <el-aside :width="sideWidth+'px'"
            style="background-color: rgb(238, 241, 246);min-height: 100%;box-shadow: 2px 0 6px rgb(0 21 41 /35%)">
    <el-menu :default-openeds="['1', '3']" style="min-height: 100%;overflow: hidden"
             background-color="rgb(48,65,86)"
             text-color="#fff"
             active-text-color="#ffd04b"
             :collapse-transition="false"
             :collapse="isCollapse"
             router
    >
      <div style="height: 60px;line-height: 60px;text-align: center">
        <img src="../assets/logo.png" style="width: 20px;position: relative;top:5px;margin-right: 5px">
        <b style="color: white" v-show="logoTextShow">管理系统</b>
      </div>
      <el-menu-item index="/"><i class="el-icon-house"></i><span slot="title">主页</span></el-menu-item>
      <el-submenu index="1">

        <template slot="title"><i class="el-icon-menu"></i><span slot="title">数据管理</span></template>

        <el-menu-item-group title="信息管理">

          <el-menu-item index="/customer"><i class="el-icon-s-custom"></i><span slot="title">客户管理</span></el-menu-item>
          <el-menu-item index="/order"><i class="el-icon-document"></i><span slot="title">订单管理</span></el-menu-item>
        </el-menu-item-group>
        <el-menu-item-group title="其他">
          <el-menu-item index="/test">test</el-menu-item>
        </el-menu-item-group>
      </el-submenu>
      <el-submenu index="2">
        <template slot="title"><i class="el-icon-setting"></i><span slot="title">设置管理</span></template>
        <el-menu-item-group>
          <template slot="title">分组一</template>
          <el-menu-item index="2-1">选项1</el-menu-item>
          <el-menu-item index="2-2">选项2</el-menu-item>
        </el-menu-item-group>
        <el-menu-item-group title="分组2">
          <el-menu-item index="2-3">选项3</el-menu-item>
        </el-menu-item-group>
        <el-submenu index="2-4">
          <template slot="title">选项4</template>
          <el-menu-item index="2-4-1">选项4-1</el-menu-item>
        </el-submenu>
      </el-submenu>
    </el-menu>
  </el-aside>
</template>

<script>
export default {
  name: "Aside",
  props: {
    isCollapse: Boolean,
    logoTextShow: Boolean,
    sideWidth:Number
  },
  data() {

    return {
      msg: "hell jason",
      collapseBtnClass: 'el-icon-s-fold'
    }
  },
  methods:{

  }
}
</script>

<style scoped>
.el-aside {
  height: 100vh;
}

</style>