package com.order_manage.service;

import com.order_manage.entity.OrderForm;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author weiqi
* @description 针对表【order_form】的数据库操作Service
* @createDate 2022-04-27 11:17:05
*/
public interface OrderFormService extends IService<OrderForm> {

    public List<OrderForm> selectByMainId(String mainId);

}
