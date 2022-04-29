<template>
  <div>
    <el-breadcrumb separator="/">
      <el-breadcrumb-item>数据管理</el-breadcrumb-item>
      <!--      :to="{ path: '/' }"-->
      <el-breadcrumb-item>客户管理</el-breadcrumb-item>
    </el-breadcrumb>

    <div style="margin: 10px 0">
      <el-input style="width:200px" suffix-icon="el-icon-search" placeholder="客户代码" class="ml-5"
                v-model="custCode"></el-input>
      <el-input style="width:200px" suffix-icon="el-icon-s-custom" placeholder="经营实体" class="ml-5"
                v-model="orgId"></el-input>
      <el-input style="width:200px" suffix-icon="el-icon-s-check" placeholder="收货方" class="ml-5"
                v-model="siteCode"></el-input>

      <el-button class="ml-5" type="primary" @click="load">搜索</el-button>
      <el-button class="ml-5" type="warning" @click="reset">重置</el-button>
    </div>

    <div style="margin:10px 0">
      <el-button type="primary" @click="openDialog">新增 <i class="el-icon-circle-plus-outline"></i></el-button>
      <!--      <el-button type="success">导入 <i class="el-icon-bottom"></i></el-button>
            <el-button type="info">导出 <i class="el-icon-top"></i></el-button>-->
    </div>

    <el-table :data="tableData" :header-cell-style="{background:'#efefef'}" height="400">
      <el-table-column type="expand" width="100%">
        <template slot-scope="props">
          <div>
            <el-tabs :tab-position="tabPosition" style="height: 300px;" v-model="activeName" @tab-click="handleClick">
              <el-tab-pane label="全部" name="first" style="height:300px;overflow: auto;">

                <el-form label-position="left" inline class="table-expand" label-width="60%"
                         style="margin-left:5% ;eight:200px;overflow: auto;">
                  <el-form-item v-for="(value,key) in props.row" :label="key">
                    <span class="">{{ value }}</span>
                  </el-form-item>
                </el-form>


              </el-tab-pane>
              <el-tab-pane label="条件1" name="second">条件1</el-tab-pane>
              <el-tab-pane label="条件2" name="third">条件2</el-tab-pane>
              <el-tab-pane label="条件3" name="fourth">条件3</el-tab-pane>
            </el-tabs>
          </div>

          <!--          <el-form label-position="left" inline class="table-expand" label-width="50%" style="margin-left:1%">
                      <el-form-item label="客户代码">
                        <span class = "inner_span">{{ props.row.custCode }}</span>
                      </el-form-item>
                      <el-form-item label="经营实体">
                        <span class = "inner_span">{{ props.row.orgId }}</span>
                      </el-form-item>
                      <el-form-item label="客户全称">
                        <span class = "inner_span">{{ props.row.custName }}</span>
                      </el-form-item>
                      <el-form-item label="市场分类">
                        <span class = "inner_span">{{ props.row.custClass }}</span>
                      </el-form-item>
                      <el-form-item label="收货方">
                        <span class = "inner_span">{{ props.row.siteCode }}</span>
                      </el-form-item>
                      <el-form-item label="收货详细地址">
                        <span class = "inner_span">{{ props.row.siteAddress }}</span>
                      </el-form-item>
                      <el-form-item label="国家">
                        <span class = "inner_span">{{ props.row.country }}</span>
                      </el-form-item>
                      <el-form-item label="城市">
                        <span class = "inner_span">{{ props.row.city }}</span>
                      </el-form-item>
                      <el-form-item label="省">
                        <span class = "inner_span">{{ props.row.province }}</span>
                      </el-form-item>
                      <el-form-item label="邮政编码">
                        <span class = "inner_span">{{ props.row.zipCode }}</span>
                      </el-form-item>
                      <el-form-item label="信用控制方式">
                        <span class = "inner_span">{{ props.row.creditCtrlMode }}</span>
                      </el-form-item>
                      <el-form-item label="信用控制时间点">
                        <span class = "inner_span">{{ props.row.creditCtrlTime }}</span>
                      </el-form-item>
                      <el-form-item label="发货方法">
                        <span class = "inner_span">{{ props.row.deliveryMethod }}</span>
                      </el-form-item>
                      <el-form-item label="默认订单类型">
                        <span class = "inner_span">{{ props.row.defaultOrderType }}</span>
                      </el-form-item>
                      <el-form-item label="默认价目表">
                        <span class = "inner_span">{{ props.row.defaultPriceList }}</span>
                      </el-form-item>
                      <el-form-item label="客户号关联客户">
                        <span class = "inner_span">{{ props.row.itemRelCustomer }}</span>
                      </el-form-item>
                      <el-form-item label="是否需要OC">
                        <span class = "inner_span">{{ props.row.isNeedOc }}</span>
                      </el-form-item>
                      <el-form-item label="起运港">
                        <span class = "inner_span">{{ props.row.portOfLoading }}</span>
                      </el-form-item>
                      <el-form-item label="卸货港">
                        <span class = "inner_span">{{ props.row.portOfDischarge }}</span>
                      </el-form-item>
                      <el-form-item label="提单发货人信息">
                        <span class = "inner_span">{{ props.row.bolShipper }}</span>
                      </el-form-item>
                      <el-form-item label="提单收货人信息">
                        <span class = "inner_span">{{ props.row.bolConsignee }}</span>
                      </el-form-item>
                      <el-form-item label="提单通知方信息1">
                        <span class = "inner_span">{{ props.row.bolNotifyParty1 }}</span>
                      </el-form-item>
                      <el-form-item label="提单通知方信息2">
                        <span class = "inner_span">{{ props.row.bolNotifyParty2 }}</span>
                      </el-form-item>
                      <el-form-item label="提单通知方信息3">
                        <span class = "inner_span">{{ props.row.bolNotifyParty3 }}</span>
                      </el-form-item>
                      <el-form-item label="提单贸易条款">
                        <span class = "inner_span">{{ props.row.bolFrtPpyClt }}</span>
                      </el-form-item>
                      <el-form-item label="提单货物品名描述">
                        <span class = "inner_span">{{ props.row.bolDescription }}</span>
                      </el-form-item>
                      <el-form-item label="提单显示实际送货地址">
                        <span class = "inner_span">{{ props.row.bolDoor }}</span>
                      </el-form-item>
                      <el-form-item label="客户唛头">
                        <span class = "inner_span">{{ props.row.bolMark }}</span>
                      </el-form-item>
                      <el-form-item label="形式发票发货人信息">
                        <span class = "inner_span">{{ props.row.piShipper }}</span>
                      </el-form-item>
                      <el-form-item label="报关发票发货人信息">
                        <span class = "inner_span">{{ props.row.ciShipper }}</span>
                      </el-form-item>
                      <el-form-item label="美国报关发票发货人信息">
                        <span class = "inner_span">{{ props.row.aciShipper }}</span>
                      </el-form-item>
                      <el-form-item label="形式发票收货人信息">
                        <span class = "inner_span">{{ props.row.piShipTo }}</span>
                      </el-form-item>
                      <el-form-item label="箱单收货人信息">
                        <span class = "inner_span">{{ props.row.plShipTo }}</span>
                      </el-form-item>
                      <el-form-item label="形式发票收单人信息">
                        <span class = "inner_span">{{ props.row.piBillTo }}</span>
                      </el-form-item>
                      <el-form-item label="形式发票买方">
                        <span class = "inner_span">{{ props.row.piSoldTo }}</span>
                      </el-form-item>
                      <el-form-item label="客户的货物品名描述">
                        <span class = "inner_span">{{ props.row.custDescription }}</span>
                      </el-form-item>
                      <el-form-item label="收款价格条款">
                        <span class = "inner_span">{{ props.row.paymentTermPrice }}</span>
                      </el-form-item>
                      <el-form-item label="报关价格条款">
                        <span class = "inner_span">{{ props.row.custDecPriceTerms }}</span>
                      </el-form-item>
                      <el-form-item label="客户产品计量单位">
                        <span class = "inner_span">{{ props.row.custItemCalUom }}</span>
                      </el-form-item>
                      <el-form-item label="客户单价计价单位">
                        <span class = "inner_span">{{ props.row.custItemPriceUom }}</span>
                      </el-form-item>
                      <el-form-item label="客户托数计量单位">
                        <span class = "inner_span">{{ props.row.custItemPalletsUom }}</span>
                      </el-form-item>
                      <el-form-item label="形式发票同型号是否托数合并">
                        <span class = "inner_span">{{ props.row.piYhIsPalMerge }}</span>
                      </el-form-item>
                      <el-form-item label="箱单不允许托数合并">
                        <span class = "inner_span">{{ props.row.plNotallowPalMerge }}</span>
                      </el-form-item>
                      <el-form-item label="形式发票是否显示付款方式">
                        <span class = "inner_span">{{ props.row.piIsDisplayPaymentType }}</span>
                      </el-form-item>
                      <el-form-item label="是否导出明细净重/毛重">
                        <span class = "inner_span">{{ props.row.isPrintDetailWeight }}</span>
                      </el-form-item>
                      <el-form-item label="箱单是否需要金额">
                        <span class = "inner_span">{{ props.row.plIsNeedAmount }}</span>
                      </el-form-item>
                      <el-form-item label="要求单据类型-修改为单据类型">
                        <span class = "inner_span">{{ props.row.requestTypeOfDoc }}</span>
                      </el-form-item>
                      <el-form-item label="单据传送方式">
                        <span class = "inner_span">{{ props.row.docTransfWay }}</span>
                      </el-form-item>
                      <el-form-item label="是否需要寄单清单">
                        <span class = "inner_span">{{ props.row.isNeedSendList }}</span>
                      </el-form-item>
                      <el-form-item label="单证负责人">
                        <span class = "inner_span">{{ props.row.docHead }}</span>
                      </el-form-item>
                      <el-form-item label="是否保税区">
                        <span class = "inner_span">{{ props.row.isBondedArea }}</span>
                      </el-form-item>
                      <el-form-item label="客户每柜限重吨数">
                        <span class = "inner_span">{{ props.row.limitWeightPerContainer }}</span>
                      </el-form-item>
                      <el-form-item label="客户每柜限托数">
                        <span class = "inner_span">{{ props.row.limitPalPerContainer }}</span>
                      </el-form-item>
                      <el-form-item label="客户每柜限层数">
                        <span class = "inner_span">{{ props.row.limitLevelPerContainer }}</span>
                      </el-form-item>
                      <el-form-item label="客户箱编号方法">
                        <span class = "inner_span">{{ props.row.boxIntMethod }}</span>
                      </el-form-item>
                      <el-form-item label="发货是否需要报告">
                        <span class = "inner_span">{{ props.row.isNeedReport }}</span>
                      </el-form-item>
                      <el-form-item label="发货客户报告方式">
                        <span class = "inner_span">{{ props.row.reportMode }}</span>
                      </el-form-item>
                      <el-form-item label="计划物流是否带箱单">
                        <span class = "inner_span">{{ props.row.planIsNeedPl }}</span>
                      </el-form-item>
                      <el-form-item label="结算币种">
                        <span class = "inner_span">{{ props.row.settlementCurrency }}</span>
                      </el-form-item>
                      <el-form-item label="税码">
                        <span class = "inner_span">{{ props.row.taxCode }}</span>
                      </el-form-item>
                      <el-form-item label="付款条件">
                        <span class = "inner_span">{{ props.row.termsOfPayment }}</span>
                      </el-form-item>
                      <el-form-item label="付款方式">
                        <span class = "inner_span">{{ props.row.paymentMethod }}</span>
                      </el-form-item>
                      <el-form-item label="客户开户行及账号">
                        <span class = "inner_span">{{ props.row.clientBankAccount }}</span>
                      </el-form-item>
                      <el-form-item label="客户开票地址及电话">
                        <span class = "inner_span">{{ props.row.custBaddrAndPhoneNum }}</span>
                      </el-form-item>
                      <el-form-item label="是否合并开票">
                        <span class = "inner_span">{{ props.row.isMergeInvoice }}</span>
                      </el-form-item>
                      <el-form-item label="客户限重下限">
                        <span class = "inner_span">{{ props.row.attribute5 }}</span>
                      </el-form-item>
                      <el-form-item label="默认目的港">
                        <span class = "inner_span">{{ props.row.portOfDestination }}</span>
                      </el-form-item>
                      <el-form-item label="信用控制方式CODE">
                        <span class = "inner_span">{{ props.row.creditCtrlModeCode }}</span>
                      </el-form-item>
                      <el-form-item label="信用时间点控制CODE">
                        <span class = "inner_span">{{ props.row.creditCtrlTimeCode }}</span>
                      </el-form-item>
                      <el-form-item label="客户分类CODE">
                        <span class = "inner_span">{{ props.row.custClassCode }}</span>
                      </el-form-item>
                      <el-form-item label="默认订单类型ID">
                        <span class = "inner_span">{{ props.row.defaultOrderTypeId }}</span>
                      </el-form-item>
                      <el-form-item label="默认价目表ID">
                        <span class = "inner_span">{{ props.row.defaultPriceListId }}</span>
                      </el-form-item>
                      <el-form-item label="标准客户表客户地点ID">
                        <span class = "inner_span">{{ props.row.siteUseId }}</span>
                      </el-form-item>
                      <el-form-item label="关联客户ID">
                        <span class = "inner_span">{{ props.row.itemRelCustomerId }}</span>
                      </el-form-item>
                      <el-form-item label="单证负责人">
                        <span class = "inner_span">{{ props.row.docHeaderId }}</span>
                      </el-form-item>
                      <el-form-item label="默认价目表ID">
                        <span class = "inner_span">{{ props.row.priceListId }}</span>
                      </el-form-item>
                      <el-form-item label="付款条件ID">
                        <span class = "inner_span">{{ props.row.paymentTermId }}</span>
                      </el-form-item>
                      <el-form-item label="收款方式ID">
                        <span class = "inner_span">{{ props.row.receiptMethodId }}</span>
                      </el-form-item>
                      <el-form-item label="发货方法ID">
                        <span class = "inner_span">{{ props.row.carrierId }}</span>
                      </el-form-item>
                      <el-form-item label="美国报关发票收货人信息">
                        <span class = "inner_span">{{ props.row.aciCiReceiver }}</span>
                      </el-form-item>
                      <el-form-item label="美国报关发票买方信息">
                        <span class = "inner_span">{{ props.row.aciCiBuyerName }}</span>
                      </el-form-item>
                      <el-form-item label="报关箱单发货人信息">
                        <span class = "inner_span">{{ props.row.ciPlShipper }}</span>
                      </el-form-item>
                      <el-form-item label="形式发票导出公司代码">
                        <span class = "inner_span">{{ props.row.isExportCompanyCode }}</span>
                      </el-form-item>
                      <el-form-item label="形式发票导出供应商代码">
                        <span class = "inner_span">{{ props.row.isExportVendorCode }}</span>
                      </el-form-item>
                      <el-form-item label="供应商代码">
                        <span class = "inner_span">{{ props.row.vendorNo }}</span>
                      </el-form-item>
                      <el-form-item label="形式发票导出船公司名称及代码">
                        <span class = "inner_span">{{ props.row.isExportShipsNameCode }}</span>
                      </el-form-item>
                      <el-form-item label="形式发票导出TAX ID">
                        <span class = "inner_span">{{ props.row.isExportTaxId }}</span>
                      </el-form-item>
                      <el-form-item label="箱单是否导出客户PO号">
                        <span class = "inner_span">{{ props.row.plOutputPoNo }}</span>
                      </el-form-item>
                      <el-form-item label="是否需要导出分箱发票箱单">
                        <span class = "inner_span">{{ props.row.isNeedExInvoicePl }}</span>
                      </el-form-item>
                      <el-form-item label="苏州发票买方">
                        <span class = "inner_span">{{ props.row.suzhouInvoiceBuyer }}</span>
                      </el-form-item>
                      <el-form-item label="苏州发票公司代码">
                        <span class = "inner_span">{{ props.row.suzhouInvoiceCompanyCode }}</span>
                      </el-form-item>
                      <el-form-item label="苏州发票供应商代码">
                        <span class = "inner_span">{{ props.row.suzhouInvoiceSupplierCode }}</span>
                      </el-form-item>
                      <el-form-item label="苏州发票需要导出付款方式及标识号">
                        <span class = "inner_span">{{ props.row.suzhouInvoiceOutputPId }}</span>
                      </el-form-item>
                      <el-form-item label="要求单据类型">
                        <span class = "inner_span">{{ props.row.requestTypeOfDocDesc }}</span>
                      </el-form-item>
                      <el-form-item label="寄单地址">
                        <span class = "inner_span">{{ props.row.sendDocAddress }}</span>
                      </el-form-item>
                      <el-form-item label="报关价百分比%">
                        <span class = "inner_span">{{ props.row.priceDiffPer }}</span>
                      </el-form-item>
                      <el-form-item label="美国价目表">
                        <span class = "inner_span">{{ props.row.usPriceList }}</span>
                      </el-form-item>
                      <el-form-item label="香港报关百分比%">
                        <span class = "inner_span">{{ props.row.hkPricePer }}</span>
                      </el-form-item>
                      <el-form-item label="是否形式发票分箱单">
                        <span class = "inner_span">{{ props.row.isPiPk }}</span>
                      </el-form-item>
                      <el-form-item label="关联美国公司代码">
                        <span class = "inner_span">{{ props.row.relWbpi }}</span>
                      </el-form-item>
                      <el-form-item label="开证行英文名称">
                        <span class = "inner_span">{{ props.row.eNameOfIssuingBank }}</span>
                      </el-form-item>
                      <el-form-item label="开证行英文地址">
                        <span class = "inner_span">{{ props.row.eAddressOfIssuingBank }}</span>
                      </el-form-item>
                      <el-form-item label="中信保买方代码">
                        <span class = "inner_span">{{ props.row.citicInsuranceCode }}</span>
                      </el-form-item>
                      <el-form-item label="合同支付方式">
                        <span class = "inner_span">{{ props.row.iContractPayMethod }}</span>
                      </el-form-item>
                      <el-form-item label="期限(天)">
                        <span class = "inner_span">{{ props.row.dayLimit }}</span>
                      </el-form-item>
                      <el-form-item label="缴费支付方式">
                        <span class = "inner_span">{{ props.row.iPaymentMethod }}</span>
                      </el-form-item>
                      <el-form-item label="到款缓冲天数">
                        <span class = "inner_span">{{ props.row.bufferDays }}</span>
                      </el-form-item>
                      <el-form-item label="可选所有客户产品编码">
                        <span class = "inner_span">{{ props.row.chooseAllCustItemFlag }}</span>
                      </el-form-item>
                      <el-form-item label="默认折扣率">
                        <span class = "inner_span">{{ props.row.defaultDiscountRate }}</span>
                      </el-form-item>
                      <el-form-item label="是否强制组托">
                        <span class = "inner_span">{{ props.row.forcePalletFlag }}</span>
                      </el-form-item>
                      <el-form-item label="默认折扣率2">
                        <span class = "inner_span">{{ props.row.defaultDiscountRate2 }}</span>
                      </el-form-item>
                      <el-form-item label="默认第三方仓库">
                        <span class = "inner_span">{{ props.row.defaultThirdPartSubinv }}</span>
                      </el-form-item>
                      <el-form-item label="默认托盘编码">
                        <span class = "inner_span">{{ props.row.defaultPalletNo }}</span>
                      </el-form-item>
                      <el-form-item label="是否允许自动转R90型号">
                        <span class = "inner_span">{{ props.row.r90AutoFlag }}</span>
                      </el-form-item>
                      <el-form-item label="发货人企业代码">
                        <span class = "inner_span">{{ props.row.shipperVatNum }}</span>
                      </el-form-item>
                      <el-form-item label="发货人企业代码类型">
                        <span class = "inner_span">{{ props.row.shipperVarType }}</span>
                      </el-form-item>
                      <el-form-item label="收货人企业代码">
                        <span class = "inner_span">{{ props.row.consigneeVatNum }}</span>
                      </el-form-item>
                      <el-form-item label="收货人企业代码类型">
                        <span class = "inner_span">{{ props.row.consigneeVarType }}</span>
                      </el-form-item>
                      <el-form-item label="中国海关互认国家（地区）的企业AEO代码">
                        <span class = "inner_span">{{ props.row.consigneeAeoNum }}</span>
                      </el-form-item>
                      <el-form-item label="通知方企业代码">
                        <span class = "inner_span">{{ props.row.notifierVatNum }}</span>
                      </el-form-item>
                      <el-form-item label="通知方企业代码类型">
                        <span class = "inner_span">{{ props.row.notifierVarType }}</span>
                      </el-form-item>
                    </el-form>-->


        </template>
      </el-table-column>
      <el-table-column prop="Id" label="id" width="100" v-if="false">
      </el-table-column>

      <el-table-column prop="custCode" label="客户代码" width="100" sortable>
      </el-table-column>
      <el-table-column prop="siteCode" label="收货方">
      </el-table-column>
      <el-table-column prop="orgId" label="经营实体" width="100">
      </el-table-column>

      <el-table-column prop="custName" label="客户全称">
      </el-table-column>
      <el-table-column prop="custClass" label="市场分类">
      </el-table-column>

      <el-table-column prop="siteAddress" label="收货详细地址">
      </el-table-column>


      <el-table-column label="操作" width="180">
        <template slot-scope="scope">
          <el-button type="warning" @click="openDialog(scope.row)">编辑<i class="el-icon-edit"></i></el-button>
          <template>
            <el-popconfirm
                style="margin-left: 5%"
                confirm-button-text='确定'
                cancel-button-text='我再想想'
                icon="el-icon-info"
                icon-color="red"
                title="您确定删除吗？"
                @confirm="deleteCustomer(scope.row)"
            >
              <el-button type="danger" slot="reference">删除<i class="el-icon-remove-outline"></i></el-button>
            </el-popconfirm>
          </template>

        </template>
      </el-table-column>
    </el-table>

    <!-- Form -->
    <el-dialog :title="dialogTitle" :visible.sync="dialogFormVisible" width="75%" append-to-body>
      <el-form label-width="50%" style="width:100%" inline="true">
        <el-form-item label="Id" v-if="false">
          <el-input v-model="form.Id" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="客户代码">
          <el-input v-model="form.custCode" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="经营实体">
          <el-input v-model="form.orgId" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="客户全称">
          <el-input v-model="form.custName" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="市场分类">
          <el-input v-model="form.custClass" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="收货方">
          <el-input v-model="form.siteCode" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="收货详细地址">
          <el-input v-model="form.siteAddress" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="国家">
          <el-input v-model="form.country" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="城市">
          <el-input v-model="form.city" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="省">
          <el-input v-model="form.province" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="邮政编码">
          <el-input v-model="form.zipCode" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="信用控制方式">
          <el-input v-model="form.creditCtrlMode" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="信用控制时间点">
          <el-input v-model="form.creditCtrlTime" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="发货方法">
          <el-input v-model="form.deliveryMethod" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="默认订单类型">
          <el-input v-model="form.defaultOrderType" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="默认价目表">
          <el-input v-model="form.defaultPriceList" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="客户号关联客户">
          <el-input v-model="form.itemRelCustomer" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="是否需要OC">
          <el-input v-model="form.isNeedOc" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="起运港">
          <el-input v-model="form.portOfLoading" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="卸货港">
          <el-input v-model="form.portOfDischarge" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="提单发货人信息">
          <el-input v-model="form.bolShipper" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="提单收货人信息">
          <el-input v-model="form.bolConsignee" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="提单通知方信息1">
          <el-input v-model="form.bolNotifyParty1" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="提单通知方信息2">
          <el-input v-model="form.bolNotifyParty2" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="提单通知方信息3">
          <el-input v-model="form.bolNotifyParty3" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="提单贸易条款">
          <el-input v-model="form.bolFrtPpyClt" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="提单货物品名描述">
          <el-input v-model="form.bolDescription" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="提单显示实际送货地址">
          <el-input v-model="form.bolDoor" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="客户唛头">
          <el-input v-model="form.bolMark" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="形式发票发货人信息">
          <el-input v-model="form.piShipper" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="报关发票发货人信息">
          <el-input v-model="form.ciShipper" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="美国报关发票发货人信息">
          <el-input v-model="form.aciShipper" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="形式发票收货人信息">
          <el-input v-model="form.piShipTo" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="箱单收货人信息">
          <el-input v-model="form.plShipTo" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="形式发票收单人信息">
          <el-input v-model="form.piBillTo" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="形式发票买方">
          <el-input v-model="form.piSoldTo" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="客户的货物品名描述">
          <el-input v-model="form.custDescription" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="收款价格条款">
          <el-input v-model="form.paymentTermPrice" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="报关价格条款">
          <el-input v-model="form.custDecPriceTerms" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="客户产品计量单位">
          <el-input v-model="form.custItemCalUom" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="客户单价计价单位">
          <el-input v-model="form.custItemPriceUom" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="客户托数计量单位">
          <el-input v-model="form.custItemPalletsUom" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="形式发票同型号是否托数合并">
          <el-input v-model="form.piYhIsPalMerge" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="箱单不允许托数合并">
          <el-input v-model="form.plNotallowPalMerge" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="形式发票是否显示付款方式">
          <el-input v-model="form.piIsDisplayPaymentType" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="是否导出明细净重/毛重">
          <el-input v-model="form.isPrintDetailWeight" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="箱单是否需要金额">
          <el-input v-model="form.plIsNeedAmount" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="要求单据类型-修改为单据类型">
          <el-input v-model="form.requestTypeOfDoc" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="单据传送方式">
          <el-input v-model="form.docTransfWay" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="是否需要寄单清单">
          <el-input v-model="form.isNeedSendList" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="单证负责人">
          <el-input v-model="form.docHead" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="是否保税区">
          <el-input v-model="form.isBondedArea" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="客户每柜限重吨数">
          <el-input v-model="form.limitWeightPerContainer" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="客户每柜限托数">
          <el-input v-model="form.limitPalPerContainer" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="客户每柜限层数">
          <el-input v-model="form.limitLevelPerContainer" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="客户箱编号方法">
          <el-input v-model="form.boxIntMethod" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="发货是否需要报告">
          <el-input v-model="form.isNeedReport" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="发货客户报告方式">
          <el-input v-model="form.reportMode" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="计划物流是否带箱单">
          <el-input v-model="form.planIsNeedPl" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="结算币种">
          <el-input v-model="form.settlementCurrency" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="税码">
          <el-input v-model="form.taxCode" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="付款条件">
          <el-input v-model="form.termsOfPayment" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="付款方式">
          <el-input v-model="form.paymentMethod" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="客户开户行及账号">
          <el-input v-model="form.clientBankAccount" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="客户开票地址及电话">
          <el-input v-model="form.custBaddrAndPhoneNum" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="是否合并开票">
          <el-input v-model="form.isMergeInvoice" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="客户限重下限">
          <el-input v-model="form.attribute5" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="默认目的港">
          <el-input v-model="form.portOfDestination" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="信用控制方式CODE">
          <el-input v-model="form.creditCtrlModeCode" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="信用时间点控制CODE">
          <el-input v-model="form.creditCtrlTimeCode" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="客户分类CODE">
          <el-input v-model="form.custClassCode" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="默认订单类型ID">
          <el-input v-model="form.defaultOrderTypeId" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="默认价目表ID">
          <el-input v-model="form.defaultPriceListId" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="标准客户表客户地点ID">
          <el-input v-model="form.siteUseId" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="关联客户ID">
          <el-input v-model="form.itemRelCustomerId" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="单证负责人">
          <el-input v-model="form.docHeaderId" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="默认价目表ID">
          <el-input v-model="form.priceListId" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="付款条件ID">
          <el-input v-model="form.paymentTermId" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="收款方式ID">
          <el-input v-model="form.receiptMethodId" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="发货方法ID">
          <el-input v-model="form.carrierId" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="美国报关发票收货人信息">
          <el-input v-model="form.aciCiReceiver" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="美国报关发票买方信息">
          <el-input v-model="form.aciCiBuyerName" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="报关箱单发货人信息">
          <el-input v-model="form.ciPlShipper" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="形式发票导出公司代码">
          <el-input v-model="form.isExportCompanyCode" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="形式发票导出供应商代码">
          <el-input v-model="form.isExportVendorCode" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="供应商代码">
          <el-input v-model="form.vendorNo" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="形式发票导出船公司名称及代码">
          <el-input v-model="form.isExportShipsNameCode" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="形式发票导出TAX ID">
          <el-input v-model="form.isExportTaxId" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="箱单是否导出客户PO号">
          <el-input v-model="form.plOutputPoNo" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="是否需要导出分箱发票箱单">
          <el-input v-model="form.isNeedExInvoicePl" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="苏州发票买方">
          <el-input v-model="form.suzhouInvoiceBuyer" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="苏州发票公司代码">
          <el-input v-model="form.suzhouInvoiceCompanyCode" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="苏州发票供应商代码">
          <el-input v-model="form.suzhouInvoiceSupplierCode" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="苏州发票需要导出付款方式及标识号">
          <el-input v-model="form.suzhouInvoiceOutputPId" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="要求单据类型">
          <el-input v-model="form.requestTypeOfDocDesc" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="寄单地址">
          <el-input v-model="form.sendDocAddress" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="报关价百分比%">
          <el-input v-model="form.priceDiffPer" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="美国价目表">
          <el-input v-model="form.usPriceList" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="香港报关百分比%">
          <el-input v-model="form.hkPricePer" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="是否形式发票分箱单">
          <el-input v-model="form.isPiPk" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="关联美国公司代码">
          <el-input v-model="form.relWbpi" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="开证行英文名称">
          <el-input v-model="form.eNameOfIssuingBank" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="开证行英文地址">
          <el-input v-model="form.eAddressOfIssuingBank" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="中信保买方代码">
          <el-input v-model="form.citicInsuranceCode" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="合同支付方式">
          <el-input v-model="form.iContractPayMethod" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="期限(天)">
          <el-input v-model="form.dayLimit" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="缴费支付方式">
          <el-input v-model="form.iPaymentMethod" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="到款缓冲天数">
          <el-input v-model="form.bufferDays" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="可选所有客户产品编码">
          <el-input v-model="form.chooseAllCustItemFlag" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="默认折扣率">
          <el-input v-model="form.defaultDiscountRate" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="是否强制组托">
          <el-input v-model="form.forcePalletFlag" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="默认折扣率2">
          <el-input v-model="form.defaultDiscountRate2" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="默认第三方仓库">
          <el-input v-model="form.defaultThirdPartSubinv" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="默认托盘编码">
          <el-input v-model="form.defaultPalletNo" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="是否允许自动转R90型号">
          <el-input v-model="form.r90AutoFlag" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="发货人企业代码">
          <el-input v-model="form.shipperVatNum" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="发货人企业代码类型">
          <el-input v-model="form.shipperVarType" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="收货人企业代码">
          <el-input v-model="form.consigneeVatNum" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="收货人企业代码类型">
          <el-input v-model="form.consigneeVarType" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="中国海关互认国家（地区）的企业AEO代码">
          <el-input v-model="form.consigneeAeoNum" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="通知方企业代码">
          <el-input v-model="form.notifierVatNum" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="通知方企业代码类型">
          <el-input v-model="form.notifierVarType" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="save">确 定</el-button>
      </div>
    </el-dialog>

  </div>
