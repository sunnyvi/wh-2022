<template>
  <div>
    <el-breadcrumb separator="/">
      <el-breadcrumb-item>数据管理</el-breadcrumb-item>
<!--      :to="{ path: '/' }"-->
      <el-breadcrumb-item>订单管理</el-breadcrumb-item>
    </el-breadcrumb>

    <div style="margin: 10px 0">
      <el-input style="width:200px" suffix-icon="el-icon-search" placeholder="客户代码" class="ml-5" v-model="custCode"></el-input>
      <el-input style="width:200px" suffix-icon="el-icon-s-custom" placeholder="定单编号" class="ml-5" v-model="orderNumS"></el-input>


      <el-button class="ml-5" type="primary" @click="load">搜索</el-button>
    </div>

    <div style="margin:10px 0">
<!--      <el-button type="primary">新增 <i class="el-icon-circle-plus-outline"></i></el-button>-->
      <el-upload  :show-file-list="false"   :action="uploadLink" style="display: inline-block;padding: 1%" >
      <el-button type="success">导入 <i class="el-icon-bottom"></i></el-button>
      </el-upload>
      <el-button type="warning">导出 <i class="el-icon-top"></i></el-button>
    </div>

    <el-table :data="tableData" style="" :header-cell-style="{background:'#efefef'}" height="400" >

      <el-table-column prop="Id" label="id" width="100" v-if="false">
      </el-table-column>
      <el-table-column prop="orderNumS" label="定单编号" width="150" fixed="left" sortable>
      </el-table-column>
      <el-table-column prop="orderNo" label="订单号" width="100" fixed="left" >
      </el-table-column>
      <el-table-column prop="custNo" label="客户号" width="150">
      </el-table-column>
      <el-table-column prop="ludaCode" label="鲁达号">
      </el-table-column>
      <el-table-column prop="sdCode" label="胜地号" width="150">
      </el-table-column>
      <el-table-column prop="orderQuantity" label="定单数量">
      </el-table-column>
  <el-table-column prop="formula" label="配方">
      </el-table-column>
      <el-table-column prop="boxClass" label="盒类" width="150">
      </el-table-column>
      <el-table-column prop="remarks" label="备注1">
      </el-table-column>
      <el-table-column prop="deliveryDate" label="交货期" width="150" :formatter="formatDate">
      </el-table-column>
  <el-table-column prop="emarkNo" label="EMARK NO.">
      </el-table-column>
      <el-table-column prop="wvaNo" label="WVA NO.">
      </el-table-column>
      <el-table-column prop="oeNo" label="OE NO.">
      </el-table-column>
      <el-table-column prop="frNo" label="F/R">
      </el-table-column>
  <el-table-column prop="barCodeColorbox" label="彩盒条形码BAR CODE">
      </el-table-column>
      <el-table-column prop="barCodeOuterbox" label="外箱条形码BAR CODE">
      </el-table-column>
      <el-table-column prop="model" label="车型">
      </el-table-column>
      <el-table-column prop="backMark" label="钢背喷码">
      </el-table-column>
  <el-table-column prop="ludaCodeEmark" label="EMARK证书上的鲁达号">
      </el-table-column>
      <el-table-column prop="formulaEmark" label="EMARK证书上的配方号">
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
export default {
  name: "Customer",
  data() {
    const item = {};
    return {
      tableData: [],
      uploadLink:this.myAxios.base_address_app_service+this.myAxios.address_order,
      custCode:"",
      orderNumS:""
    }
  },
  created() {
    //
    this.load()
  },
  methods: {
    load() {
      this.requests.get(this.myAxios.base_address_app_service + this.myAxios.address_order, {
        params: {
          custCode: this.custCode,
          orderNumS: this.orderNumS

        }

      }).then(res => {
        console.log(res),
            this.tableData = res.data
      })
    },
    formatDate(row, column){
      // 获取单元格数据
      let data = row[column.property]
      if(data == null) {
        return null
      }
      let dt = new Date(data)
      return dt.getFullYear() + '-' + (dt.getMonth() + 1) + '-' + dt.getDate() + ' ' + dt.getHours() + ':' + dt.getMinutes() + ':' + dt.getSeconds()
    },

  }
}
</script>

<style scoped>

</style>