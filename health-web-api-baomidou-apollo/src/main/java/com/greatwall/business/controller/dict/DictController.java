package com.greatwall.business.controller.dict;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatwall.business.db.dict.model.DictModel;
import com.greatwall.business.db.dict.service.DictService;

import lombok.extern.slf4j.Slf4j;
import xingkong.tool.core.ResponseTool;
import xingkong.tool.core.web.form.PageForm;
import xingkong.tool.core.web.vo.ResponseVo;

/**
 * 
 * @author xingkong
 *
 */
@Slf4j
@RestController
@RequestMapping("/dict")
public class DictController {

	@Autowired
	private DictService dictService;

	/**
	 * 查看字典列表
	 * 
	 * @param dict
	 *            字典模型
	 * @param pageForm
	 *            分页参数
	 * @return
	 * @throws Exception
	 */
//	@RequestMapping("list")
//	// @RequiresPermissions("dict:list")
//	public ResponseVo list(DictModel dict, PageForm pageForm) throws Exception {
//		return ResponseTool.success(dictService.list(dict, pageForm));
//	}

	/**
	 * 新增字典
	 * 
	 * @param dict
	 *            字典模型
	 * @return
	 */
	@RequestMapping("add")
	// @RequiresPermissions("dict:add")
	public ResponseVo add(@RequestBody DictModel dict) {
		try {
			dictService.add(dict);
			return ResponseTool.success("新增字典成功!");
		} catch (Exception e) {
			log.error("新增字典失败", e);
			return ResponseTool.error("新增字典失败，请联系网站管理员!");
		}
	}

	/**
	 * 删除字典
	 * 
	 * @param dict
	 *            字典模型
	 * @return
	 */
	@RequestMapping("delete")
	// @RequiresPermissions("dict:delete")
	public ResponseVo delete(DictModel dict) {
		try {
			this.dictService.delete(dict);
			return ResponseTool.success("删除字典成功!");
		} catch (Exception e) {
			log.error("删除字典失败", e);
			return ResponseTool.error("删除字典失败，请联系网站管理员!");
		}
	}

	/**
	 * 修改字典
	 * 
	 * @param dict
	 *            修改字典
	 * @return
	 */
	@RequestMapping("update")
	// @RequiresPermissions("dict:update")
	public ResponseVo update(@RequestBody DictModel dict) {
		try {
			this.dictService.update(dict);
			return ResponseTool.success("修改字典成功!");
		} catch (Exception e) {
			log.error("修改字典失败", e);
			return ResponseTool.error("修改字典失败，请联系网站管理员!");
		}
	}

	/**
	 * 按条件查询字典
	 * 
	 * @param dictModel
	 *            字典模型
	 * @param pageForm
	 *            分页参数
	 * @return
	 */
//	@RequestMapping("/queryByTrem")
//	public ResponseVo queryByTrem(DictModel dictModel, PageForm pageForm) {
//		return ResponseTool.success(dictService.queryByTrem(dictModel, pageForm));
//	}
}
