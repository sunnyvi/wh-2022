<template>


  <el-form :model="tableForm" ref="tableForm" :rules="rules">
    <el-table>
        cell-class-name="margin_padding"
        ref="multipleTable1"
        :data="tableForm.materiels"
    tooltip-effect="light"
    @selection-change="handleSelectionChange1">
    <el-table-column
        type="selection"
        width="55">
    </el-table-column>
    <el-table-column v-for="(value, index) in table1Header"
                     :key="index"
                     :label="value.label">
      <template slot-scope="scope">
        <el-form-item style="padding-top: 20px" size="mini" :prop="'materiels.'+ scope.$index + '.' + value.prop" :rules="rules[value.prop]">
<!--          // :prop="'materiels.'+ scope.$index + '.' + value.prop" 这里一定要使用 ‘.’ 才能动态关联-->
          <el-input :disabled="index < 4" size="mini" v-model="scope.row[value.prop]" @blur="change(scope.$index, scope.row)" :placeholder="scope.row.toString()"></el-input>
        </el-form-item>
      </template>
    </el-table-column>
    </el-table>
  </el-form>

</template>

<script>
export default {
  name: 'MaterielTable',
  props: ['businessType'],
  data () {
    var validatePass = (rule, value, callback) => {
      console.log(value)
      if (!value) {
        return callback(new Error('年龄不能为空'))
      }
    }
    return {
      rules: {
        taxRatio: [
          { required: true, message: '请输入合法数字', trigger: 'blur' }
        ],
        taxPriceTotal: [
          { required: false, pattern: /^([0-9]*(\.[0-9]+)?)$/, message: '请输入合法数字', trigger: 'blur' }
        ],
        balance2: [{ required: false, pattern: /^([0-9]*(\.[0-9]+)?)$/, message: '请输入合法数字', trigger: 'blur' }]
      },
      tableForm: {
        materiels: [
        ]
      },
      multipleSelection1: [],
      multipleSelection2: [],
      table1Header: [
        {
          label: '物资编码',
          prop: 'mmCode'
        },

      ]
    }
  },
  methods: {
    selectMateriel () {
      this.multipleSelection2.forEach((item) => {
        if (this.tableForm.materiels.indexOf(item) === -1) {
          this.tableForm.materiels.push(item)
        }
      })

      this.toggleSelection2()
      // 关闭抽屉
      this.drawer = false
    }
  }
}

</script>

<style scoped>

</style>