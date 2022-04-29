package com.order_manage.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.order_manage.entity.OrderForm;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (OrderForm)表数据库访问层
 *
 * @author makejava
 * @since 2022-03-28 14:18:27
 */
@Mapper
@Repository
public interface OrderFormDao extends BaseMapper<OrderForm> {


}

