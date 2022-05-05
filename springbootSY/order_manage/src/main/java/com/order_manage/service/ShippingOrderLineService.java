package com.order_manage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.order_manage.entity.ShippingOrderLine;

import java.util.List;

public interface ShippingOrderLineService extends IService<ShippingOrderLine> {

	public List<ShippingOrderLine> selectByMainId(String mainId);
}
