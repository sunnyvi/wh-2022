package com.serviceapp.service.imp;

import com.alibaba.fastjson.JSONObject;
import com.serviceapp.entity.Cust;
import com.serviceapp.myutils.RestRequest;
import com.serviceapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class CustomerServiceImp implements CustomerService {

    @Value("${restful.address.customers}")
    String data_ip;
    @Value("${restful.resource.customers}")
    String data_resource;

    @Override
    public List<Cust> selectByCol(Cust custTemp) {

        return null;
    }

    @Override
    public List<Cust> selectByPage(Cust cust) {
        StringBuffer url = new StringBuffer(this.data_ip + this.data_resource + "?opIdentifier=" + System.currentTimeMillis());
        if (cust.getId() != null && !cust.getId().equals(""))
            url.append("&id=" + cust.getId());
        if (cust.getCustCode() != null && !cust.getCustCode().equals(""))
            url.append("&custCode=" + cust.getCustCode());
        if (cust.getOrgId() != null && !cust.getOrgId().equals(""))
            url.append("&orgId=" + cust.getOrgId());
        if (cust.getSiteCode() != null && !cust.getSiteCode().equals(""))
            url.append("&siteCode=" + cust.getSiteCode());
        String res = RestRequest.restfulGetUtils(url.toString());
        return JSONObject.parseArray(JSONObject.parseObject(res).get("data").toString(), Cust.class);
    }

    @Override
    public int addCustomerByPage(Cust cust) {
        String url = this.data_ip + this.data_resource;
        JSONObject json = JSONObject.parseObject(JSONObject.toJSONString(cust));
        String res = RestRequest.restfulPostUtils(url, json);
        return 0;
    }

    @Override
    public int updateCustomerByPage(Cust cust) {
        String url = this.data_ip + this.data_resource;
        JSONObject json = JSONObject.parseObject(JSONObject.toJSONString(cust));
        String res = RestRequest.restfulPutUtils(url, json);
        return 0;
    }

    @Override
    public int deleteCustomerByPage(Cust cust) {
        if (cust.getId() != null && !cust.getId().equals("")) {
            String url = this.data_ip + this.data_resource + "?id=" + cust.getId();
            //     JSONObject json = JSONObject.parseObject(JSONObject.toJSONString(cust));
            String res = RestRequest.restfulDeleteUtils(url);
        }
        return 0;
    }
}
