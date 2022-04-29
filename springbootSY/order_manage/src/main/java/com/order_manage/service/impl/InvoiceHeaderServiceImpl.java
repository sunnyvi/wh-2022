package com.order_manage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.order_manage.entity.InvoiceHeader;
import com.order_manage.mapper.InvoiceHeaderMapper;
import com.order_manage.mapper.InvoiceLineMapper;
import com.order_manage.service.IInvoiceHeaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Collection;

@Service
public class InvoiceHeaderServiceImpl extends ServiceImpl<InvoiceHeaderMapper, InvoiceHeader> implements IInvoiceHeaderService {

	@Resource
	private InvoiceHeaderMapper invoiceHeaderMapper;
	@Resource
	private InvoiceLineMapper invoiceLineMapper;
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void delMain(String id) {
		invoiceLineMapper.deleteByMainId(id);
		invoiceHeaderMapper.deleteById(id);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void delBatchMain(Collection<? extends Serializable> idList) {
		for(Serializable id:idList) {
			invoiceLineMapper.deleteByMainId(id.toString());
			invoiceHeaderMapper.deleteById(id);
		}
	}
	
}
