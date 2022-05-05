package com.order_manage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.order_manage.entity.ShippingOrderHeader;
import com.order_manage.mapper.ShippingOrderHeaderMapper;
import com.order_manage.mapper.ShippingOrderLineMapper;
import com.order_manage.service.ShippingOrderHeaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Collection;

@Service
public class ShippingOrderHeaderServiceImpl extends ServiceImpl<ShippingOrderHeaderMapper, ShippingOrderHeader> implements ShippingOrderHeaderService {

	@Resource
	private ShippingOrderHeaderMapper shippingOrderHeaderMapper;
	@Resource
	private ShippingOrderLineMapper shippingOrderLineMapper;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void delMain(String id) {
		shippingOrderLineMapper.deleteByMainId(id);
		shippingOrderHeaderMapper.deleteById(id);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void delBatchMain(Collection<? extends Serializable> idList) {
		for(Serializable id:idList) {
			shippingOrderLineMapper.deleteByMainId(id.toString());
			shippingOrderHeaderMapper.deleteById(id);
		}
	}

}