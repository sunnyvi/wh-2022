package com.custmanager.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.io.Serializable;

/**
 * (Cust)实体类
 *
 * @author makejava
 * @since 2022-03-20 12:04:18
 */
@TableName("cust")
@ApiModel("用户信息实体类")
public class Cust implements Serializable {
    private static final long serialVersionUID = 209628037404215902L;

    @TableId(type = IdType.AUTO)
    @ApiModelProperty(value = "主键",required = true)
    private Integer id;
    @ApiModelProperty(value = "客户属性ID",required = true)
    private Integer custSiteAttId;
    @ApiModelProperty(value = "经营实体",required = true)
    private Integer orgId;
    @ApiModelProperty(value = "客户代码",required = true)
    private String custCode;
    @ApiModelProperty("客户全称")
    private String custName;
    
    private String custClass;
    
    private String siteCode;
    
    private String siteAddress;
    
    private String country;
    
    private String city;
    
    private String province;
    
    private String zipCode;
    
    private String creditCtrlMode;
    
    private String creditCtrlTime;
    
    private String deliveryMethod;
    
    private String defaultOrderType;
    
    private String defaultPriceList;
    
    private String itemRelCustomer;
    
    private String isNeedOc;
    
    private String portOfLoading;
    
    private String portOfDischarge;
    
    private String bolShipper;
    
    private String bolConsignee;
    
    private String bolNotifyParty1;
    
    private String bolNotifyParty2;
    
    private String bolNotifyParty3;
    
    private String bolFrtPpyClt;
    
    private String bolDescription;
    
    private String bolDoor;
    
    private String bolMark;
    
    private String piShipper;
    
    private String ciShipper;
    
    private String aciShipper;
    
    private String piShipTo;
    
    private String plShipTo;
    
    private String piBillTo;
    
    private String piSoldTo;
    
    private String custDescription;
    
    private String paymentTermPrice;
    
    private String custDecPriceTerms;
    
    private String custItemCalUom;
    
    private String custItemPriceUom;
    
    private String custItemPalletsUom;
    
    private String piYhIsPalMerge;
    
    private String plNotallowPalMerge;
    
    private String piIsDisplayPaymentType;
    
    private String isPrintDetailWeight;
    
    private String plIsNeedAmount;
    
    private String requestTypeOfDoc;
    
    private String docTransfWay;
    
    private String isNeedSendList;
    
    private String docHead;
    
    private String isBondedArea;
    
    private Integer limitWeightPerContainer;
    
    private Integer limitPalPerContainer;
    
    private Integer limitLevelPerContainer;
    
    private String boxIntMethod;
    
    private String isNeedReport;
    
    private String reportMode;
    
    private String planIsNeedPl;
    
    private String settlementCurrency;
    
    private String taxCode;
    
    private String termsOfPayment;
    
    private String paymentMethod;
    
    private String clientBankAccount;
    
    private String custBaddrAndPhoneNum;
    
    private String isMergeInvoice;
    
    private String attribute1;
    
    private String attribute2;
    
    private String attribute3;
    
    private String attribute4;
    
    private String attribute5;
    
    private String attribute6;
    
    private String attribute7;
    
    private String attribute8;
    
    private String attribute9;
    
    private String attribute10;
    
    private String attribute11;
    
    private String attribute12;
    
    private String attribute13;
    
    private String attribute14;
    
    private String attribute15;
    
    private Date lastUpdateDate;
    
    private Integer lastUpdatedBy;
    
    private Integer lastUpdateLogin;
    
    private Date creationDate;
    
    private Integer createdBy;
    
    private String portOfDestination;
    
    private String creditCtrlModeCode;
    
    private String creditCtrlTimeCode;
    
    private String custClassCode;
    
    private Integer defaultOrderTypeId;
    
    private Integer defaultPriceListId;
    
    private Integer siteUseId;
    
    private Integer itemRelCustomerId;
    
    private Integer docHeaderId;
    
    private Integer priceListId;
    
    private Integer paymentTermId;
    
    private Integer receiptMethodId;
    
    private Integer carrierId;
    
    private String aciCiReceiver;
    
    private String aciCiBuyerName;
    
    private String ciPlShipper;
    
    private String isExportCompanyCode;
    
    private String isExportVendorCode;
    
    private String vendorNo;
    
    private String isExportShipsNameCode;
    
    private String isExportTaxId;
    
    private String plOutputPoNo;
    
    private String isNeedExInvoicePl;
    
    private String suzhouInvoiceBuyer;
    
    private String suzhouInvoiceCompanyCode;
    
    private String suzhouInvoiceSupplierCode;
    
    private String suzhouInvoiceOutputPId;
    
    private String requestTypeOfDocDesc;
    
    private String sendDocAddress;
    
    private Integer priceDiffPer;
    
    private String usPriceList;
    
    private Integer hkPricePer;
    
    private String isPiPk;
    
    private String relWbpi;
    
    private String eNameOfIssuingBank;
    
