package com.order_manage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.order_manage.entity.InvoiceLines;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InvoiceLinesMapper extends BaseMapper<InvoiceLines> {

	public boolean deleteByMainId(@Param("mainId") String mainId);
    
	public List<InvoiceLines> selectByMainId(@Param("mainId") String mainId);

}