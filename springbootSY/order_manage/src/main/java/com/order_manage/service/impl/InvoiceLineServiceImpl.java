package com.order_manage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.order_manage.entity.InvoiceLine;
import com.order_manage.mapper.InvoiceLineMapper;
import com.order_manage.service.IInvoiceLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class InvoiceLineServiceImpl extends ServiceImpl<InvoiceLineMapper, InvoiceLine> implements IInvoiceLineService {
	
	@Resource
	private InvoiceLineMapper invoiceLineMapper;
	
	@Override
	public List<InvoiceLine> selectByMainId(String mainId) {
		return invoiceLineMapper.selectByMainId(mainId);
	}
}