<template>
  <div>
    <el-container style="min-height: 100vh; border: 1px solid #eee">

      <el-aside :width="sideWidth+'px'"
                style="background-color: rgb(238, 241, 246);min-height: 100%;box-shadow: 2px 0 6px rgb(0 21 41 /35%)">
        <el-menu :default-openeds="['1', '3']" style="min-height: 100%;overflow: hidden"
                 background-color="rgb(48,65,86)"
                 text-color="#fff"
                 active-text-color="#ffd04b"
                 :collapse-transition="false"
                 :collapse="isCollapse"
        >
          <div style="height: 60px;line-height: 60px;text-align: center">
            <img src="../assets/logo.png" style="width: 20px;position: relative;top:5px;margin-right: 5px">
            <b style="color: white" v-show="logoTextShow">管理系统</b>
          </div>

          <el-submenu index="1">
            <template slot="title"><i class="el-icon-menu"></i><span slot="title">数据管理</span></template>
            <el-menu-item-group title="信息管理">
              <el-menu-item index="1-1">客户信息管理</el-menu-item>
              <el-menu-item index="1-2">订单管理</el-menu-item>
            </el-menu-item-group>
            <el-menu-item-group title="其他">
              <el-menu-item index="1-3">选项3</el-menu-item>
            </el-menu-item-group>
            <el-submenu index="1-4">
              <template slot="title">选项4</template>
              <el-menu-item index="1-4-1">选项4-1</el-menu-item>
            </el-submenu>
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

      <el-container>

        <el-header
            style="text-align: right; font-size: 12px;border-bottom: 1px solid #ccc;line-height: 60px;display: flex;">
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
        </el-header>

        <el-main style="">
          <el-breadcrumb separator="/">
            <el-breadcrumb-item :to="{ path: '/' }">数据管理</el-breadcrumb-item>
            <el-breadcrumb-item><a href="/">客户管理</a></el-breadcrumb-item>
          </el-breadcrumb>

          <div style="margin: 10px 0">
            <el-input style="width:200px" suffix-icon="el-icon-search" placeholder="条件1" class="ml-5"></el-input>
            <el-input style="width:200px" suffix-icon="el-icon-s-custom" placeholder="条件2" class="ml-5"></el-input>
            <el-input style="width:200px" suffix-icon="el-icon-s-check" placeholder="条件3" class="ml-5"></el-input>

            <el-button class="ml-5" type="primary" @click="load">搜索</el-button>
          </div>

          <div style="margin:10px 0">
            <el-button type="primary">新增 <i class="el-icon-circle-plus-outline"></i></el-button>
            <el-button type="success">导入 <i class="el-icon-bottom"></i></el-button>
            <el-button type="info">导出 <i class="el-icon-top"></i></el-button>
          </div>

          <el-table :data="tableData" style="" :header-cell-style="{background:'#efefef'}" height="400">
            <el-table-column prop="orgId" label="经营实体" width="100" fixed="left">
            </el-table-column>
            <el-table-column prop="custCode" label="客户代码" width="100" fixed="left" sortable>
            </el-table-column>
            <el-table-column prop="custName" label="客户全称">
            </el-table-column>
            <el-table-column prop="custName" label="客户全称">
            </el-table-column>
            <el-table-column prop="custName" label="客户全称">
            </el-table-column>
            <el-table-column prop="custName" label="客户全称">
            </el-table-column>
            <el-table-column prop="custName" label="客户全称">
            </el-table-column>
            <el-table-column prop="custName" label="客户全称">
            </el-table-column>
            <el-table-column prop="custName" label="客户全称">
            </el-table-column>
            <el-table-column prop="custName" label="客户全称">
            </el-table-column>
            <el-table-column prop="custName" label="客户全称">
            </el-table-column>
            <el-table-column prop="custName" label="客户全称">
            </el-table-column>

            <el-table-column label="操作" fixed="right" width="180" >
              <template slot-scope="scope">
                <el-button type="warning">编辑<i class="el-icon-edit"></i></el-button>
                <el-button type="danger" >删除<i class="el-icon-remove-outline"></i></el-button>
              </template>
            </el-table-column>
          </el-table>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
import request from "@/utils/request";

export default {
  name: 'HomeView',
  data() {
    const item = {
      date: '2016-05-02',
      name: '王小虎',
      address: '上海市普陀区金沙江路 1518 弄'
    };
    return {
      msg: "hell jason",
      tableData:"",
      collapseBtnClass: 'el-icon-s-fold',
      isCollapse: false,
      sideWidth: 200,
      logoTextShow: true
    }
  },
  created() {
    //
   this.load()
  },
  methods: {
    collapse() {//收缩函数
      this.isCollapse = !this.isCollapse;
      if (this.isCollapse) {
        this.sideWidth = 64
        this.collapseBtnClass = 'el-icon-s-unfold'
        this.logoTextShow = !this.isCollapse
      } else {
        this.sideWidth = 200
        this.collapseBtnClass = 'el-icon-s-fold'
        this.logoTextShow = !this.isCollapse
      }

    },
    load(){
      request.get("http://localhost:8090/customers").then(res =>{
        console.log(res)
        this.tableData = res.data
        return this.tableData
      })

    }

  }
}


</script>
