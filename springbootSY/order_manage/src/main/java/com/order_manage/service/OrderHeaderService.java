package com.order_manage.service;

import com.order_manage.entity.OrderForm;
import com.order_manage.entity.OrderHeader;
import com.baomidou.mybatisplus.extension.service.IService;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
* @author weiqi
* @description 针对表【order_header】的数据库操作Service
* @createDate 2022-04-26 17:03:06
*/
public interface OrderHeaderService extends IService<OrderHeader> {

    /**
     * 添加一对多
     *
     */
    public void saveMain(OrderHeader orderHeader, List<OrderForm> orderFormList) ;

    /**
     * 修改一对多
     *
     */
    public void updateMain(OrderHeader orderHeader,List<OrderForm> orderFormList);

    /**
     * 删除一对多
     */
    public void delMain (String id);

    /**
     * 批量删除一对多
     */
    public void delBatchMain (Collection<? extends Serializable> idList);



}
