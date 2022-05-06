package com.order_manage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.order_manage.entity.InvoiceLines;
import com.order_manage.mapper.InvoiceLinesMapper;
import com.order_manage.service.IInvoiceLinesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class InvoiceLinesServiceImpl extends ServiceImpl<InvoiceLinesMapper, InvoiceLines> implements IInvoiceLinesService {
	
	@Resource
	private InvoiceLinesMapper invoiceLinesMapper;
	
	@Override
	public List<InvoiceLines> selectByMainId(String mainId) {
		return invoiceLinesMapper.selectByMainId(mainId);
	}
}
