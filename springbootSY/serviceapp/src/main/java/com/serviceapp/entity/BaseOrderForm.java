package com.serviceapp.entity;



import java.util.Date;

public class BaseOrderForm {



    /**
     * 主键
     */

    private Integer id;
    /**
     * 订单编号，根据烧蚀与否，后加-s
     */
    private String orderNumS;
    /**
     * 订单号
     */
    private String orderNo;
    /**
     * 客户号
     */
    private String custNo;
    /**
     * 鲁达号
     */
    private String ludaCode;
    /**
     * 胜地号
     */
    private String sdCode;
    /**
     * 订单数量
     */
    private Integer orderQuantity;
    /**
     * 配方
     */
    private String formula;
    /**
     * 盒类
     */
    private String boxClass;
    /**
     * 备注
     */
    private String remarks;
    /**
     * 交货日期
     */
    private Date deliveryDate;

    private String emarkNo;

    private String wvaNo;

    private String oeNo;

    private String frNo;
    /**
     * 彩盒条形码
     */
    private String barCodeColorbox;
    /**
     * 外箱条形码
     */
    private String barCodeOuterbox;
    /**
     * 车型
     */
    private String model;
    /**
     * 钢背喷码
     */
    private String backMark;
    /**
     * emark证书上的鲁达号
     */
    private String ludaCodeEmark;
    /**
     * emark证书上的配方号
     */
    private String formulaEmark;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 更新者
     */
    private String updateBy;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 创建者
     */
    private String createBy;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNumS() {
        return orderNumS;
    }

    public void setOrderNumS(String orderNumS) {
        this.orderNumS = orderNumS;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getCustNo() {
        return custNo;
    }

    public void setCustNo(String custNo) {
        this.custNo = custNo;
    }

    public String getLudaCode() {
        return ludaCode;
    }

    public void setLudaCode(String ludaCode) {
        this.ludaCode = ludaCode;
    }

    public String getSdCode() {
        return sdCode;
    }

    public void setSdCode(String sdCode) {
        this.sdCode = sdCode;
    }

    public Integer getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(Integer orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public String getBoxClass() {
        return boxClass;
    }

    public void setBoxClass(String boxClass) {
        this.boxClass = boxClass;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getEmarkNo() {
        return emarkNo;
    }

    public void setEmarkNo(String emarkNo) {
        this.emarkNo = emarkNo;
    }

    public String getWvaNo() {
        return wvaNo;
    }

    public void setWvaNo(String wvaNo) {
        this.wvaNo = wvaNo;
    }

    public String getOeNo() {
        return oeNo;
    }

    public void setOeNo(String oeNo) {
        this.oeNo = oeNo;
    }

    public String getFrNo() {
        return frNo;
    }

    public void setFrNo(String frNo) {
        this.frNo = frNo;
    }

    public String getBarCodeColorbox() {
        return barCodeColorbox;
    }

    public void setBarCodeColorbox(String barCodeColorbox) {
        this.barCodeColorbox = barCodeColorbox;
    }

    public String getBarCodeOuterbox() {
        return barCodeOuterbox;
    }

    public void setBarCodeOuterbox(String barCodeOuterbox) {
        this.barCodeOuterbox = barCodeOuterbox;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBackMark() {
        return backMark;
    }

    public void setBackMark(String backMark) {
        this.backMark = backMark;
    }

    public String getLudaCodeEmark() {
        return ludaCodeEmark;
    }

    public void setLudaCodeEmark(String ludaCodeEmark) {
        this.ludaCodeEmark = ludaCodeEmark;
    }

    public String getFormulaEmark() {
        return formulaEmark;
    }

    public void setFormulaEmark(String formulaEmark) {
        this.formulaEmark = formulaEmark;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }


    @Override
    public String toString() {
        return "BaseOrderForm{" +
                "id=" + id +
                ", orderNumS='" + orderNumS + '\'' +
                ", orderNo='" + orderNo + '\'' +
                ", custNo='" + custNo + '\'' +
                ", ludaCode='" + ludaCode + '\'' +
                ", sdCode='" + sdCode + '\'' +
                ", orderQuantity=" + orderQuantity +
                ", formula='" + formula + '\'' +
                ", boxClass='" + boxClass + '\'' +
                ", remarks='" + remarks + '\'' +
                ", deliveryDate=" + deliveryDate +
                ", emarkNo='" + emarkNo + '\'' +
                ", wvaNo='" + wvaNo + '\'' +
                ", oeNo='" + oeNo + '\'' +
                ", frNo='" + frNo + '\'' +
                ", barCodeColorbox='" + barCodeColorbox + '\'' +
                ", barCodeOuterbox='" + barCodeOuterbox + '\'' +
                ", model='" + model + '\'' +
                ", backMark='" + backMark + '\'' +
                ", ludaCodeEmark='" + ludaCodeEmark + '\'' +
                ", formulaEmark='" + formulaEmark + '\'' +
                ", updateTime=" + updateTime +
                ", updateBy='" + updateBy + '\'' +
                ", createTime=" + createTime +
                ", createBy='" + createBy + '\'' +
                '}';
    }
}


