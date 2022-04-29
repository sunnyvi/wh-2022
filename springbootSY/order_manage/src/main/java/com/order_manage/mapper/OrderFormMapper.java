package com.order_manage.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.order_manage.entity.OrderForm;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Description: order_form
 * @Author: jeecg-boot
 * @Date:   2022-04-26
 * @Version: V1.0
 */
@Mapper
public interface OrderFormMapper extends BaseMapper<OrderForm> {

	public boolean deleteByMainId(@Param("mainId") String mainId);
    
	public List<OrderForm> selectByMainId(@Param("mainId") String mainId);
}
