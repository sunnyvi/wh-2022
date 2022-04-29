package com.order_manage.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.order_manage.entity.InvoiceHeader;
import com.order_manage.entity.InvoiceLine;
import com.order_manage.myutils.QueryGenerator;
import com.order_manage.myutils.Result;
import com.order_manage.service.IInvoiceHeaderService;
import com.order_manage.service.IInvoiceLineService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.def.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.view.JeecgEntityExcelView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Api(tags="invoice_header")
@RestController
@RequestMapping("/invoiceHeader")
@Slf4j
public class InvoiceHeaderController {

	@Autowired
	private IInvoiceHeaderService invoiceHeaderService;

	@Autowired
	private IInvoiceLineService invoiceLineService;


	/*---------------------------------主表处理-begin-------------------------------------*/

	/**
	 * 分页列表查询
	 * @param invoiceHeader
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "invoice_header-分页列表查询")
	@ApiOperation(value="invoice_header-分页列表查询", notes="invoice_header-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<InvoiceHeader>> queryPageList(InvoiceHeader invoiceHeader,
													  @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
													  @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
													  HttpServletRequest req) {
		QueryWrapper<InvoiceHeader> queryWrapper = QueryGenerator.initQueryWrapper(invoiceHeader, req.getParameterMap());
		Page<InvoiceHeader> page = new Page<InvoiceHeader>(pageNo, pageSize);
		IPage<InvoiceHeader> pageList = invoiceHeaderService.page(page, queryWrapper);
		return Result.OK(pageList);
	}

	/**
     *   添加
     * @param invoiceHeader
     * @return
     */
    // @AutoLog(value = "invoice_header-添加")
    @ApiOperation(value="invoice_header-添加", notes="invoice_header-添加")
    @PostMapping(value = "/add")
    public Result<String> add(@RequestBody InvoiceHeader invoiceHeader) {
        invoiceHeaderService.save(invoiceHeader);
        return Result.OK("添加成功！");
    }

    /**
     *  编辑
     * @param invoiceHeader
     * @return
     */
    // @AutoLog(value = "invoice_header-编辑")
    @ApiOperation(value="invoice_header-编辑", notes="invoice_header-编辑")
    @RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
    public Result<String> edit(@RequestBody InvoiceHeader invoiceHeader) {
        invoiceHeaderService.updateById(invoiceHeader);
        return Result.OK("编辑成功!");
    }

    /**
     * 通过id删除
     * @param id
     * @return
     */
    // @AutoLog(value = "invoice_header-通过id删除")
    @ApiOperation(value="invoice_header-通过id删除", notes="invoice_header-通过id删除")
    @DeleteMapping(value = "/delete")
    public Result<String> delete(@RequestParam(name="id",required=true) String id) {
        invoiceHeaderService.delMain(id);
        return Result.OK("删除成功!");
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    // @AutoLog(value = "invoice_header-批量删除")
    @ApiOperation(value="invoice_header-批量删除", notes="invoice_header-批量删除")
    @DeleteMapping(value = "/deleteBatch")
    public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
        this.invoiceHeaderService.delBatchMain(Arrays.asList(ids.split(",")));
        return Result.OK("批量删除成功!");
    }


	

    /*--------------------------------子表处理-invoice_line-begin----------------------------------------------*/
	/**
	 * 通过主表ID查询
	 * @return
	 */
	//@AutoLog(value = "invoice_line-通过主表ID查询")
	@ApiOperation(value="invoice_line-通过主表ID查询", notes="invoice_line-通过主表ID查询")
	@GetMapping(value = "/listInvoiceLineByMainId")
    public Result<IPage<InvoiceLine>> listInvoiceLineByMainId(InvoiceLine invoiceLine,
															  @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
															  @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
															  HttpServletRequest req) {
        QueryWrapper<InvoiceLine> queryWrapper = QueryGenerator.initQueryWrapper(invoiceLine, req.getParameterMap());
        Page<InvoiceLine> page = new Page<InvoiceLine>(pageNo, pageSize);
        IPage<InvoiceLine> pageList = invoiceLineService.page(page, queryWrapper);
        return Result.OK(pageList);
    }

