package com.order_manage.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.order_manage.entity.ShippingOrderHeader;
import com.order_manage.entity.ShippingOrderLine;
import com.order_manage.myutils.QueryGenerator;
import com.order_manage.myutils.Result;
import com.order_manage.service.ShippingOrderHeaderService;
import com.order_manage.service.ShippingOrderLineService;
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

@Api(tags="shipping_order_header")
@RestController
@RequestMapping("/com.order_manage/shippingOrderHeader")
@Slf4j
public class ShippingOrderHeaderController  {

	@Autowired
	private ShippingOrderHeaderService shippingOrderHeaderService;

	@Autowired
	private ShippingOrderLineService shippingOrderLineService;


	/*---------------------------------主表处理-begin-------------------------------------*/

	/**
	 * 分页列表查询
	 * @param shippingOrderHeader
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "shipping_order_header-分页列表查询")
	@ApiOperation(value="shipping_order_header-分页列表查询", notes="shipping_order_header-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<ShippingOrderHeader>> queryPageList(ShippingOrderHeader shippingOrderHeader,
															@RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
															@RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
															HttpServletRequest req) {
		QueryWrapper<ShippingOrderHeader> queryWrapper = QueryGenerator.initQueryWrapper(shippingOrderHeader, req.getParameterMap());
		Page<ShippingOrderHeader> page = new Page<ShippingOrderHeader>(pageNo, pageSize);
		IPage<ShippingOrderHeader> pageList = shippingOrderHeaderService.page(page, queryWrapper);
		return Result.OK(pageList);
	}

	/**
     *   添加
     * @param shippingOrderHeader
     * @return
     */
    // @AutoLog(value = "shipping_order_header-添加")
    @ApiOperation(value="shipping_order_header-添加", notes="shipping_order_header-添加")
    @PostMapping(value = "/add")
    public Result<String> add(@RequestBody ShippingOrderHeader shippingOrderHeader) {
        shippingOrderHeaderService.save(shippingOrderHeader);
        return Result.OK("添加成功！");
    }

    /**
     *  编辑
     * @param shippingOrderHeader
     * @return
     */
    // @AutoLog(value = "shipping_order_header-编辑")
    @ApiOperation(value="shipping_order_header-编辑", notes="shipping_order_header-编辑")
    @RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
    public Result<String> edit(@RequestBody ShippingOrderHeader shippingOrderHeader) {
        shippingOrderHeaderService.updateById(shippingOrderHeader);
        return Result.OK("编辑成功!");
    }

    /**
     * 通过id删除
     * @param id
     * @return
     */
    // @AutoLog(value = "shipping_order_header-通过id删除")
    @ApiOperation(value="shipping_order_header-通过id删除", notes="shipping_order_header-通过id删除")
    @DeleteMapping(value = "/delete")
    public Result<String> delete(@RequestParam(name="id",required=true) String id) {
        shippingOrderHeaderService.delMain(id);
        return Result.OK("删除成功!");
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    // @AutoLog(value = "shipping_order_header-批量删除")
    @ApiOperation(value="shipping_order_header-批量删除", notes="shipping_order_header-批量删除")
    @DeleteMapping(value = "/deleteBatch")
    public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
        this.shippingOrderHeaderService.delBatchMain(Arrays.asList(ids.split(",")));
        return Result.OK("批量删除成功!");
    }

    /**
     * 导出
     * @return
     */


    /*--------------------------------子表处理-shipping_order_line-begin----------------------------------------------*/
	/**
	 * 通过主表ID查询
	 * @return
	 */
	//@AutoLog(value = "shipping_order_line-通过主表ID查询")
	@ApiOperation(value="shipping_order_line-通过主表ID查询", notes="shipping_order_line-通过主表ID查询")
	@GetMapping(value = "/listShippingOrderLineByMainId")
    public Result<IPage<ShippingOrderLine>> listShippingOrderLineByMainId(ShippingOrderLine shippingOrderLine,
																		  @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
																		  @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
																		  HttpServletRequest req) {
        QueryWrapper<ShippingOrderLine> queryWrapper = QueryGenerator.initQueryWrapper(shippingOrderLine, req.getParameterMap());
        Page<ShippingOrderLine> page = new Page<ShippingOrderLine>(pageNo, pageSize);
        IPage<ShippingOrderLine> pageList = shippingOrderLineService.page(page, queryWrapper);
        return Result.OK(pageList);
    }

