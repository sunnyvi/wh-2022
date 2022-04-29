package com.order_manage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.order_manage.entity.OrderForm;
import com.order_manage.service.OrderFormService;
import com.order_manage.mapper.OrderFormMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @author weiqi
* @description 针对表【order_form】的数据库操作Service实现
* @createDate 2022-04-27 11:17:05
*/
@Service
public class OrderFormServiceImpl extends ServiceImpl<OrderFormMapper, OrderForm>
    implements OrderFormService{

    @Resource
    private OrderFormMapper orderFormMapper;

    @Override
    public List<OrderForm> selectByMainId(String mainId) {
        return orderFormMapper.selectByMainId(mainId);
    }

}




