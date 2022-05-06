package com.order_manage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.order_manage.entity.InvoiceHeader;

import java.io.Serializable;
import java.util.Collection;

public interface IInvoiceHeaderService extends IService<InvoiceHeader> {

	/**
	 * 删除一对多
	 */
	public void delMain (String id);
	
	/**
	 * 批量删除一对多
	 */
	public void delBatchMain (Collection<? extends Serializable> idList);


}