package com.order_manage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.order_manage.entity.InvoiceLine;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface InvoiceLineMapper extends BaseMapper<InvoiceLine> {

	public boolean deleteByMainId(@Param("mainId") String mainId);
    
	public List<InvoiceLine> selectByMainId(@Param("mainId") String mainId);

}