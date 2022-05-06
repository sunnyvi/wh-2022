package com.order_manage.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

@Data
@TableName("invoice_header")
@ApiModel(value="invoice_header对象", description="invoice_header")
public class InvoiceHeader implements Serializable {
    private static final long serialVersionUID = 1L;

	/**记录自增ID*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "记录自增ID")
    private java.lang.Integer id;
	/**客户代码*/
    @Excel(name = "客户代码", width = 15)
    @ApiModelProperty(value = "客户代码")
    private java.lang.String customerCode;
	/**分支代码*/
    @Excel(name = "分支代码", width = 15)
    @ApiModelProperty(value = "分支代码")
    private java.lang.String branchCode;
	/**起运港*/
    @Excel(name = "起运港", width = 15)
    @ApiModelProperty(value = "起运港")
    private java.lang.String portOfLoading;
	/**卸货港*/
    @Excel(name = "卸货港", width = 15)
    @ApiModelProperty(value = "卸货港")
    private java.lang.String portOfDischarge;
	/**目的港*/
    @Excel(name = "目的港", width = 15)
    @ApiModelProperty(value = "目的港")
    private java.lang.String portOfDestination;
	/**收货人企业代码类型*/
    @Excel(name = "收货人企业代码类型", width = 15)
    @ApiModelProperty(value = "收货人企业代码类型")
    private java.lang.String ecTypeConsignee;
	/**收货人企业代码*/
    @Excel(name = "收货人企业代码", width = 15)
    @ApiModelProperty(value = "收货人企业代码")
    private java.lang.String ecConsignee;
	/**通知方企业代码类型*/
    @Excel(name = "通知方企业代码类型", width = 15)
    @ApiModelProperty(value = "通知方企业代码类型")
    private java.lang.String ecTypeNotify;
	/**通知方企业代码*/
    @Excel(name = "通知方企业代码", width = 15)
    @ApiModelProperty(value = "通知方企业代码")
    private java.lang.String ecNotify;
	/**提单类型*/
    @Excel(name = "提单类型", width = 15)
    @ApiModelProperty(value = "提单类型")
    private java.lang.String bolType;
	/**提单发货方信息*/
    @Excel(name = "提单发货方信息", width = 15)
    @ApiModelProperty(value = "提单发货方信息")
    private java.lang.String bolShipperInfo;
	/**提单收货方信息*/
    @Excel(name = "提单收货方信息", width = 15)
    @ApiModelProperty(value = "提单收货方信息")
    private java.lang.String bolConsigneeInfo;
	/**提单通知方信息*/
    @Excel(name = "提单通知方信息", width = 15)
    @ApiModelProperty(value = "提单通知方信息")
    private java.lang.String bolNotifyInfo;
	/**提单条款*/
    @Excel(name = "提单条款", width = 15)
    @ApiModelProperty(value = "提单条款")
    private java.lang.String freightTerm;
	/**货物品名*/
    @Excel(name = "货物品名", width = 15)
    @ApiModelProperty(value = "货物品名")
    private java.lang.String articleDescription;
	/**提单到门地址*/
    @Excel(name = "提单到门地址", width = 15)
    @ApiModelProperty(value = "提单到门地址")
    private java.lang.String bolDoorAddress;
	/**唛头信息*/
    @Excel(name = "唛头信息", width = 15)
    @ApiModelProperty(value = "唛头信息")
    private java.lang.String shippingMark;
	/**发票Ship To信息*/
    @Excel(name = "发票Ship To信息", width = 15)
    @ApiModelProperty(value = "发票Ship To信息")
    private java.lang.String ciShipTo;
	/**箱单Ship To信息*/
    @Excel(name = "箱单Ship To信息", width = 15)
    @ApiModelProperty(value = "箱单Ship To信息")
    private java.lang.String plShipTo;
	/**报关价格条款*/
    @Excel(name = "报关价格条款", width = 15)
    @ApiModelProperty(value = "报关价格条款")
    private java.lang.String customsClearancePriceTerm;
	/**收款价格条款*/
    @Excel(name = "收款价格条款", width = 15)
    @ApiModelProperty(value = "收款价格条款")
    private java.lang.String receiptPriceTerm;
	/**币种*/
    @Excel(name = "币种", width = 15)
    @ApiModelProperty(value = "币种")
    private java.lang.String settlementCurrency;
	/**付款条件*/
    @Excel(name = "付款条件", width = 15)
    @ApiModelProperty(value = "付款条件")
    private java.lang.String paymentTerm;
	/**主提单号码*/
    @Excel(name = "主提单号码", width = 15)
    @ApiModelProperty(value = "主提单号码")
    private java.lang.String masterBolNumber;
	/**分提单号码*/
    @Excel(name = "分提单号码", width = 15)
    @ApiModelProperty(value = "分提单号码")
    private java.lang.String houseBolNumber;
	/**发票号码*/
    @Excel(name = "发票号码", width = 15)
    @ApiModelProperty(value = "发票号码")
    private java.lang.String invoiceNumber;
	/**发票日期*/
    @Excel(name = "发票日期", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "发票日期")
    private java.util.Date invoiceDate;
	/**报关海运费*/
    @Excel(name = "报关海运费", width = 15)
    @ApiModelProperty(value = "报关海运费")
    private java.lang.Integer freightChargeCustoms;
	/**货船名称*/
    @Excel(name = "货船名称", width = 15)
    @ApiModelProperty(value = "货船名称")
    private java.lang.String vessel;
	/**航次名称*/
    @Excel(name = "航次名称", width = 15)
    @ApiModelProperty(value = "航次名称")
    private java.lang.String voyage;
	/**提单日期*/
    @Excel(name = "提单日期", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "提单日期")
    private java.util.Date bolDate;
	/**创建时间*/
    @Excel(name = "创建时间", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "创建时间")
    private java.util.Date creationDate;
	/**创建人ID，外键（用户表）*/
    @Excel(name = "创建人ID，外键（用户表）", width = 15)
    @ApiModelProperty(value = "创建人ID，外键（用户表）")
    private java.lang.Integer createdBy;
	/**最近修改时间*/
    @Excel(name = "最近修改时间", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "最近修改时间")
    private java.util.Date lastUpdatedDate;
	/**最近修改人ID，外键（用户表）*/
    @Excel(name = "最近修改人ID，外键（用户表）", width = 15)
    @ApiModelProperty(value = "最近修改人ID，外键（用户表）")
    private java.lang.Integer lastUpdatedBy;
}