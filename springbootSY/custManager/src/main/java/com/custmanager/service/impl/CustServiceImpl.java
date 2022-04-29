package com.custmanager.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.custmanager.entity.Cust;
import com.custmanager.dao.CustDao;
import com.custmanager.service.CustService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.IntStream;

/**
 * (Cust)表服务实现类
 *
 * @author makejava
 * @since 2022-03-20 12:04:18
 */
@Service("custService")
public class CustServiceImpl implements CustService {
    @Autowired
    private CustDao custDao;


    @Override
    public int insertCustomer(Cust customer) {
        customer.setLastUpdateDate(new Date());
        customer.setLastUpdatedBy(999);
        customer.setCreationDate(new Date());
        customer.setCreatedBy(888);
        return custDao.insert(customer);
    }

    @Override
    public int delectCustomer(int id) {
        return custDao.deleteById(id);
    }

    @Override
    public int delectCustomerByCustCode(Cust customer) {
        HashMap<String,Object> map = new HashMap<>();
        map.put("cust_code",customer.getCustCode());
        map.put("site_code",customer.getSiteCode());
        return custDao.deleteByMap(map);

    }

    @Override
    public int updateCustomer(Cust customer) {
        customer.setLastUpdateDate(new Date());
        customer.setLastUpdatedBy(999);
        return custDao.updateById(customer);
    }

    @Override
    public int updateCustomerByCustCode(Cust customer) {
        UpdateWrapper<Cust> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("cust_code", customer.getCustCode());
        updateWrapper.eq("site_code", customer.getSiteCode());

        return custDao.update(customer,updateWrapper);
    }

    @Override
    public Cust selectById(int id) {
        return custDao.selectById(id);
    }



    @Override
    public List<Cust> selectByCol(Cust customer) {
        QueryWrapper<Cust> queryWrapper = new QueryWrapper<>(customer);
        return custDao.selectList(queryWrapper);
    }
    //根据custCode和siteCode判断是否存在该客户
    @Override
    public boolean isContainCustomer(String custCode,String siteCode){
        QueryWrapper<Cust> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("cust_code", custCode);
        queryWrapper.eq("site_code", siteCode);
        return custDao.selectList(queryWrapper).size()>0;
    }

    @Override
    public Set getAllCustCodeSet() {
        Set res = new HashSet<>();
        QueryWrapper<Cust> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("cust_code");
        queryWrapper.groupBy("cust_code");
        List<Cust> custCodes = custDao.selectList(queryWrapper);
        IntStream.range(0,custCodes.size()).forEach(i->{
            res.add(custCodes.get(i).getCustCode().trim());
        });
        return res;
    }
}
