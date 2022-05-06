package com.order_manage.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.order_manage.entity.InvoiceHeader;
import com.order_manage.entity.InvoiceLines;
import com.order_manage.myutils.QueryGenerator;
import com.order_manage.myutils.Result;
import com.order_manage.service.IInvoiceHeaderService;
import com.order_manage.service.IInvoiceLinesService;
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
	private IInvoiceLinesService invoiceLinesService;


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

    @ApiOperation(value="invoice_header-批量删除", notes="invoice_header-批量删除")
    @DeleteMapping(value = "/deleteBatch")
    public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
        this.invoiceHeaderService.delBatchMain(Arrays.asList(ids.split(",")));
        return Result.OK("批量删除成功!");
    }


    /*--------------------------------子表处理-invoice_lines-begin----------------------------------------------*/
	/**
	 * 通过主表ID查询
	 * @return
	 */
	//@AutoLog(value = "invoice_lines-通过主表ID查询")
	@ApiOperation(value="invoice_lines-通过主表ID查询", notes="invoice_lines-通过主表ID查询")
	@GetMapping(value = "/listInvoiceLinesByMainId")
    public Result<IPage<InvoiceLines>> listInvoiceLinesByMainId(InvoiceLines invoiceLines,
																@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
																@RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
																HttpServletRequest req) {
        QueryWrapper<InvoiceLines> queryWrapper = QueryGenerator.initQueryWrapper(invoiceLines, req.getParameterMap());
        Page<InvoiceLines> page = new Page<InvoiceLines>(pageNo, pageSize);
        IPage<InvoiceLines> pageList = invoiceLinesService.page(page, queryWrapper);
        return Result.OK(pageList);
    }

	/**
	 * 添加
	 * @param invoiceLines
	 * @return
	 */

	@ApiOperation(value="invoice_lines-添加", notes="invoice_lines-添加")
	@PostMapping(value = "/addInvoiceLines")
	public Result<String> addInvoiceLines(@RequestBody InvoiceLines invoiceLines) {
		invoiceLinesService.save(invoiceLines);
		return Result.OK("添加成功！");
	}

    /**
	 * 编辑
	 * @param invoiceLines
	 * @return
	 */

	@ApiOperation(value="invoice_lines-编辑", notes="invoice_lines-编辑")
	@RequestMapping(value = "/editInvoiceLines", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> editInvoiceLines(@RequestBody InvoiceLines invoiceLines) {
		invoiceLinesService.updateById(invoiceLines);
		return Result.OK("编辑成功!");
	}

	/**
	 * 通过id删除
	 * @param id
	 * @return
	 */

	@ApiOperation(value="invoice_lines-通过id删除", notes="invoice_lines-通过id删除")
	@DeleteMapping(value = "/deleteInvoiceLines")
	public Result<String> deleteInvoiceLines(@RequestParam(name="id",required=true) String id) {
		invoiceLinesService.removeById(id);
		return Result.OK("删除成功!");
	}

	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */

	@ApiOperation(value="invoice_lines-批量删除", notes="invoice_lines-批量删除")
	@DeleteMapping(value = "/deleteBatchInvoiceLines")
	public Result<String> deleteBatchInvoiceLines(@RequestParam(name="ids",required=true) String ids) {
	    this.invoiceLinesService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}


    /**
     * 导入
     * @return
     */
    @RequestMapping(value = "/importInvoiceLines/{mainId}")
    public Result<?> importInvoiceLines(HttpServletRequest request, HttpServletResponse response, @PathVariable("mainId") String mainId) {
		 MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		 Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
		 for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
			 MultipartFile file = entity.getValue();// 获取上传文件对象
			 ImportParams params = new ImportParams();
			 params.setTitleRows(2);
			 params.setHeadRows(1);
			 params.setNeedSave(true);
			 try {
				 List<InvoiceLines> list = ExcelImportUtil.importExcel(file.getInputStream(), InvoiceLines.class, params);
				 for (InvoiceLines temp : list) {
                    temp.setHeaderId(Integer.valueOf(mainId));
				 }
				 long start = System.currentTimeMillis();
				 invoiceLinesService.saveBatch(list);
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

    /*--------------------------------子表处理-invoice_lines-end----------------------------------------------*/




}