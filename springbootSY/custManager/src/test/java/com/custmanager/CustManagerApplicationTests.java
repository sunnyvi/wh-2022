package com.custmanager;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.custmanager.dao.CustDao;
import com.custmanager.entity.Cust;
import com.custmanager.service.CustService;
import com.custmanager.service.impl.CustServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.Serializable;
import java.security.PrivateKey;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@SpringBootTest
class CustManagerApplicationTests {

    @Resource
    private  CustDao dao;
    @Test
    void contextLoads() {
        CustService s= new CustServiceImpl();
        QueryWrapper<Cust> q = new QueryWrapper<>();
        q.select("org_id");
        q.groupBy("org_id");

        List<Cust>test = dao.selectList(q);
        System.out.println();

    }

}
