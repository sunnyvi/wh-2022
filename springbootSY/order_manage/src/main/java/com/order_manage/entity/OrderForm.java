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
 * @TableName order_form
 */
@ApiModel(value="order_form对象", description="order_form")
@Data
@TableName(value ="order_form")
public class OrderForm implements Serializable {
    private static final long serialVersionUID = 1L;

    /**id*/
    @TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "id")
    private java.lang.Integer id;
    /**headerId*/
    @ApiModelProperty(value = "headerId")
    private java.lang.Integer headerId;
    /**订单编号，根据烧蚀与否，后加-s*/
    @Excel(name = "订单编号，根据烧蚀与否，后加-s", width = 15)
    @ApiModelProperty(value = "订单编号，根据烧蚀与否，后加-s")
    private java.lang.String orderNumS;
    /**订单号*/
    @Excel(name = "订单号", width = 15)
    @ApiModelProperty(value = "订单号")
    private java.lang.String orderNo;
    /**客户号*/
    @Excel(name = "客户号", width = 15)
    @ApiModelProperty(value = "客户号")
    private java.lang.String custNo;
    /**鲁达号*/
    @Excel(name = "鲁达号", width = 15)
    @ApiModelProperty(value = "鲁达号")
    private java.lang.String ludaCode;
    /**胜地号*/
    @Excel(name = "胜地号", width = 15)
    @ApiModelProperty(value = "胜地号")
    private java.lang.String sdCode;
    /**订单数量*/
    @Excel(name = "订单数量", width = 15)
    @ApiModelProperty(value = "订单数量")
    private java.lang.Integer orderQuantity;
    /**配方*/
    @Excel(name = "配方", width = 15)
    @ApiModelProperty(value = "配方")
    private java.lang.String formula;
    /**盒类*/
    @Excel(name = "盒类", width = 15)
    @ApiModelProperty(value = "盒类")
    private java.lang.String boxClass;
    /**备注*/
    @Excel(name = "备注", width = 15)
    @ApiModelProperty(value = "备注")
    private java.lang.String remarks;
    /**交货日期*/
    @Excel(name = "交货日期", width = 15, format = "yyyy-MM-dd")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "交货日期")
    private java.util.Date deliveryDate;
    /**emarkNo*/
    @Excel(name = "emarkNo", width = 15)
    @ApiModelProperty(value = "emarkNo")
    private java.lang.String emarkNo;
    /**wvaNo*/
    @Excel(name = "wvaNo", width = 15)
    @ApiModelProperty(value = "wvaNo")
    private java.lang.String wvaNo;
    /**oeNo*/
    @Excel(name = "oeNo", width = 15)
    @ApiModelProperty(value = "oeNo")
    private java.lang.String oeNo;
    /**frNo*/
    @Excel(name = "frNo", width = 15)
    @ApiModelProperty(value = "frNo")
    private java.lang.String frNo;
    /**彩盒条形码*/
    @Excel(name = "彩盒条形码", width = 15)
    @ApiModelProperty(value = "彩盒条形码")
    private java.lang.String barCodeColorbox;
    /**外箱条形码*/
    @Excel(name = "外箱条形码", width = 15)
    @ApiModelProperty(value = "外箱条形码")
    private java.lang.String barCodeOuterbox;
    /**车型*/
    @Excel(name = "车型", width = 15)
    @ApiModelProperty(value = "车型")
    private java.lang.String model;
    /**钢背喷码*/
    @Excel(name = "钢背喷码", width = 15)
    @ApiModelProperty(value = "钢背喷码")
    private java.lang.String backMark;
    /**emark证书上的鲁达号*/
    @Excel(name = "emark证书上的鲁达号", width = 15)
    @ApiModelProperty(value = "emark证书上的鲁达号")
    private java.lang.String ludaCodeEmark;
    /**emark证书上的配方号*/
    @Excel(name = "emark证书上的配方号", width = 15)
    @ApiModelProperty(value = "emark证书上的配方号")
    private java.lang.String formulaEmark;
    /**更新时间*/
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "更新时间")
    private java.util.Date updateTime;
    /**更新者*/
    @ApiModelProperty(value = "更新者")
    private java.lang.String updateBy;
    /**创建时间*/
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "创建时间")
    private java.util.Date createTime;
    /**创建者*/
    @ApiModelProperty(value = "创建者")
    private java.lang.String createBy;


}