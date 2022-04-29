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
@TableName("invoice_line")
@ApiModel(value="invoice_line对象", description="invoice_line")
public class InvoiceLine implements Serializable {
    private static final long serialVersionUID = 1L;

	/**id*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "id")
    private java.lang.Integer id;
	/**发货单头记录ID，外键（发货单头表）*/
    @ApiModelProperty(value = "发货单头记录ID，外键（发货单头表）")
    private java.lang.Integer headerId;
	/**发货日期*/
	@Excel(name = "发货日期", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "发货日期")
    private java.util.Date shippingDate;
	/**订单头记录ID，外键（订单头表）*/
	@Excel(name = "订单头记录ID，外键（订单头表）", width = 15)
    @ApiModelProperty(value = "订单头记录ID，外键（订单头表）")
    private java.lang.Integer salesOrderHeaderId;
	/**订单行记录ID，外键（订单行表）*/
	@Excel(name = "订单行记录ID，外键（订单行表）", width = 15)
    @ApiModelProperty(value = "订单行记录ID，外键（订单行表）")
    private java.lang.Integer salesOrderLineId;
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
}