package com.custmanager.service;

import com.custmanager.entity.Cust;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Set;

/**
 * (Cust)表服务接口
 *
 * @author makejava
 * @since 2022-03-20 12:04:18
 */
public interface CustService {

    //增加
    int insertCustomer(Cust customer);

    //删除(id，页面删除)
    int delectCustomer(int id);

    //删除（通过客户号和分支号，接口调用删除）
    int delectCustomerByCustCode(Cust customer);


    //修改
    int updateCustomer(Cust customer);

    //
    int updateCustomerByCustCode(Cust customer);
    //查询

    //id
    Cust selectById(int id);

    //条件查询
    List<Cust> selectByCol(Cust customer);

    //根据客户号和分支号查询是否存在该用户
    public boolean isContainCustomer(String custCode,String siteCode);

    //获取所有客户号的set集合
    Set getAllCustCodeSet();
}
