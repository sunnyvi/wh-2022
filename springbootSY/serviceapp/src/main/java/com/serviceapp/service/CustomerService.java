package com.serviceapp.service;

import com.serviceapp.entity.Cust;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CustomerService {
    List<Cust> selectByCol(Cust custTemp);

    List<Cust> selectByPage(Cust custTemp);

    int addCustomerByPage(Cust cust);

    int updateCustomerByPage(Cust cust);

    int deleteCustomerByPage(Cust cust);
}
