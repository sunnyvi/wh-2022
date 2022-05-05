package com.order_manage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.order_manage.entity.ShippingOrderLine;
import com.order_manage.mapper.ShippingOrderLineMapper;
import com.order_manage.service.ShippingOrderLineService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ShippingOrderLineServiceImpl extends ServiceImpl<ShippingOrderLineMapper, ShippingOrderLine> implements ShippingOrderLineService {
	
	@Resource
	private ShippingOrderLineMapper invoiceLineMapper;
	
	@Override
	public List<ShippingOrderLine> selectByMainId(String mainId) {
		return invoiceLineMapper.selectByMainId(mainId);
	}
}