</template>

<script>
export default {
  name: "Customer",
  data() {
    const item = {};
    return {
      tableData: [],
      custCode: "",
      orgId: "",
      siteCode: "",
      dialogFormVisible: false,
      dialogTitle: "",
      form: {},
      tabPosition: 'right',
      activeName: 'first',
    }
  },
  created() {
    //
    this.load()
  },
  methods: {
    load() {
      this.requests.get(this.myAxios.base_address_app_service + this.myAxios.address_customer, {
        params: {
          orgId: this.orgId,
          custCode: this.custCode,
          siteCode: this.siteCode
        }
      }).then(res => {
        console.log(res),
            this.tableData = res.data
      })
    },
    reset() {
      this.custCode = ""
      this.orgId = ""
      this.siteCode = ""
      this.load()
    },
    openDialog(row) {
      if (row.id == null) {
        this.dialogTitle = "新增客户信息",
            this.form = {},
            this.dialogFormVisible = true

      } else {
        this.dialogTitle = "修改客户信息",
            this.dialogFormVisible = true,
            this.form = {},
            this.getInformationByIdForUpdate(row)
      }
    },
    getInformationByIdForUpdate(row) {
      this.requests.get(this.myAxios.base_address_app_service + this.myAxios.address_customer, {
        params: {
          Id: row.id
        }
      }).then(res => {
        console.log(res),
            this.form = res.data[0]
      })
    },
    save() {
      if (this.form.id == null) {
        this.requests.post(this.myAxios.base_address_app_service + this.myAxios.address_customer, this.form).then(res => {
          console.log(res),
              this.load()
        })

        this.dialogFormVisible = false,
            this.form = {}

      } else {
        this.requests.put(this.myAxios.base_address_app_service + this.myAxios.address_customer, this.form).then(res => {
          console.log(res),
              this.load()
        })

        this.dialogFormVisible = false,
            this.form = {}

      }
    },
    deleteCustomer(row) {
      if (row.id != null) {
        console.log(row.id),
            this.requests.delete(this.myAxios.base_address_app_service + this.myAxios.address_customer, {
              params: {
                Id: row.id
              }
            }).then(res => {
              console.log(res),
                  this.load()
            })
      }
    },

    /*标签切换*/
    handleClick(tab, event) {
      console.log(tab, event);
    }

  }
}
</script>

<style scoped>
/deep/ .el-dialog {
  border: 12px;
  height: 500px;
  /* background-color: #bdc1cc;*/
}

/deep/ .el-dialog__body {
  overflow-y: auto;
  height: 380px;

}

/deep/ .el-dialog__header {
  background-color: rgb(48, 65, 86);
}

/deep/ .el-dialog__title {
  color: white;
}


/deep/ .el-form-item {
  width: 50%

}

/deep/ .el-form-item {
  color: rgba(89, 84, 84, 0.74);
  /*border: 1px solid*/
}

/deep/ .el-table {
  color: rgba(89, 84, 84, 0.74);
  border: 1px solid
}


/deep/ .el-form-item label {
  color: rgba(23, 16, 17, 0.98);
  /* border: solid;*/
  text-align: right;
  margin-right: 5%;
}


/deep/ .el-tab-pane {
  z-index: 2
}

/*.el-form-item label{
  color: #0e0103;
}*/
/deep/ .el-table__body-wrapper {
  z-index: 2
}

/deep/ .inner_span {
  color: rgba(89, 84, 84, 0.74);
  border: 1px solid;
  width: 100px;

}

</style>