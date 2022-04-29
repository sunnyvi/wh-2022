package com.order_manage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.order_manage.entity.InvoiceLine;

import java.util.List;

public interface IInvoiceLineService extends IService<InvoiceLine> {

	public List<InvoiceLine> selectByMainId(String mainId);
}
