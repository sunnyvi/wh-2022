package com.order_manage.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.order_manage.entity.OrderForm;
import com.order_manage.entity.OrderFormTemp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (OrderFormTemp)表数据库访问层
 *
 * @author makejava
 * @since 2022-03-30 14:56:25
 */
@Mapper
@Repository
public interface OrderFormTempDao extends BaseMapper<OrderFormTemp> {



}

