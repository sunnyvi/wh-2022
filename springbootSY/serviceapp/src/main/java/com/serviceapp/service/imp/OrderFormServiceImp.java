package com.serviceapp.service.imp;

import com.alibaba.fastjson.JSONObject;
import com.serviceapp.entity.Cust;
import com.serviceapp.entity.OrderForm;
import com.serviceapp.entity.OrderFormTemp;
import com.serviceapp.myutils.RestRequest;
import com.serviceapp.myutils.RestResponse;
import com.serviceapp.myutils.RestResult;
import com.serviceapp.service.OrderFormService;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderFormServiceImp implements OrderFormService {
    @Value("${restful.address.orders}")
    String data_ip;
    @Value("${restful.resource.orders}")
    String data_resource;

    @Override
    public RestResult<String> importExcelToDataBase(Workbook workbook) {

        //导入批次标识（时间戳）
        String opIdentifier = String.valueOf(System.currentTimeMillis());
        //存储excel里的订单数据
        List<OrderFormTemp> dataFromExcel = new ArrayList<>();
        //临时变量
        Cell xCell;
        //判断第一页不为空
        if (null != workbook.getSheetAt(0)) {
            //读取excl第三行，从2开始
            for (int rowNumofSheet = 2; rowNumofSheet <= workbook.getSheetAt(0).getLastRowNum(); rowNumofSheet++) {
                if (null != workbook.getSheetAt(0).getRow(rowNumofSheet)) {

                    //定义行，并赋值
                    Row aRow = workbook.getSheetAt(0).getRow(rowNumofSheet);
                    /* if (aRow.getLastCellNum() < 19) return RestResponse.makeErrRsp("excel列数不足");*/

                    if (aRow.getCell(0) == null || aRow.getCell(0).toString().equals("")||aRow.getCell(1) == null || aRow.getCell(1).toString().equals("")) {
                        break;
                    }
                    OrderFormTemp order = new OrderFormTemp();

                    //定单编号
                    xCell = aRow.getCell(0);
                    if (xCell != null) xCell.setCellType(CellType.STRING);
                    order.setOrderNumS(xCell == null ? null : xCell.toString());
                    //订单号
                    xCell = aRow.getCell(1);
                    if (xCell != null) xCell.setCellType(CellType.STRING);
                    order.setOrderNo(xCell == null ? null : xCell.toString());
                    //客户号
                    xCell = aRow.getCell(2);
                    if (xCell != null) xCell.setCellType(CellType.STRING);
                    order.setCustNo(xCell == null ? null : xCell.toString());
                    //鲁达号
                    xCell = aRow.getCell(3);
                    if (xCell != null) xCell.setCellType(CellType.STRING);
                    order.setLudaCode(xCell == null ? null : xCell.toString());
                    //胜地号
                    xCell = aRow.getCell(4);
                    if (xCell != null) xCell.setCellType(CellType.STRING);
                    order.setSdCode(xCell == null ? null : xCell.toString());
                    //定单数量
                    xCell = aRow.getCell(5);
                    if (xCell != null) xCell.setCellType(CellType.STRING);
                    order.setOrderQuantity(xCell == null ? null : Integer.parseInt(xCell.getStringCellValue()));
                    //配方
                    xCell = aRow.getCell(6);
                    if (xCell != null) xCell.setCellType(CellType.STRING);
                    order.setFormula(xCell == null ? null : xCell.toString());
                    //盒类
                    xCell = aRow.getCell(7);
                    if (xCell != null) xCell.setCellType(CellType.STRING);
                    order.setBoxClass(xCell == null ? null : xCell.toString());
                    //备注1
                    xCell = aRow.getCell(8);
                    if (xCell != null) xCell.setCellType(CellType.STRING);
                    order.setRemarks(xCell == null ? null : xCell.toString());
                    //交货期
                    xCell = aRow.getCell(9);
                    if (xCell != null) xCell.setCellType(CellType.STRING);
                    order.setDeliveryDate(xCell == null ? null : HSSFDateUtil.getJavaDate(Double.parseDouble(xCell.getStringCellValue().toString())));
                    //EMARK NO.
                    xCell = aRow.getCell(10);
                    if (xCell != null) xCell.setCellType(CellType.STRING);
                    order.setEmarkNo(xCell == null ? null : xCell.toString());
                    //WVA NO.
                    xCell = aRow.getCell(11);
                    if (xCell != null) xCell.setCellType(CellType.STRING);
                    order.setWvaNo(xCell == null ? null : xCell.toString());
                    //OE NO.
                    xCell = aRow.getCell(12);
                    if (xCell != null) xCell.setCellType(CellType.STRING);
                    order.setOeNo(xCell == null ? null : xCell.toString());
                    //F/R
                    xCell = aRow.getCell(13);
                    if (xCell != null) xCell.setCellType(CellType.STRING);
                    order.setFrNo(xCell == null ? null : xCell.toString());
                    //彩盒条形码BAR CODE
                    xCell = aRow.getCell(14);
                    if (xCell != null) xCell.setCellType(CellType.STRING);
                    order.setBarCodeColorbox(xCell == null ? null : xCell.toString());
                    //外箱条形码BAR CODE
                    xCell = aRow.getCell(15);
                    if (xCell != null) xCell.setCellType(CellType.STRING);
                    order.setBarCodeOuterbox(xCell == null ? null : xCell.toString());
                    //车型
                    xCell = aRow.getCell(16);
                    if (xCell != null) xCell.setCellType(CellType.STRING);
                    order.setModel(xCell == null ? null : xCell.toString());
                    //钢背喷码
                    xCell = aRow.getCell(17);
                    if (xCell != null) xCell.setCellType(CellType.STRING);
                    order.setBackMark(xCell == null ? null : xCell.toString());
                    //EMARK证书上的鲁达号
                    xCell = aRow.getCell(18);
                    if (xCell != null) xCell.setCellType(CellType.STRING);
                    order.setLudaCodeEmark(xCell == null ? null : xCell.toString());
                    //EMARK证书上的配方号
                    xCell = aRow.getCell(19);
                    if (xCell != null) xCell.setCellType(CellType.STRING);
                    order.setFormulaEmark(xCell == null ? null : xCell.toString());

                    //批次标识
                    order.setOpIdentifier(opIdentifier);
                    dataFromExcel.add(order);
                }
            }
            return postExcelDataByPost(dataFromExcel);

        } else {
            return RestResponse.makeErrRsp("excel第一页数据为空");
        }

    }

    @Override
    public RestResult<List<OrderForm>> selectByPage(OrderForm order,String custCode) {
        StringBuffer url = new StringBuffer(this.data_ip + this.data_resource.substring(0,this.data_resource.length()-1) + "?custCode=" + custCode);
        if (order.getOrderNumS() != null && !order.getOrderNumS().equals(""))
            url.append("&orderNumS=" + order.getOrderNumS());

        String res = RestRequest.restfulGetUtils(url.toString());
        return RestResponse.makeOKRsp(JSONObject.parseArray(JSONObject.parseObject(res).get("data").toString(), OrderForm.class));
    }

    public RestResult<String> postExcelDataByPost(List<OrderFormTemp> dataFromExcel) {
        String url = this.data_ip + this.data_resource;
        //   JSONObject json = JSONObject.parseObject(JSONObject.toJSONString(dataFromExcel));
        String json = JSONObject.toJSONString(dataFromExcel);
        String res = RestRequest.restfulPostUtils(url, json);

        return RestResponse.makeOKRsp("导入成功");
    }

}
