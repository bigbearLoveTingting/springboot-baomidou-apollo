package com.greatwall.business.db.dict.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.greatwall.business.db.dict.dao.DictMapper;
import com.greatwall.business.db.dict.model.DictModel;
import com.greatwall.business.db.dict.service.DictService;

import lombok.extern.slf4j.Slf4j;
import xingkong.tool.core.web.form.PageForm;

@Slf4j
@Service("dictService")
public class DictServiceImpl extends ServiceImpl<DictMapper, DictModel> implements DictService {

	@Autowired
	DictMapper dictMapper;
	
//	@Override
//	public PageInfo<DictModel> list(DictModel dict,  PageForm pageForm) {
//		if (pageForm.getPageNo() != null && pageForm.getPageSize() != null) {
//			PageHelper.startPage(pageForm.getPageNo(), pageForm.getPageSize());
//		}
//		if (pageForm.getPageNo() != null && pageForm.getPageSize() != null) {
//			PageHelper.startPage(pageForm.getPageNo(), pageForm.getPageSize());
//		}
//		List<DictModel> dictList = dictMapper.select(dict);
//		// 返回分页对象
//		PageInfo<DictModel> dictPageInfo = new PageInfo<>(dictList);
//        return dictPageInfo; 		 
//    }

	@Override
	public int add(DictModel dict) {
		int id = dictMapper.insert(dict);
		return id;
	}

	@Override
	@Transactional
	public void delete(DictModel dict) {
		if (dict != null) {
			dictMapper.deleteDict(dict);
		}}

	@Override
	@Transactional
	public void update(DictModel dict) {
		if ( dict != null)
		{
			dictMapper.updateById(dict);
		}
	}

	@Override
	public DictModel view(DictModel dict) {
		return dictMapper.selectOne(dict);
	}

	
	/**
	 * 根据搜索条件查询用户列表
	 */
//	@Override
//	public PageInfo<DictModel> queryByTrem(DictModel dictModel, PageForm pageForm) {
//		
//		if (pageForm.getPageNo() != null && pageForm.getPageSize() != null) {
//			PageHelper.startPage(pageForm.getPageNo(), pageForm.getPageSize());
//		}
//		if (!StringUtils.isEmpty(dictModel.getFieldName())) {
//			dictModel.setFieldName("%"+dictModel.getFieldName()+"%");
//		}
//		if (!StringUtils.isEmpty(dictModel.getKey())) {
//			dictModel.setKey("%"+dictModel.getKey()+"%");
//		}
//		if (!StringUtils.isEmpty(dictModel.getValue())) {
//			dictModel.setValue("%"+dictModel.getValue()+"%");
//		}
//
//		List<DictModel> dictList = dictMapper.queryByTrem(dictModel);
//
//		// 返回分页对象
//		PageInfo<DictModel> dictPageInfo = new PageInfo<>(dictList);
//		return dictPageInfo;
//	}

}