	/**
	 * 添加
	 * @param invoiceLine
	 * @return
	 */
	// @AutoLog(value = "invoice_line-添加")
	@ApiOperation(value="invoice_line-添加", notes="invoice_line-添加")
	@PostMapping(value = "/addInvoiceLine")
	public Result<String> addInvoiceLine(@RequestBody InvoiceLine invoiceLine) {
		invoiceLineService.save(invoiceLine);
		return Result.OK("添加成功！");
	}

    /**
	 * 编辑
	 * @param invoiceLine
	 * @return
	 */
	// @AutoLog(value = "invoice_line-编辑")
	@ApiOperation(value="invoice_line-编辑", notes="invoice_line-编辑")
	@RequestMapping(value = "/editInvoiceLine", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> editInvoiceLine(@RequestBody InvoiceLine invoiceLine) {
		invoiceLineService.updateById(invoiceLine);
		return Result.OK("编辑成功!");
	}

	/**
	 * 通过id删除
	 * @param id
	 * @return
	 */
	// @AutoLog(value = "invoice_line-通过id删除")
	@ApiOperation(value="invoice_line-通过id删除", notes="invoice_line-通过id删除")
	@DeleteMapping(value = "/deleteInvoiceLine")
	public Result<String> deleteInvoiceLine(@RequestParam(name="id",required=true) String id) {
		invoiceLineService.removeById(id);
		return Result.OK("删除成功!");
	}

	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	// @AutoLog(value = "invoice_line-批量删除")
	@ApiOperation(value="invoice_line-批量删除", notes="invoice_line-批量删除")
	@DeleteMapping(value = "/deleteBatchInvoiceLine")
	public Result<String> deleteBatchInvoiceLine(@RequestParam(name="ids",required=true) String ids) {
	    this.invoiceLineService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}

    /**
     * 导出
     * @return
     */
//    @RequestMapping(value = "/exportInvoiceLine")
//    public ModelAndView exportInvoiceLine(HttpServletRequest request, InvoiceLine invoiceLine) {
//		 // Step.1 组装查询条件
//		 QueryWrapper<InvoiceLine> queryWrapper = QueryGenerator.initQueryWrapper(invoiceLine, request.getParameterMap());
//		 LoginUser sysUser = (LoginUser) SecurityUtils.getSubject().getPrincipal();
//
//		 // Step.2 获取导出数据
//		 List<InvoiceLine> pageList = invoiceLineService.list(queryWrapper);
//		 List<InvoiceLine> exportList = null;
//
//		 // 过滤选中数据
//		 String selections = request.getParameter("selections");
//		 if (oConvertUtils.isNotEmpty(selections)) {
//			 List<String> selectionList = Arrays.asList(selections.split(","));
//			 exportList = pageList.stream().filter(item -> selectionList.contains(item.getId())).collect(Collectors.toList());
//		 } else {
//			 exportList = pageList;
//		 }
//
//		 // Step.3 AutoPoi 导出Excel
//		 ModelAndView mv = new ModelAndView(new JeecgEntityExcelView());
//		 mv.addObject(NormalExcelConstants.FILE_NAME, "invoice_line"); //此处设置的filename无效 ,前端会重更新设置一下
//		 mv.addObject(NormalExcelConstants.CLASS, InvoiceLine.class);
//		 mv.addObject(NormalExcelConstants.PARAMS, new ExportParams("invoice_line报表", "导出人:" + sysUser.getRealname(), "invoice_line"));
//		 mv.addObject(NormalExcelConstants.DATA_LIST, exportList);
//		 return mv;
//    }

    /**
     * 导入
     * @return
     */
    @RequestMapping(value = "/importInvoiceLine/{mainId}")
    public Result<?> importInvoiceLine(HttpServletRequest request, HttpServletResponse response, @PathVariable("mainId") String mainId) {
		 MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		 Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
		 for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
			 MultipartFile file = entity.getValue();// 获取上传文件对象
			 ImportParams params = new ImportParams();
			 params.setTitleRows(2);
			 params.setHeadRows(1);
			 params.setNeedSave(true);
			 try {
				 List<InvoiceLine> list = ExcelImportUtil.importExcel(file.getInputStream(), InvoiceLine.class, params);
				 for (InvoiceLine temp : list) {
                    temp.setHeaderId(Integer.valueOf(mainId));
				 }
				 long start = System.currentTimeMillis();
				 invoiceLineService.saveBatch(list);
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

    /*--------------------------------子表处理-invoice_line-end----------------------------------------------*/




}