    private String eAddressOfIssuingBank;
    
    private String citicInsuranceCode;
    
    private String iContractPayMethod;
    
    private Integer dayLimit;
    
    private String iPaymentMethod;
    
    private Integer bufferDays;
    
    private String chooseAllCustItemFlag;
    
    private Integer defaultDiscountRate;
    
    private String forcePalletFlag;
    
    private Integer defaultDiscountRate2;
    
    private String defaultThirdPartSubinv;
    
    private String defaultPalletNo;
    
    private String r90AutoFlag;
    
    private String shipperVatNum;
    
    private String shipperVarType;
    
    private String consigneeVatNum;
    
    private String consigneeVarType;
    
    private String consigneeAeoNum;
    
    private String notifierVatNum;
    
    private String notifierVarType;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCustSiteAttId() {
        return custSiteAttId;
    }

    public void setCustSiteAttId(Integer custSiteAttId) {
        this.custSiteAttId = custSiteAttId;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public String getCustCode() {
        return custCode;
    }

    public void setCustCode(String custCode) {
        this.custCode = custCode;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustClass() {
        return custClass;
    }

    public void setCustClass(String custClass) {
        this.custClass = custClass;
    }

    public String getSiteCode() {
        return siteCode;
    }

    public void setSiteCode(String siteCode) {
        this.siteCode = siteCode;
    }

    public String getSiteAddress() {
        return siteAddress;
    }

    public void setSiteAddress(String siteAddress) {
        this.siteAddress = siteAddress;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCreditCtrlMode() {
        return creditCtrlMode;
    }

    public void setCreditCtrlMode(String creditCtrlMode) {
        this.creditCtrlMode = creditCtrlMode;
    }

    public String getCreditCtrlTime() {
        return creditCtrlTime;
    }

    public void setCreditCtrlTime(String creditCtrlTime) {
        this.creditCtrlTime = creditCtrlTime;
    }

    public String getDeliveryMethod() {
        return deliveryMethod;
    }

    public void setDeliveryMethod(String deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }

    public String getDefaultOrderType() {
        return defaultOrderType;
    }

    public void setDefaultOrderType(String defaultOrderType) {
        this.defaultOrderType = defaultOrderType;
    }

    public String getDefaultPriceList() {
        return defaultPriceList;
    }

    public void setDefaultPriceList(String defaultPriceList) {
        this.defaultPriceList = defaultPriceList;
    }

    public String getItemRelCustomer() {
        return itemRelCustomer;
    }

    public void setItemRelCustomer(String itemRelCustomer) {
        this.itemRelCustomer = itemRelCustomer;
    }

    public String getIsNeedOc() {
        return isNeedOc;
    }

    public void setIsNeedOc(String isNeedOc) {
        this.isNeedOc = isNeedOc;
    }

    public String getPortOfLoading() {
        return portOfLoading;
    }

    public void setPortOfLoading(String portOfLoading) {
        this.portOfLoading = portOfLoading;
    }

    public String getPortOfDischarge() {
        return portOfDischarge;
    }

    public void setPortOfDischarge(String portOfDischarge) {
        this.portOfDischarge = portOfDischarge;
    }

    public String getBolShipper() {
        return bolShipper;
    }

    public void setBolShipper(String bolShipper) {
        this.bolShipper = bolShipper;
    }

    public String getBolConsignee() {
        return bolConsignee;
    }

    public void setBolConsignee(String bolConsignee) {
        this.bolConsignee = bolConsignee;
    }

    public String getBolNotifyParty1() {
        return bolNotifyParty1;
    }

    public void setBolNotifyParty1(String bolNotifyParty1) {
        this.bolNotifyParty1 = bolNotifyParty1;
    }

    public String getBolNotifyParty2() {
        return bolNotifyParty2;
    }

    public void setBolNotifyParty2(String bolNotifyParty2) {
        this.bolNotifyParty2 = bolNotifyParty2;
    }

    public String getBolNotifyParty3() {
        return bolNotifyParty3;
    }

    public void setBolNotifyParty3(String bolNotifyParty3) {
        this.bolNotifyParty3 = bolNotifyParty3;
    }

    public String getBolFrtPpyClt() {
        return bolFrtPpyClt;
    }

    public void setBolFrtPpyClt(String bolFrtPpyClt) {
        this.bolFrtPpyClt = bolFrtPpyClt;
    }

    public String getBolDescription() {
        return bolDescription;
    }

    public void setBolDescription(String bolDescription) {
        this.bolDescription = bolDescription;
    }

    public String getBolDoor() {
        return bolDoor;
    }

    public void setBolDoor(String bolDoor) {
        this.bolDoor = bolDoor;
    }

    public String getBolMark() {
        return bolMark;
    }

    public void setBolMark(String bolMark) {
        this.bolMark = bolMark;
    }

    public String getPiShipper() {
        return piShipper;
    }

    public void setPiShipper(String piShipper) {
        this.piShipper = piShipper;
    }

    public String getCiShipper() {
        return ciShipper;
    }

    public void setCiShipper(String ciShipper) {
        this.ciShipper = ciShipper;
    }

    public String getAciShipper() {
        return aciShipper;
    }

    public void setAciShipper(String aciShipper) {
        this.aciShipper = aciShipper;
    }

    public String getPiShipTo() {
        return piShipTo;
    }

    public void setPiShipTo(String piShipTo) {
        this.piShipTo = piShipTo;
    }

    public String getPlShipTo() {
        return plShipTo;
    }

    public void setPlShipTo(String plShipTo) {
        this.plShipTo = plShipTo;
    }

    public String getPiBillTo() {
        return piBillTo;
    }

    public void setPiBillTo(String piBillTo) {
        this.piBillTo = piBillTo;
    }

    public String getPiSoldTo() {
        return piSoldTo;
    }

    public void setPiSoldTo(String piSoldTo) {
        this.piSoldTo = piSoldTo;
    }

    public String getCustDescription() {
        return custDescription;
    }

    public void setCustDescription(String custDescription) {
        this.custDescription = custDescription;
    }

    public String getPaymentTermPrice() {
        return paymentTermPrice;
    }

    public void setPaymentTermPrice(String paymentTermPrice) {
        this.paymentTermPrice = paymentTermPrice;
    }

    public String getCustDecPriceTerms() {
        return custDecPriceTerms;
    }

    public void setCustDecPriceTerms(String custDecPriceTerms) {
        this.custDecPriceTerms = custDecPriceTerms;
    }

    public String getCustItemCalUom() {
        return custItemCalUom;
    }

    public void setCustItemCalUom(String custItemCalUom) {
        this.custItemCalUom = custItemCalUom;
    }

    public String getCustItemPriceUom() {
        return custItemPriceUom;
    }

    public void setCustItemPriceUom(String custItemPriceUom) {
        this.custItemPriceUom = custItemPriceUom;
    }

    public String getCustItemPalletsUom() {
        return custItemPalletsUom;
    }

    public void setCustItemPalletsUom(String custItemPalletsUom) {
        this.custItemPalletsUom = custItemPalletsUom;
    }

    public String getPiYhIsPalMerge() {
        return piYhIsPalMerge;
    }

    public void setPiYhIsPalMerge(String piYhIsPalMerge) {
        this.piYhIsPalMerge = piYhIsPalMerge;
    }

    public String getPlNotallowPalMerge() {
        return plNotallowPalMerge;
    }

    public void setPlNotallowPalMerge(String plNotallowPalMerge) {
        this.plNotallowPalMerge = plNotallowPalMerge;
    }

    public String getPiIsDisplayPaymentType() {
        return piIsDisplayPaymentType;
    }

    public void setPiIsDisplayPaymentType(String piIsDisplayPaymentType) {
        this.piIsDisplayPaymentType = piIsDisplayPaymentType;
    }

    public String getIsPrintDetailWeight() {
        return isPrintDetailWeight;
    }

    public void setIsPrintDetailWeight(String isPrintDetailWeight) {
        this.isPrintDetailWeight = isPrintDetailWeight;
    }

    public String getPlIsNeedAmount() {
        return plIsNeedAmount;
    }

    public void setPlIsNeedAmount(String plIsNeedAmount) {
        this.plIsNeedAmount = plIsNeedAmount;
    }

    public String getRequestTypeOfDoc() {
        return requestTypeOfDoc;
    }

    public void setRequestTypeOfDoc(String requestTypeOfDoc) {
        this.requestTypeOfDoc = requestTypeOfDoc;
    }

    public String getDocTransfWay() {
        return docTransfWay;
    }

    public void setDocTransfWay(String docTransfWay) {
        this.docTransfWay = docTransfWay;
    }

    public String getIsNeedSendList() {
        return isNeedSendList;
    }

    public void setIsNeedSendList(String isNeedSendList) {
        this.isNeedSendList = isNeedSendList;
    }

    public String getDocHead() {
        return docHead;
    }

    public void setDocHead(String docHead) {
        this.docHead = docHead;
    }

    public String getIsBondedArea() {
        return isBondedArea;
    }

    public void setIsBondedArea(String isBondedArea) {
        this.isBondedArea = isBondedArea;
    }

    public Integer getLimitWeightPerContainer() {
        return limitWeightPerContainer;
    }

    public void setLimitWeightPerContainer(Integer limitWeightPerContainer) {
        this.limitWeightPerContainer = limitWeightPerContainer;
    }

    public Integer getLimitPalPerContainer() {
        return limitPalPerContainer;
    }

    public void setLimitPalPerContainer(Integer limitPalPerContainer) {
        this.limitPalPerContainer = limitPalPerContainer;
    }

    public Integer getLimitLevelPerContainer() {
        return limitLevelPerContainer;
    }

    public void setLimitLevelPerContainer(Integer limitLevelPerContainer) {
        this.limitLevelPerContainer = limitLevelPerContainer;
    }

    public String getBoxIntMethod() {
        return boxIntMethod;
    }

    public void setBoxIntMethod(String boxIntMethod) {
        this.boxIntMethod = boxIntMethod;
    }

    public String getIsNeedReport() {
        return isNeedReport;
    }

    public void setIsNeedReport(String isNeedReport) {
        this.isNeedReport = isNeedReport;
    }

    public String getReportMode() {
        return reportMode;
    }

    public void setReportMode(String reportMode) {
        this.reportMode = reportMode;
    }

    public String getPlanIsNeedPl() {
        return planIsNeedPl;
    }

    public void setPlanIsNeedPl(String planIsNeedPl) {
        this.planIsNeedPl = planIsNeedPl;
    }

    public String getSettlementCurrency() {
        return settlementCurrency;
    }

    public void setSettlementCurrency(String settlementCurrency) {
        this.settlementCurrency = settlementCurrency;
    }

    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    public String getTermsOfPayment() {
        return termsOfPayment;
    }

    public void setTermsOfPayment(String termsOfPayment) {
        this.termsOfPayment = termsOfPayment;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getClientBankAccount() {
        return clientBankAccount;
    }

    public void setClientBankAccount(String clientBankAccount) {
        this.clientBankAccount = clientBankAccount;
    }

    public String getCustBaddrAndPhoneNum() {
        return custBaddrAndPhoneNum;
    }

    public void setCustBaddrAndPhoneNum(String custBaddrAndPhoneNum) {
        this.custBaddrAndPhoneNum = custBaddrAndPhoneNum;
    }

    public String getIsMergeInvoice() {
        return isMergeInvoice;
    }

    public void setIsMergeInvoice(String isMergeInvoice) {
        this.isMergeInvoice = isMergeInvoice;
    }

    public String getAttribute1() {
        return attribute1;
    }

    public void setAttribute1(String attribute1) {
        this.attribute1 = attribute1;
    }

    public String getAttribute2() {
        return attribute2;
    }

    public void setAttribute2(String attribute2) {
        this.attribute2 = attribute2;
    }

    public String getAttribute3() {
        return attribute3;
    }

    public void setAttribute3(String attribute3) {
        this.attribute3 = attribute3;
    }

    public String getAttribute4() {
        return attribute4;
    }

    public void setAttribute4(String attribute4) {
        this.attribute4 = attribute4;
    }

    public String getAttribute5() {
        return attribute5;
    }

    public void setAttribute5(String attribute5) {
        this.attribute5 = attribute5;
    }

    public String getAttribute6() {
        return attribute6;
    }

    public void setAttribute6(String attribute6) {
        this.attribute6 = attribute6;
    }

    public String getAttribute7() {
        return attribute7;
    }

    public void setAttribute7(String attribute7) {
        this.attribute7 = attribute7;
    }

    public String getAttribute8() {
        return attribute8;
    }

    public void setAttribute8(String attribute8) {
        this.attribute8 = attribute8;
    }

    public String getAttribute9() {
        return attribute9;
    }

    public void setAttribute9(String attribute9) {
        this.attribute9 = attribute9;
    }

    public String getAttribute10() {
        return attribute10;
    }

    public void setAttribute10(String attribute10) {
        this.attribute10 = attribute10;
    }

    public String getAttribute11() {
        return attribute11;
    }

    public void setAttribute11(String attribute11) {
        this.attribute11 = attribute11;
    }

    public String getAttribute12() {
        return attribute12;
    }

    public void setAttribute12(String attribute12) {
        this.attribute12 = attribute12;
    }

    public String getAttribute13() {
        return attribute13;
    }

    public void setAttribute13(String attribute13) {
        this.attribute13 = attribute13;
    }

    public String getAttribute14() {
        return attribute14;
    }

    public void setAttribute14(String attribute14) {
        this.attribute14 = attribute14;
    }

    public String getAttribute15() {
        return attribute15;
    }

    public void setAttribute15(String attribute15) {
        this.attribute15 = attribute15;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Integer getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(Integer lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public Integer getLastUpdateLogin() {
        return lastUpdateLogin;
    }

    public void setLastUpdateLogin(Integer lastUpdateLogin) {
        this.lastUpdateLogin = lastUpdateLogin;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public String getPortOfDestination() {
        return portOfDestination;
    }

    public void setPortOfDestination(String portOfDestination) {
        this.portOfDestination = portOfDestination;
    }

    public String getCreditCtrlModeCode() {
        return creditCtrlModeCode;
    }

    public void setCreditCtrlModeCode(String creditCtrlModeCode) {
        this.creditCtrlModeCode = creditCtrlModeCode;
    }

    public String getCreditCtrlTimeCode() {
        return creditCtrlTimeCode;
    }

    public void setCreditCtrlTimeCode(String creditCtrlTimeCode) {
        this.creditCtrlTimeCode = creditCtrlTimeCode;
    }

    public String getCustClassCode() {
        return custClassCode;
    }

    public void setCustClassCode(String custClassCode) {
        this.custClassCode = custClassCode;
    }

    public Integer getDefaultOrderTypeId() {
        return defaultOrderTypeId;
    }

    public void setDefaultOrderTypeId(Integer defaultOrderTypeId) {
        this.defaultOrderTypeId = defaultOrderTypeId;
    }

    public Integer getDefaultPriceListId() {
        return defaultPriceListId;
    }

    public void setDefaultPriceListId(Integer defaultPriceListId) {
        this.defaultPriceListId = defaultPriceListId;
    }

    public Integer getSiteUseId() {
        return siteUseId;
    }

    public void setSiteUseId(Integer siteUseId) {
        this.siteUseId = siteUseId;
    }

    public Integer getItemRelCustomerId() {
        return itemRelCustomerId;
    }

    public void setItemRelCustomerId(Integer itemRelCustomerId) {
        this.itemRelCustomerId = itemRelCustomerId;
    }

    public Integer getDocHeaderId() {
        return docHeaderId;
    }

    public void setDocHeaderId(Integer docHeaderId) {
        this.docHeaderId = docHeaderId;
    }

    public Integer getPriceListId() {
        return priceListId;
    }

    public void setPriceListId(Integer priceListId) {
        this.priceListId = priceListId;
    }

    public Integer getPaymentTermId() {
        return paymentTermId;
    }

    public void setPaymentTermId(Integer paymentTermId) {
        this.paymentTermId = paymentTermId;
    }

    public Integer getReceiptMethodId() {
        return receiptMethodId;
    }

    public void setReceiptMethodId(Integer receiptMethodId) {
        this.receiptMethodId = receiptMethodId;
    }

    public Integer getCarrierId() {
        return carrierId;
    }

    public void setCarrierId(Integer carrierId) {
        this.carrierId = carrierId;
    }

    public String getAciCiReceiver() {
        return aciCiReceiver;
    }

    public void setAciCiReceiver(String aciCiReceiver) {
        this.aciCiReceiver = aciCiReceiver;
    }

    public String getAciCiBuyerName() {
        return aciCiBuyerName;
    }

    public void setAciCiBuyerName(String aciCiBuyerName) {
        this.aciCiBuyerName = aciCiBuyerName;
    }

    public String getCiPlShipper() {
        return ciPlShipper;
    }

    public void setCiPlShipper(String ciPlShipper) {
        this.ciPlShipper = ciPlShipper;
    }

    public String getIsExportCompanyCode() {
        return isExportCompanyCode;
    }

    public void setIsExportCompanyCode(String isExportCompanyCode) {
        this.isExportCompanyCode = isExportCompanyCode;
    }

    public String getIsExportVendorCode() {
        return isExportVendorCode;
    }

    public void setIsExportVendorCode(String isExportVendorCode) {
        this.isExportVendorCode = isExportVendorCode;
    }

    public String getVendorNo() {
        return vendorNo;
    }

    public void setVendorNo(String vendorNo) {
        this.vendorNo = vendorNo;
    }

    public String getIsExportShipsNameCode() {
        return isExportShipsNameCode;
    }

    public void setIsExportShipsNameCode(String isExportShipsNameCode) {
        this.isExportShipsNameCode = isExportShipsNameCode;
    }

    public String getIsExportTaxId() {
        return isExportTaxId;
    }

    public void setIsExportTaxId(String isExportTaxId) {
        this.isExportTaxId = isExportTaxId;
    }

    public String getPlOutputPoNo() {
        return plOutputPoNo;
    }

    public void setPlOutputPoNo(String plOutputPoNo) {
        this.plOutputPoNo = plOutputPoNo;
    }

    public String getIsNeedExInvoicePl() {
        return isNeedExInvoicePl;
    }

    public void setIsNeedExInvoicePl(String isNeedExInvoicePl) {
        this.isNeedExInvoicePl = isNeedExInvoicePl;
    }

    public String getSuzhouInvoiceBuyer() {
        return suzhouInvoiceBuyer;
    }

    public void setSuzhouInvoiceBuyer(String suzhouInvoiceBuyer) {
        this.suzhouInvoiceBuyer = suzhouInvoiceBuyer;
    }

    public String getSuzhouInvoiceCompanyCode() {
        return suzhouInvoiceCompanyCode;
    }

    public void setSuzhouInvoiceCompanyCode(String suzhouInvoiceCompanyCode) {
        this.suzhouInvoiceCompanyCode = suzhouInvoiceCompanyCode;
    }

    public String getSuzhouInvoiceSupplierCode() {
        return suzhouInvoiceSupplierCode;
    }

    public void setSuzhouInvoiceSupplierCode(String suzhouInvoiceSupplierCode) {
        this.suzhouInvoiceSupplierCode = suzhouInvoiceSupplierCode;
    }

    public String getSuzhouInvoiceOutputPId() {
        return suzhouInvoiceOutputPId;
    }

    public void setSuzhouInvoiceOutputPId(String suzhouInvoiceOutputPId) {
        this.suzhouInvoiceOutputPId = suzhouInvoiceOutputPId;
    }

    public String getRequestTypeOfDocDesc() {
        return requestTypeOfDocDesc;
    }

    public void setRequestTypeOfDocDesc(String requestTypeOfDocDesc) {
        this.requestTypeOfDocDesc = requestTypeOfDocDesc;
    }

    public String getSendDocAddress() {
        return sendDocAddress;
    }

    public void setSendDocAddress(String sendDocAddress) {
        this.sendDocAddress = sendDocAddress;
    }

    public Integer getPriceDiffPer() {
        return priceDiffPer;
    }

    public void setPriceDiffPer(Integer priceDiffPer) {
        this.priceDiffPer = priceDiffPer;
    }

    public String getUsPriceList() {
        return usPriceList;
    }

    public void setUsPriceList(String usPriceList) {
        this.usPriceList = usPriceList;
    }

    public Integer getHkPricePer() {
        return hkPricePer;
    }

    public void setHkPricePer(Integer hkPricePer) {
        this.hkPricePer = hkPricePer;
    }

    public String getIsPiPk() {
        return isPiPk;
    }

    public void setIsPiPk(String isPiPk) {
        this.isPiPk = isPiPk;
    }

    public String getRelWbpi() {
        return relWbpi;
    }

    public void setRelWbpi(String relWbpi) {
        this.relWbpi = relWbpi;
    }

    public String getENameOfIssuingBank() {
        return eNameOfIssuingBank;
    }

    public void setENameOfIssuingBank(String eNameOfIssuingBank) {
        this.eNameOfIssuingBank = eNameOfIssuingBank;
    }

    public String getEAddressOfIssuingBank() {
        return eAddressOfIssuingBank;
    }

    public void setEAddressOfIssuingBank(String eAddressOfIssuingBank) {
        this.eAddressOfIssuingBank = eAddressOfIssuingBank;
    }

    public String getCiticInsuranceCode() {
        return citicInsuranceCode;
    }

    public void setCiticInsuranceCode(String citicInsuranceCode) {
        this.citicInsuranceCode = citicInsuranceCode;
    }

    public String getIContractPayMethod() {
        return iContractPayMethod;
    }

    public void setIContractPayMethod(String iContractPayMethod) {
        this.iContractPayMethod = iContractPayMethod;
    }

    public Integer getDayLimit() {
        return dayLimit;
    }

    public void setDayLimit(Integer dayLimit) {
        this.dayLimit = dayLimit;
    }

    public String getIPaymentMethod() {
        return iPaymentMethod;
    }

    public void setIPaymentMethod(String iPaymentMethod) {
        this.iPaymentMethod = iPaymentMethod;
    }

    public Integer getBufferDays() {
        return bufferDays;
    }

    public void setBufferDays(Integer bufferDays) {
        this.bufferDays = bufferDays;
    }

    public String getChooseAllCustItemFlag() {
        return chooseAllCustItemFlag;
    }

    public void setChooseAllCustItemFlag(String chooseAllCustItemFlag) {
        this.chooseAllCustItemFlag = chooseAllCustItemFlag;
    }

    public Integer getDefaultDiscountRate() {
        return defaultDiscountRate;
    }

    public void setDefaultDiscountRate(Integer defaultDiscountRate) {
        this.defaultDiscountRate = defaultDiscountRate;
    }

    public String getForcePalletFlag() {
        return forcePalletFlag;
    }

    public void setForcePalletFlag(String forcePalletFlag) {
        this.forcePalletFlag = forcePalletFlag;
    }

    public Integer getDefaultDiscountRate2() {
        return defaultDiscountRate2;
    }

    public void setDefaultDiscountRate2(Integer defaultDiscountRate2) {
        this.defaultDiscountRate2 = defaultDiscountRate2;
    }

    public String getDefaultThirdPartSubinv() {
        return defaultThirdPartSubinv;
    }

    public void setDefaultThirdPartSubinv(String defaultThirdPartSubinv) {
        this.defaultThirdPartSubinv = defaultThirdPartSubinv;
    }

    public String getDefaultPalletNo() {
        return defaultPalletNo;
    }

    public void setDefaultPalletNo(String defaultPalletNo) {
        this.defaultPalletNo = defaultPalletNo;
    }

    public String getR90AutoFlag() {
        return r90AutoFlag;
    }

    public void setR90AutoFlag(String r90AutoFlag) {
        this.r90AutoFlag = r90AutoFlag;
    }

    public String getShipperVatNum() {
        return shipperVatNum;
    }

    public void setShipperVatNum(String shipperVatNum) {
        this.shipperVatNum = shipperVatNum;
    }

    public String getShipperVarType() {
        return shipperVarType;
    }

    public void setShipperVarType(String shipperVarType) {
        this.shipperVarType = shipperVarType;
    }

    public String getConsigneeVatNum() {
        return consigneeVatNum;
    }

    public void setConsigneeVatNum(String consigneeVatNum) {
        this.consigneeVatNum = consigneeVatNum;
    }

    public String getConsigneeVarType() {
        return consigneeVarType;
    }

    public void setConsigneeVarType(String consigneeVarType) {
        this.consigneeVarType = consigneeVarType;
    }

    public String getConsigneeAeoNum() {
        return consigneeAeoNum;
    }

    public void setConsigneeAeoNum(String consigneeAeoNum) {
        this.consigneeAeoNum = consigneeAeoNum;
    }

    public String getNotifierVatNum() {
        return notifierVatNum;
    }

    public void setNotifierVatNum(String notifierVatNum) {
        this.notifierVatNum = notifierVatNum;
    }

    public String getNotifierVarType() {
        return notifierVarType;
    }

    public void setNotifierVarType(String notifierVarType) {
        this.notifierVarType = notifierVarType;
    }

    @Override
    public String toString() {
        return "Cust{" +
                "id=" + id +
                ", custSiteAttId=" + custSiteAttId +
                ", orgId=" + orgId +
                ", custCode='" + custCode + '\'' +
                ", custName='" + custName + '\'' +
                ", custClass='" + custClass + '\'' +
                ", siteCode='" + siteCode + '\'' +
                ", siteAddress='" + siteAddress + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", province='" + province + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", creditCtrlMode='" + creditCtrlMode + '\'' +
                ", creditCtrlTime='" + creditCtrlTime + '\'' +
                ", deliveryMethod='" + deliveryMethod + '\'' +
                ", defaultOrderType='" + defaultOrderType + '\'' +
                ", defaultPriceList='" + defaultPriceList + '\'' +
                ", itemRelCustomer='" + itemRelCustomer + '\'' +
                ", isNeedOc='" + isNeedOc + '\'' +
                ", portOfLoading='" + portOfLoading + '\'' +
                ", portOfDischarge='" + portOfDischarge + '\'' +
                ", bolShipper='" + bolShipper + '\'' +
                ", bolConsignee='" + bolConsignee + '\'' +
                ", bolNotifyParty1='" + bolNotifyParty1 + '\'' +
                ", bolNotifyParty2='" + bolNotifyParty2 + '\'' +
                ", bolNotifyParty3='" + bolNotifyParty3 + '\'' +
                ", bolFrtPpyClt='" + bolFrtPpyClt + '\'' +
                ", bolDescription='" + bolDescription + '\'' +
                ", bolDoor='" + bolDoor + '\'' +
                ", bolMark='" + bolMark + '\'' +
                ", piShipper='" + piShipper + '\'' +
                ", ciShipper='" + ciShipper + '\'' +
                ", aciShipper='" + aciShipper + '\'' +
                ", piShipTo='" + piShipTo + '\'' +
                ", plShipTo='" + plShipTo + '\'' +
                ", piBillTo='" + piBillTo + '\'' +
                ", piSoldTo='" + piSoldTo + '\'' +
                ", custDescription='" + custDescription + '\'' +
                ", paymentTermPrice='" + paymentTermPrice + '\'' +
                ", custDecPriceTerms='" + custDecPriceTerms + '\'' +
                ", custItemCalUom='" + custItemCalUom + '\'' +
                ", custItemPriceUom='" + custItemPriceUom + '\'' +
                ", custItemPalletsUom='" + custItemPalletsUom + '\'' +
                ", piYhIsPalMerge='" + piYhIsPalMerge + '\'' +
                ", plNotallowPalMerge='" + plNotallowPalMerge + '\'' +
                ", piIsDisplayPaymentType='" + piIsDisplayPaymentType + '\'' +
                ", isPrintDetailWeight='" + isPrintDetailWeight + '\'' +
                ", plIsNeedAmount='" + plIsNeedAmount + '\'' +
                ", requestTypeOfDoc='" + requestTypeOfDoc + '\'' +
                ", docTransfWay='" + docTransfWay + '\'' +
                ", isNeedSendList='" + isNeedSendList + '\'' +
                ", docHead='" + docHead + '\'' +
                ", isBondedArea='" + isBondedArea + '\'' +
                ", limitWeightPerContainer=" + limitWeightPerContainer +
                ", limitPalPerContainer=" + limitPalPerContainer +
                ", limitLevelPerContainer=" + limitLevelPerContainer +
                ", boxIntMethod='" + boxIntMethod + '\'' +
                ", isNeedReport='" + isNeedReport + '\'' +
                ", reportMode='" + reportMode + '\'' +
                ", planIsNeedPl='" + planIsNeedPl + '\'' +
                ", settlementCurrency='" + settlementCurrency + '\'' +
                ", taxCode='" + taxCode + '\'' +
                ", termsOfPayment='" + termsOfPayment + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", clientBankAccount='" + clientBankAccount + '\'' +
                ", custBaddrAndPhoneNum='" + custBaddrAndPhoneNum + '\'' +
                ", isMergeInvoice='" + isMergeInvoice + '\'' +
                ", attribute1='" + attribute1 + '\'' +
                ", attribute2='" + attribute2 + '\'' +
                ", attribute3='" + attribute3 + '\'' +
                ", attribute4='" + attribute4 + '\'' +
                ", attribute5='" + attribute5 + '\'' +
                ", attribute6='" + attribute6 + '\'' +
                ", attribute7='" + attribute7 + '\'' +
                ", attribute8='" + attribute8 + '\'' +
                ", attribute9='" + attribute9 + '\'' +
                ", attribute10='" + attribute10 + '\'' +
                ", attribute11='" + attribute11 + '\'' +
                ", attribute12='" + attribute12 + '\'' +
                ", attribute13='" + attribute13 + '\'' +
                ", attribute14='" + attribute14 + '\'' +
                ", attribute15='" + attribute15 + '\'' +
                ", lastUpdateDate=" + lastUpdateDate +
                ", lastUpdatedBy=" + lastUpdatedBy +
                ", lastUpdateLogin=" + lastUpdateLogin +
                ", creationDate=" + creationDate +
                ", createdBy=" + createdBy +
                ", portOfDestination='" + portOfDestination + '\'' +
                ", creditCtrlModeCode='" + creditCtrlModeCode + '\'' +
                ", creditCtrlTimeCode='" + creditCtrlTimeCode + '\'' +
                ", custClassCode='" + custClassCode + '\'' +
                ", defaultOrderTypeId=" + defaultOrderTypeId +
                ", defaultPriceListId=" + defaultPriceListId +
                ", siteUseId=" + siteUseId +
                ", itemRelCustomerId=" + itemRelCustomerId +
                ", docHeaderId=" + docHeaderId +
                ", priceListId=" + priceListId +
                ", paymentTermId=" + paymentTermId +
                ", receiptMethodId=" + receiptMethodId +
                ", carrierId=" + carrierId +
                ", aciCiReceiver='" + aciCiReceiver + '\'' +
                ", aciCiBuyerName='" + aciCiBuyerName + '\'' +
                ", ciPlShipper='" + ciPlShipper + '\'' +
                ", isExportCompanyCode='" + isExportCompanyCode + '\'' +
                ", isExportVendorCode='" + isExportVendorCode + '\'' +
                ", vendorNo='" + vendorNo + '\'' +
                ", isExportShipsNameCode='" + isExportShipsNameCode + '\'' +
                ", isExportTaxId='" + isExportTaxId + '\'' +
                ", plOutputPoNo='" + plOutputPoNo + '\'' +
                ", isNeedExInvoicePl='" + isNeedExInvoicePl + '\'' +
                ", suzhouInvoiceBuyer='" + suzhouInvoiceBuyer + '\'' +
                ", suzhouInvoiceCompanyCode='" + suzhouInvoiceCompanyCode + '\'' +
                ", suzhouInvoiceSupplierCode='" + suzhouInvoiceSupplierCode + '\'' +
                ", suzhouInvoiceOutputPId='" + suzhouInvoiceOutputPId + '\'' +
                ", requestTypeOfDocDesc='" + requestTypeOfDocDesc + '\'' +
                ", sendDocAddress='" + sendDocAddress + '\'' +
                ", priceDiffPer=" + priceDiffPer +
                ", usPriceList='" + usPriceList + '\'' +
                ", hkPricePer=" + hkPricePer +
                ", isPiPk='" + isPiPk + '\'' +
                ", relWbpi='" + relWbpi + '\'' +
                ", eNameOfIssuingBank='" + eNameOfIssuingBank + '\'' +
                ", eAddressOfIssuingBank='" + eAddressOfIssuingBank + '\'' +
                ", citicInsuranceCode='" + citicInsuranceCode + '\'' +
                ", iContractPayMethod='" + iContractPayMethod + '\'' +
                ", dayLimit=" + dayLimit +
                ", iPaymentMethod='" + iPaymentMethod + '\'' +
                ", bufferDays=" + bufferDays +
                ", chooseAllCustItemFlag='" + chooseAllCustItemFlag + '\'' +
                ", defaultDiscountRate=" + defaultDiscountRate +
                ", forcePalletFlag='" + forcePalletFlag + '\'' +
                ", defaultDiscountRate2=" + defaultDiscountRate2 +
                ", defaultThirdPartSubinv='" + defaultThirdPartSubinv + '\'' +
                ", defaultPalletNo='" + defaultPalletNo + '\'' +
                ", r90AutoFlag='" + r90AutoFlag + '\'' +
                ", shipperVatNum='" + shipperVatNum + '\'' +
                ", shipperVarType='" + shipperVarType + '\'' +
                ", consigneeVatNum='" + consigneeVatNum + '\'' +
                ", consigneeVarType='" + consigneeVarType + '\'' +
                ", consigneeAeoNum='" + consigneeAeoNum + '\'' +
                ", notifierVatNum='" + notifierVatNum + '\'' +
                ", notifierVarType='" + notifierVarType + '\'' +
                '}';
    }
}

