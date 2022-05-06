package com.order_manage.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.order_manage.entity.OrderForm;
import com.order_manage.entity.OrderHeader;
import com.order_manage.myutils.QueryGenerator;
import com.order_manage.myutils.Result;
import com.order_manage.service.OrderFormService;
import com.order_manage.service.OrderHeaderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.def.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.view.JeecgEntityExcelView;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Api(tags="order_header")
@RestController
@RequestMapping("/orderHeader")
@Slf4j

public class OrderHeaderController {
	@Autowired
	private OrderHeaderService orderHeaderService;
	@Autowired
	private OrderFormService orderFormService;

	/**
	 * 分页列表查询
	 * @param orderHeader
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "order_header-分页列表查询")
	@ApiOperation(value="order_header-分页列表查询", notes="order_header-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<OrderHeader>> queryPageList(OrderHeader orderHeader,
													@RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
													@RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
													HttpServletRequest req) {
		QueryWrapper<OrderHeader> queryWrapper = QueryGenerator.initQueryWrapper(orderHeader, req.getParameterMap());
		Page<OrderHeader> page = new Page<OrderHeader>(pageNo, pageSize);
		IPage<OrderHeader> pageList = orderHeaderService.page(page, queryWrapper);
		return Result.OK(pageList);
	}

	/**
	 *   添加
	 * @param orderHeader
	 * @return
	 */
	// @AutoLog(value = "order_header-添加")
	@ApiOperation(value="order_header-添加", notes="order_header-添加")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody OrderHeader orderHeader) {
		orderHeaderService.save(orderHeader);
		return Result.OK("添加成功！");
	}

	/**
	 *  编辑
	 * @param orderHeader
	 * @return
	 */
	// @AutoLog(value = "order_header-编辑")
	@ApiOperation(value="order_header-编辑", notes="order_header-编辑")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody OrderHeader orderHeader) {
		orderHeaderService.updateById(orderHeader);
		return Result.OK("编辑成功!");
	}

	/**
	 * 通过id删除
	 * @param id
	 * @return
	 */
	// @AutoLog(value = "order_header-通过id删除")
	@ApiOperation(value="order_header-通过id删除", notes="order_header-通过id删除")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		orderHeaderService.delMain(id);
		return Result.OK("删除成功!");
	}

	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	// @AutoLog(value = "order_header-批量删除")
	@ApiOperation(value="order_header-批量删除", notes="order_header-批量删除")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.orderHeaderService.delBatchMain(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}



	/*--------------------------------子表处理-order_form-begin----------------------------------------------*/
	/**
	 * 通过主表ID查询
	 * @return
	 */
	//@AutoLog(value = "order_form-通过主表ID查询")
	@ApiOperation(value="order_form-通过主表ID查询", notes="order_form-通过主表ID查询")
	@GetMapping(value = "/listOrderFormByMainId")
	public Result<IPage<OrderForm>> listOrderFormByMainId(OrderForm orderForm,
														  @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
														  @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
														  HttpServletRequest req) {
		QueryWrapper<OrderForm> queryWrapper = QueryGenerator.initQueryWrapper(orderForm, req.getParameterMap());
		Page<OrderForm> page = new Page<OrderForm>(pageNo, pageSize);
		IPage<OrderForm> pageList = orderFormService.page(page, queryWrapper);
		return Result.OK(pageList);
	}

	/**
	 * 添加
	 * @param orderForm
	 * @return
	 */
	// @AutoLog(value = "order_form-添加")
	@ApiOperation(value="order_form-添加", notes="order_form-添加")
	@PostMapping(value = "/addOrderForm")
	public Result<String> addOrderForm(@RequestBody OrderForm orderForm) {
		orderFormService.save(orderForm);
		return Result.OK("添加成功！");
	}

	/**
	 * 编辑
	 * @param orderForm
	 * @return
	 */
	// @AutoLog(value = "order_form-编辑")
	@ApiOperation(value="order_form-编辑", notes="order_form-编辑")
	@RequestMapping(value = "/editOrderForm", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> editOrderForm(@RequestBody OrderForm orderForm) {
		orderFormService.updateById(orderForm);
		return Result.OK("编辑成功!");
	}

	/**
	 * 通过id删除
	 * @param id
	 * @return
	 */
	// @AutoLog(value = "order_form-通过id删除")
	@ApiOperation(value="order_form-通过id删除", notes="order_form-通过id删除")
	@DeleteMapping(value = "/deleteOrderForm")
	public Result<String> deleteOrderForm(@RequestParam(name="id",required=true) String id) {
		orderFormService.removeById(id);
		return Result.OK("删除成功!");
	}

	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	// @AutoLog(value = "order_form-批量删除")
	@ApiOperation(value="order_form-批量删除", notes="order_form-批量删除")
	@DeleteMapping(value = "/deleteBatchOrderForm")
	public Result<String> deleteBatchOrderForm(@RequestParam(name="ids",required=true) String ids) {
		this.orderFormService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}



	/**
	 * 导入
	 * @return
	 */
	@RequestMapping(value = "/importOrderForm/{mainId}")
	public Result<?> importOrderForm(HttpServletRequest request, HttpServletResponse response, @PathVariable("mainId") String mainId) {
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
		for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
			MultipartFile file = entity.getValue();// 获取上传文件对象
			ImportParams params = new ImportParams();
			params.setTitleRows(2);
			params.setHeadRows(1);
			params.setNeedSave(true);
			try {
				List<OrderForm> list = ExcelImportUtil.importExcel(file.getInputStream(), OrderForm.class, params);
				for (OrderForm temp : list) {
					temp.setHeaderId(Integer.valueOf(mainId));
				}
				long start = System.currentTimeMillis();
				orderFormService.saveBatch(list);
				log.info("消耗时间" + (System.currentTimeMillis() - start) + "毫秒");
				return Result.OK("文件导入成功！数据行数：" + list.size());
			} catch (Exception e) {
				log.error(e.getMessage(), e);
				return Result.error("文件导入失败:" + e.getMessage());
			} finally {
				try {
					file.getInputStream().close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return Result.error("文件导入失败！");
	}

	/*--------------------------------子表处理-order_form-end----------------------------------------------*/

}
