package com.order_manage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.order_manage.entity.InvoiceLines;

import java.util.List;

public interface IInvoiceLinesService extends IService<InvoiceLines> {

	public List<InvoiceLines> selectByMainId(String mainId);
}
