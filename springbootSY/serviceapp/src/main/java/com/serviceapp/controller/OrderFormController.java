package com.serviceapp.controller;

import com.serviceapp.entity.OrderForm;
import com.serviceapp.myutils.RestResponse;
import com.serviceapp.myutils.RestResult;
import com.serviceapp.service.OrderFormService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("orders")
public class OrderFormController {
    @Resource
    OrderFormService orderFormService;


    //excel导入数据
    @PostMapping
    public RestResult<String> importExcel(MultipartFile file) {
        try {
            String fileName = file.getOriginalFilename();
            //判断文件格式并获取工作簿
            Workbook workbook;
            if (fileName.endsWith("xls")) {
                workbook = new HSSFWorkbook(file.getInputStream());
            } else if (fileName.endsWith("xlsx")) {
                workbook = new XSSFWorkbook(file.getInputStream());
            } else {
                return RestResponse.makeErrRsp("文件格式不是xls或xlsx");
            }
            return orderFormService.importExcelToDataBase(workbook);
        } catch (Exception e) {
           e.printStackTrace();
            return RestResponse.makeErrRsp("导入信息异常");
        }
    }

    @GetMapping
    public RestResult<List<OrderForm>> findOrderByPage(OrderForm order,@RequestParam("custCode") String custCode){
        try {
            return orderFormService.selectByPage(order,custCode);
        }catch (Exception e) {
            e.printStackTrace();
            return RestResponse.makeErrRsp("查询订单信息异常");
        }
    }
}
