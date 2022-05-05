package com.order_manage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.order_manage.entity.ShippingOrderLine;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ShippingOrderLineMapper extends BaseMapper<ShippingOrderLine> {

	public boolean deleteByMainId(@Param("mainId") String mainId);
    
	public List<ShippingOrderLine> selectByMainId(@Param("mainId") String mainId);

}