package com.order_manage.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName order_header
 */
@ApiModel(value="order_header对象", description="order_header")
@Data
@TableName(value ="order_header")
public class OrderHeader implements Serializable {
    /**
     * 记录自增ID
     */
    private static final long serialVersionUID = 1L;

    /**记录自增ID*/
    @TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "记录自增ID")
    private java.lang.Integer id;
    /**客户订单号*/
    @Excel(name = "客户订单号", width = 15)
    @ApiModelProperty(value = "客户订单号")
    private java.lang.String custPoNumber;
    /**订单日期*/
    @Excel(name = "订单日期", width = 15, format = "yyyy-MM-dd")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "订单日期")
    private java.util.Date orderedDate;
    /**订单币种*/
    @Excel(name = "订单币种", width = 15)
    @ApiModelProperty(value = "订单币种")
    private java.lang.String transactionalCurrCode;
    /**订单下发工厂日期*/
    @Excel(name = "订单下发工厂日期", width = 15, format = "yyyy-MM-dd")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "订单下发工厂日期")
    private java.util.Date sendToFacDate;
    /**工厂确认交货期*/
    @Excel(name = "工厂确认交货期", width = 15, format = "yyyy-MM-dd")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "工厂确认交货期")
    private java.util.Date facConfirmDate;
    /**订单折扣率*/
    @Excel(name = "订单折扣率", width = 15)
    @ApiModelProperty(value = "订单折扣率")
    private java.lang.Integer orderDiscount;
    /**创建时间*/
    @Excel(name = "创建时间", width = 15, format = "yyyy-MM-dd")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "创建时间")
    private java.util.Date creationDate;
    /**最近修改时间*/
    @Excel(name = "最近修改时间", width = 15, format = "yyyy-MM-dd")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "最近修改时间")
    private java.util.Date lastUpdateDate;
    /**客户编码*/
    @Excel(name = "客户编码", width = 15)
    @ApiModelProperty(value = "客户编码")
    private java.lang.String attributeCategory;
    /**attribute1*/
    @Excel(name = "attribute1", width = 15)
    @ApiModelProperty(value = "attribute1")
    private java.lang.String attribute1;
    /**attribute2*/
    @Excel(name = "attribute2", width = 15)
    @ApiModelProperty(value = "attribute2")
    private java.lang.String attribute2;
    /**attribute3*/
    @Excel(name = "attribute3", width = 15)
    @ApiModelProperty(value = "attribute3")
    private java.lang.String attribute3;
    /**attribute4*/
    @Excel(name = "attribute4", width = 15)
    @ApiModelProperty(value = "attribute4")
    private java.lang.String attribute4;
    /**attribute5*/
    @Excel(name = "attribute5", width = 15)
    @ApiModelProperty(value = "attribute5")
    private java.lang.String attribute5;
    /**attribute6*/
    @Excel(name = "attribute6", width = 15)
    @ApiModelProperty(value = "attribute6")
    private java.lang.String attribute6;
    /**attribute7*/
    @Excel(name = "attribute7", width = 15)
    @ApiModelProperty(value = "attribute7")
    private java.lang.String attribute7;
    /**attribute8*/
    @Excel(name = "attribute8", width = 15)
    @ApiModelProperty(value = "attribute8")
    private java.lang.String attribute8;
    /**attribute9*/
    @Excel(name = "attribute9", width = 15)
    @ApiModelProperty(value = "attribute9")
    private java.lang.String attribute9;
    /**attribute10*/
    @Excel(name = "attribute10", width = 15)
    @ApiModelProperty(value = "attribute10")
    private java.lang.String attribute10;
    /**attribute11*/
    @Excel(name = "attribute11", width = 15)
    @ApiModelProperty(value = "attribute11")
    private java.lang.String attribute11;
    /**attribute12*/
    @Excel(name = "attribute12", width = 15)
    @ApiModelProperty(value = "attribute12")
    private java.lang.String attribute12;
    /**attribute13*/
    @Excel(name = "attribute13", width = 15)
    @ApiModelProperty(value = "attribute13")
    private java.lang.String attribute13;
    /**attribute14*/
    @Excel(name = "attribute14", width = 15)
    @ApiModelProperty(value = "attribute14")
    private java.lang.String attribute14;
    /**attribute15*/
    @Excel(name = "attribute15", width = 15)
    @ApiModelProperty(value = "attribute15")
    private java.lang.String attribute15;
    /**订单折扣率（折上折）*/
    @Excel(name = "订单折扣率（折上折）", width = 15)
    @ApiModelProperty(value = "订单折扣率（折上折）")
    private java.lang.Integer defaultDiscountRate2;
}