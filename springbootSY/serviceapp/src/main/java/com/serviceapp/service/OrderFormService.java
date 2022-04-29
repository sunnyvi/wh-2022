package com.serviceapp.service;

import com.serviceapp.entity.OrderForm;
import com.serviceapp.myutils.RestResult;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;

import java.util.List;

public interface OrderFormService {
    RestResult<String> importExcelToDataBase(Workbook workbook) throws Exception;

    RestResult<List<OrderForm>> selectByPage(OrderForm order,String custCode);
}
