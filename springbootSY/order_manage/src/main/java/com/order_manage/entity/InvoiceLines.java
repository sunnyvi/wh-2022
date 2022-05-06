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
@TableName("invoice_lines")
@ApiModel(value="invoice_lines对象", description="invoice_lines")
public class InvoiceLines implements Serializable {
    private static final long serialVersionUID = 1L;

	/**记录自增ID*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "记录自增ID")
    private java.lang.Integer id;
	/**发票头记录ID，外键（发票头表）*/
    @ApiModelProperty(value = "发票头记录ID，外键（发票头表）")
    private java.lang.Integer headerId;
	/**销售订单编号*/
	@Excel(name = "销售订单编号", width = 15)
    @ApiModelProperty(value = "销售订单编号")
    private java.lang.String salesOrderNumber;
	/**客户订单编号*/
	@Excel(name = "客户订单编号", width = 15)
    @ApiModelProperty(value = "客户订单编号")
    private java.lang.String purchaseOrderNumber;
	/**交货期*/
	@Excel(name = "交货期", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "交货期")
    private java.util.Date requestedDeliveryDate;
	/**客户型号*/
	@Excel(name = "客户型号", width = 15)
    @ApiModelProperty(value = "客户型号")
    private java.lang.String customerPartNumber;
	/**鲁达型号*/
	@Excel(name = "鲁达型号", width = 15)
    @ApiModelProperty(value = "鲁达型号")
    private java.lang.String ludaPartNumber;
	/**胜地型号*/
	@Excel(name = "胜地型号", width = 15)
    @ApiModelProperty(value = "胜地型号")
    private java.lang.String winherePartNumber;
	/**单价*/
	@Excel(name = "单价", width = 15)
    @ApiModelProperty(value = "单价")
    private java.lang.Double unitPrice;
	/**订单数量*/
	@Excel(name = "订单数量", width = 15)
    @ApiModelProperty(value = "订单数量")
    private java.lang.Double purchaseOrderQuantity;
	/**配方代码*/
	@Excel(name = "配方代码", width = 15)
    @ApiModelProperty(value = "配方代码")
    private java.lang.String formulaCode;
	/**盒类*/
	@Excel(name = "盒类", width = 15)
    @ApiModelProperty(value = "盒类")
    private java.lang.String boxType;
	/**订单备注*/
	@Excel(name = "订单备注", width = 15)
    @ApiModelProperty(value = "订单备注")
    private java.lang.String remark;
	/**E-mark号码*/
	@Excel(name = "E-mark号码", width = 15)
    @ApiModelProperty(value = "E-mark号码")
    private java.lang.String emarkNumber;
	/**WVA号码*/
	@Excel(name = "WVA号码", width = 15)
    @ApiModelProperty(value = "WVA号码")
    private java.lang.String wvaNumber;
	/**OE号码*/
	@Excel(name = "OE号码", width = 15)
    @ApiModelProperty(value = "OE号码")
    private java.lang.String oeNumber;
	/**型号安装位置*/
	@Excel(name = "型号安装位置", width = 15)
    @ApiModelProperty(value = "型号安装位置")
    private java.lang.String frontRear;
	/**彩盒条形码*/
	@Excel(name = "彩盒条形码", width = 15)
    @ApiModelProperty(value = "彩盒条形码")
    private java.lang.String boxBarcode;
	/**外箱条形码*/
	@Excel(name = "外箱条形码", width = 15)
    @ApiModelProperty(value = "外箱条形码")
    private java.lang.String cartonBarcode;
	/**车型*/
	@Excel(name = "车型", width = 15)
    @ApiModelProperty(value = "车型")
    private java.lang.String vehicleApplication;
	/**钢背喷码*/
	@Excel(name = "钢背喷码", width = 15)
    @ApiModelProperty(value = "钢背喷码")
    private java.lang.String backPlatePrintedCode;
	/**E-mark证书上的鲁达型号*/
	@Excel(name = "E-mark证书上的鲁达型号", width = 15)
    @ApiModelProperty(value = "E-mark证书上的鲁达型号")
    private java.lang.String r90CertLudaPartNumber;
	/**E-mark证书上的配方代码*/
	@Excel(name = "E-mark证书上的配方代码", width = 15)
    @ApiModelProperty(value = "E-mark证书上的配方代码")
    private java.lang.String r90CertFormulaCode;
	/**发货单编号*/
	@Excel(name = "发货单编号", width = 15)
    @ApiModelProperty(value = "发货单编号")
    private java.lang.String shippingOrderNumber;
	/**集装箱名称*/
	@Excel(name = "集装箱名称", width = 15)
    @ApiModelProperty(value = "集装箱名称")
    private java.lang.String containerName;
	/**铅封号码*/
	@Excel(name = "铅封号码", width = 15)
    @ApiModelProperty(value = "铅封号码")
    private java.lang.String sealNumber;
	/**货柜皮重*/
	@Excel(name = "货柜皮重", width = 15)
    @ApiModelProperty(value = "货柜皮重")
    private java.lang.Double tareWeight;
	/**发货日期*/
	@Excel(name = "发货日期", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "发货日期")
    private java.util.Date shippingDate;
	/**实装数量*/
	@Excel(name = "实装数量", width = 15)
    @ApiModelProperty(value = "实装数量")
    private java.lang.Integer shippedQuantity;
	/**托号*/
	@Excel(name = "托号", width = 15)
    @ApiModelProperty(value = "托号")
    private java.lang.Integer palletNumber;
	/**数量/箱*/
	@Excel(name = "数量/箱", width = 15)
    @ApiModelProperty(value = "数量/箱")
    private java.lang.Integer quantityPerCarton;
	/**箱数*/
	@Excel(name = "箱数", width = 15)
    @ApiModelProperty(value = "箱数")
    private java.lang.Integer cartonQuantity;
	/**序号*/
	@Excel(name = "序号", width = 15)
    @ApiModelProperty(value = "序号")
    private java.lang.String boxSequence;
	/**托盘毛重*/
	@Excel(name = "托盘毛重", width = 15)
    @ApiModelProperty(value = "托盘毛重")
    private java.lang.Double palletGrossWeight;
	/**集装箱编号*/
	@Excel(name = "集装箱编号", width = 15)
    @ApiModelProperty(value = "集装箱编号")
    private java.lang.Integer containerNumber;
	/**托盘尺寸*/
	@Excel(name = "托盘尺寸", width = 15)
    @ApiModelProperty(value = "托盘尺寸")
    private java.lang.String palletSize;
	/**托盘净重*/
	@Excel(name = "托盘净重", width = 15)
    @ApiModelProperty(value = "托盘净重")
    private java.lang.Double palletNetWeight;
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