	/**
	 * 添加
	 * @param shippingOrderLine
	 * @return
	 */
	// @AutoLog(value = "shipping_order_line-添加")
	@ApiOperation(value="shipping_order_line-添加", notes="shipping_order_line-添加")
	@PostMapping(value = "/addShippingOrderLine")
	public Result<String> addShippingOrderLine(@RequestBody ShippingOrderLine shippingOrderLine) {
		shippingOrderLineService.save(shippingOrderLine);
		return Result.OK("添加成功！");
	}

    /**
	 * 编辑
	 * @param shippingOrderLine
	 * @return
	 */
	// @AutoLog(value = "shipping_order_line-编辑")
	@ApiOperation(value="shipping_order_line-编辑", notes="shipping_order_line-编辑")
	@RequestMapping(value = "/editShippingOrderLine", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> editShippingOrderLine(@RequestBody ShippingOrderLine shippingOrderLine) {
		shippingOrderLineService.updateById(shippingOrderLine);
		return Result.OK("编辑成功!");
	}

	/**
	 * 通过id删除
	 * @param id
	 * @return
	 */
	// @AutoLog(value = "shipping_order_line-通过id删除")
	@ApiOperation(value="shipping_order_line-通过id删除", notes="shipping_order_line-通过id删除")
	@DeleteMapping(value = "/deleteShippingOrderLine")
	public Result<String> deleteShippingOrderLine(@RequestParam(name="id",required=true) String id) {
		shippingOrderLineService.removeById(id);
		return Result.OK("删除成功!");
	}

	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	// @AutoLog(value = "shipping_order_line-批量删除")
	@ApiOperation(value="shipping_order_line-批量删除", notes="shipping_order_line-批量删除")
	@DeleteMapping(value = "/deleteBatchShippingOrderLine")
	public Result<String> deleteBatchShippingOrderLine(@RequestParam(name="ids",required=true) String ids) {
	    this.shippingOrderLineService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}

    /**
     * 导出
     * @return
     */
//    @RequestMapping(value = "/exportShippingOrderLine")
//    public ModelAndView exportShippingOrderLine(HttpServletRequest request, ShippingOrderLine shippingOrderLine) {
//		 // Step.1 组装查询条件
//		 QueryWrapper<ShippingOrderLine> queryWrapper = QueryGenerator.initQueryWrapper(shippingOrderLine, request.getParameterMap());
//		 LoginUser sysUser = (LoginUser) SecurityUtils.getSubject().getPrincipal();
//
//		 // Step.2 获取导出数据
//		 List<ShippingOrderLine> pageList = shippingOrderLineService.list(queryWrapper);
//		 List<ShippingOrderLine> exportList = null;
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
//		 mv.addObject(NormalExcelConstants.FILE_NAME, "shipping_order_line"); //此处设置的filename无效 ,前端会重更新设置一下
//		 mv.addObject(NormalExcelConstants.CLASS, ShippingOrderLine.class);
//		 mv.addObject(NormalExcelConstants.PARAMS, new ExportParams("shipping_order_line报表", "导出人:" + sysUser.getRealname(), "shipping_order_line"));
//		 mv.addObject(NormalExcelConstants.DATA_LIST, exportList);
//		 return mv;
//    }
//
//    /**
//     * 导入
//     * @return
//     */
//    @RequestMapping(value = "/importShippingOrderLine/{mainId}")
//    public Result<?> importShippingOrderLine(HttpServletRequest request, HttpServletResponse response, @PathVariable("mainId") String mainId) {
//		 MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
//		 Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
//		 for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
//			 MultipartFile file = entity.getValue();// 获取上传文件对象
//			 ImportParams params = new ImportParams();
//			 params.setTitleRows(2);
//			 params.setHeadRows(1);
//			 params.setNeedSave(true);
//			 try {
//				 List<ShippingOrderLine> list = ExcelImportUtil.importExcel(file.getInputStream(), ShippingOrderLine.class, params);
//				 for (ShippingOrderLine temp : list) {
//                    temp.setHeaderId(mainId);
//				 }
//				 long start = System.currentTimeMillis();
//				 shippingOrderLineService.saveBatch(list);
//				 log.info("消耗时间" + (System.currentTimeMillis() - start) + "毫秒");
//				 return Result.OK("文件导入成功！数据行数：" + list.size());
//			 } catch (Exception e) {
//				 log.error(e.getMessage(), e);
//				 return Result.error("文件导入失败:" + e.getMessage());
//			 } finally {
//				 try {
//					 file.getInputStream().close();
//				 } catch (IOException e) {
//					 e.printStackTrace();
//				 }
//			 }
//		 }
//		 return Result.error("文件导入失败！");
//    }

    /*--------------------------------子表处理-shipping_order_line-end----------------------------------------------*/




}
