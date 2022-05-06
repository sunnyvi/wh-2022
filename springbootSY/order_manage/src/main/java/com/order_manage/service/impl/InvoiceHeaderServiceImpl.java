package com.order_manage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.order_manage.entity.InvoiceHeader;
import com.order_manage.mapper.InvoiceHeaderMapper;
import com.order_manage.mapper.InvoiceLinesMapper;
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
	private InvoiceLinesMapper invoiceLinesMapper;
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void delMain(String id) {
		invoiceLinesMapper.deleteByMainId(id);
		invoiceHeaderMapper.deleteById(id);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void delBatchMain(Collection<? extends Serializable> idList) {
		for(Serializable id:idList) {
			invoiceLinesMapper.deleteByMainId(id.toString());
			invoiceHeaderMapper.deleteById(id);
		}
	}
	
}