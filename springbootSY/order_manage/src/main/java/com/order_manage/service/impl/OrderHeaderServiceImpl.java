package com.order_manage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.order_manage.entity.OrderForm;
import com.order_manage.entity.OrderHeader;
import com.order_manage.mapper.OrderFormMapper;
import com.order_manage.service.OrderHeaderService;
import com.order_manage.mapper.OrderHeaderMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
* @author weiqi
* @description 针对表【order_header】的数据库操作Service实现
* @createDate 2022-04-26 17:03:06
*/
@Service

public class OrderHeaderServiceImpl extends ServiceImpl<OrderHeaderMapper, OrderHeader>
    implements OrderHeaderService{

    @Resource
    private OrderHeaderMapper orderHeaderMapper;
    @Resource
    private OrderFormMapper orderFormMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveMain(OrderHeader orderHeader, List<OrderForm> orderFormList) {
        orderHeaderMapper.insert(orderHeader);
        if(orderFormList!=null && orderFormList.size()>0) {
            for(OrderForm entity:orderFormList) {
                //外键设置
                entity.setHeaderId(orderHeader.getId());
                orderFormMapper.insert(entity);
            }
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateMain(OrderHeader orderHeader,List<OrderForm> orderFormList) {
        orderHeaderMapper.updateById(orderHeader);

        //1.先删除子表数据
        orderFormMapper.deleteByMainId(String.valueOf(orderHeader.getId()));

        //2.子表数据重新插入
        if(orderFormList!=null && orderFormList.size()>0) {
            for(OrderForm entity:orderFormList) {
                //外键设置
                entity.setHeaderId(orderHeader.getId());
                orderFormMapper.insert(entity);
            }
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delMain(String id) {
        orderFormMapper.deleteByMainId(id);
        orderHeaderMapper.deleteById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delBatchMain(Collection<? extends Serializable> idList) {
        for(Serializable id:idList) {
            orderFormMapper.deleteByMainId(id.toString());
            orderHeaderMapper.deleteById(id);
        }
    }

    public List<OrderHeader> findall(int id) {
        return orderHeaderMapper.selectById(id);
    }


}




