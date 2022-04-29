package com.custmanager.controller;

import com.custmanager.myutils.MyMethord;
import com.custmanager.myutils.RestResponse;
import com.custmanager.myutils.RestResult;
import com.custmanager.entity.Cust;
import com.custmanager.service.CustService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * (Cust)表控制层
 *
 * @author makejava
 * @since 2022-03-20 12:04:18
 */
@RestController
@Api(tags="用户管理类")
public class CustController {

    @Autowired
    CustService custService;

    @ApiOperation("根据多个条件查询用户，方便页面查询")
    @PostMapping(value ={"/customers/list"})
    public RestResult<List<Cust>> selectCustomerByCol(@RequestBody Cust custTemp) {
      /*  if(MyMethord.objectFieldIsEmpty(custTemp)==0){
            return RestResponse.makeErrRsp("查询用户条件不足");
        }*/
        try {
            List<Cust> customers = custService.selectByCol(custTemp);
            return RestResponse.makeOKRsp(customers);
        } catch (Exception e) {
            e.printStackTrace();
            return RestResponse.makeErrRsp("查询用户信息异常");
        }
    }

    @ApiOperation("查询用户，方便接口调用")
    @GetMapping(value = "/customers")
    public RestResult<List<Cust>> findCustomerByCol(Cust custTemp) {
       /* if(MyMethord.objectFieldIsEmpty(custTemp)==0) {
            return RestResponse.makeErrRsp("查询用户条件不足");
        }*/
        try {
            return RestResponse.makeOKRsp(custService.selectByCol(custTemp));
        }catch (Exception e) {
            e.printStackTrace();
            return RestResponse.makeErrRsp("查询用户信息异常");
        }
    }

    //增
    @ApiOperation("新增用户")
    @PostMapping(value = "/customers")
    public RestResult<Cust> insertCustomer(@RequestBody Cust customer){
        // 判空
        if(customer.getCustCode() == null || customer.getCustCode().equals("")) return RestResponse.makeErrRsp("custCode不能为空");
        if(customer.getSiteCode() == null || customer.getSiteCode().equals("")) return RestResponse.makeErrRsp("siteCode不能为空");
        if(custService.isContainCustomer(customer.getCustCode(),customer.getSiteCode())){
            return RestResponse.makeErrRsp("该客户及分支已经存在");
        }
       try {
           custService.insertCustomer(customer);
           return RestResponse.makeOKRsp("插入成功");
       }catch (Exception e){
           e.printStackTrace();
           return RestResponse.makeErrRsp("插入用户信息异常");
       }

    }

    //改
    //TODO  不能修改成存在的custCode+siteCode的数据（校验）
    @ApiOperation("修改用户")
    @PutMapping(value = "/customers")
    public RestResult<Cust> updateCustomer(@RequestBody Cust customer) {


        //id不为空，那就用id更新（页面）
        if (customer.getId() != null) {
            try {
                custService.updateCustomer(customer);
                return RestResponse.makeOKRsp("更新成功");
            } catch (Exception e) {
                e.printStackTrace();
                return RestResponse.makeErrRsp("更新用户信息异常");
            }
        }
        //id为空，使用custCode和siteCode进行更新（接口）
        else {
            if (customer.getCustCode() == null || customer.getCustCode().equals(""))
                return RestResponse.makeErrRsp("custCode不能为空");
            if (customer.getSiteCode() == null || customer.getSiteCode().equals(""))
                return RestResponse.makeErrRsp("siteCode不能为空");
            try {
                custService.updateCustomerByCustCode(customer);
                return RestResponse.makeOKRsp("更新成功");
            } catch (Exception e) {
                e.printStackTrace();
                return RestResponse.makeErrRsp("更新用户信息异常");
            }
        }
    }
    //删
    @ApiOperation("删除用户")
    @DeleteMapping(value="/customers")
    public RestResult<Cust> deleteCustomer(Cust custTemp){
        try{
            //页面通过id进行删除
            if(custTemp.getId()!=null){
                custService.delectCustomer(custTemp.getId());
            }else{
                //接口通过custCode和siteCode删除
                custService.delectCustomerByCustCode(custTemp);
            }

        return RestResponse.makeOKRsp("删除成功");}
        catch (Exception e){
            e.printStackTrace();
            return RestResponse.makeErrRsp("删除用户信息异常");
        }
    }

    @GetMapping(value = "/customers/custCodes")
    public RestResult<Set> selectAllCustCode(){
        Set res = custService.getAllCustCodeSet();
      return  RestResponse.makeOKRsp(res);
    }
}

