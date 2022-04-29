package com.serviceapp.controller;

import com.serviceapp.entity.Cust;
import com.serviceapp.myutils.RestResponse;
import com.serviceapp.myutils.RestResult;
import com.serviceapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("customers")
public class CustomerController {

    @Resource
    CustomerService customerService;

    @GetMapping
    //前端页面查询
    public RestResult<List<Cust>> findCustomerByPage(Cust cust) {
       /* if(MyMethord.objectFieldIsEmpty(custTemp)==0) {
            return RestResponse.makeErrRsp("查询用户条件不足");
        }*/
        try {
            return RestResponse.makeOKRsp(customerService.selectByPage(cust));
        }catch (Exception e) {
            e.printStackTrace();
            return RestResponse.makeErrRsp("查询客户信息异常");
        }
    }

    @PostMapping
    public RestResult<String> addCustomerByPage(@RequestBody Cust cust){
        try {
            customerService.addCustomerByPage(cust);
            return RestResponse.makeOKRsp("新增成功");
        }catch (Exception e) {
            e.printStackTrace();
            return RestResponse.makeErrRsp("查询客户信息异常");
        }
    }

    @PutMapping
    public RestResult<String> updateCustomerByPage(@RequestBody Cust cust){
        try {
            customerService.updateCustomerByPage(cust);
            return RestResponse.makeOKRsp("修改成功");
        }catch (Exception e) {
            e.printStackTrace();
            return RestResponse.makeErrRsp("修改客户信息异常");
        }
    }

    @DeleteMapping
    public RestResult<String> deleteCustomerByPage(Cust cust){
        try {
            customerService.deleteCustomerByPage(cust);
            return RestResponse.makeOKRsp("删除成功");
        }catch (Exception e) {
            e.printStackTrace();
            return RestResponse.makeErrRsp("删除客户信息异常");
        }
    }




}
