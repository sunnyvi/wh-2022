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

	/**id*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "id")
    private java.lang.Integer id;
	/**发货单编号*/
    @Excel(name = "发货单编号", width = 15)
    @ApiModelProperty(value = "发货单编号")
    private java.lang.String shippingOrderNumber;
	/**客户-分支记录ID，外键（客户分支表）*/
    @Excel(name = "客户-分支记录ID，外键（客户分支表）", width = 15)
    @ApiModelProperty(value = "客户-分支记录ID，外键（客户分支表）")
    private java.lang.Integer customerBranchId;
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
    private java.lang.Integer tareWeight;
	/**加收项目名称*/
    @Excel(name = "加收项目名称", width = 15)
    @ApiModelProperty(value = "加收项目名称")
    private java.lang.String surchargeItemName;
	/**加收项目金额*/
    @Excel(name = "加收项目金额", width = 15)
    @ApiModelProperty(value = "加收项目金额")
    private java.lang.Integer surchargeItemAmount;
	/**折扣项目名称*/
    @Excel(name = "折扣项目名称", width = 15)
    @ApiModelProperty(value = "折扣项目名称")
    private java.lang.String discountItemName;
	/**折扣项目金额*/
    @Excel(name = "折扣项目金额", width = 15)
    @ApiModelProperty(value = "折扣项目金额")
    private java.lang.Integer discountItemAmount;
	/**绑定的提单记录ID，外键（发票表）*/
    @Excel(name = "绑定的提单记录ID，外键（发票表）", width = 15)
    @ApiModelProperty(value = "绑定的提单记录ID，外键（发票表）")
    private java.lang.Integer bolId;
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