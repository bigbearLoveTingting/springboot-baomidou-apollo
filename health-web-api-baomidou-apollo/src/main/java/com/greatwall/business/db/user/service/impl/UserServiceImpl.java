package com.greatwall.business.db.user.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.google.common.collect.Maps;
import com.greatwall.business.db.user.dao.UserMapper;
import com.greatwall.business.db.user.form.UserLoginForm;
import com.greatwall.business.db.user.model.UserModel;
import com.greatwall.business.db.user.service.UserService;
import com.greatwall.business.db.user.vo.UserSessionVo;

import lombok.extern.slf4j.Slf4j;
import xingkong.tool.core.web.form.PageForm;

@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserModel>implements UserService {

	@Autowired
	UserMapper userMapper;

	@Override
	public int add(UserModel userModel) {
		int id = userMapper.insert(userModel);
		return id;
	}

	@Override
	public void delete(UserModel userModel) {
		if (userModel != null) {
			EntityWrapper<UserModel> entityWrapper = new EntityWrapper<UserModel>();
			entityWrapper.setEntity(userModel);
			userMapper.delete(entityWrapper);
		}
	}

	@Override
	public void update(UserModel userModel) {
		if (userModel != null) {
			userMapper.updateById(userModel);
		}
	}

	@Override
	public UserModel view(UserModel userModel) {
		return userMapper.selectOne(userModel);
	}

//	@Override
//	public PageInfo<UserModel> list(UserModel userModel, PageForm pageForm) { 
//
//		if (pageForm.getPageNo() != null && pageForm.getPageSize() != null) {
//			PageHelper.startPage(pageForm.getPageNo(), pageForm.getPageSize());
//		}
//		List<UserModel> userList = userMapper.select(userModel);
//		
//		// 返回分页对象
//		PageInfo<UserModel> userPageInfo = new PageInfo<>(userList);
//		
//		return userPageInfo;
//	}

	@Override
	public UserSessionVo login(UserLoginForm userLoginForm) {
		return userMapper.login(userLoginForm);
	}
	/*
	 * 
	 * @Override public void updateStatus(UserStatusForm userStatusForm) {
	 * userMapper.updateStatus(userStatusForm); }
	 * 
	 * @Override public void updatePassword(UserPasswordForm userPasswordForm) {
	 * UserModel userModel = new UserModel();
	 * userModel.setUserId(userPasswordForm.getUserId());
	 * userModel.setPassword(userPasswordForm.getPassword());
	 * userMapper.updateByPrimaryKeySelective(userModel); }
	 */
	
	/**
	 * 根据电话号码删除用户
	 */
	@Override
	public void deleteUserByMobile(UserModel userModel) {
		if (userModel != null && userModel.getMobile() != null) {
			userMapper.deleteUserByMobile(userModel);
		}
	}

	@Override
	public Map<String, Object> list(UserModel userModel, PageForm pageForm) {
		Map<String, Object> resultMap = Maps.newHashMap();
		Page<UserModel> pageRecod = new Page<>(pageForm.getPageNo(), pageForm.getPageSize()); 
		List<UserModel> userList = userMapper.queryByTrem(userModel, pageRecod);
		resultMap.put("total", pageRecod.getTotal());
		resultMap.put("rows", userList);
		return resultMap;
	}
	
	
	/**
	 * 根据搜索条件查询用户列表
	 */
//	@Override
//	public PageInfo<UserModel> queryByTrem(UserModel userModel, PageForm pageForm) { 
//		if (pageForm.getPageNo() != null && pageForm.getPageSize() != null) {
//			PageHelper.startPage(pageForm.getPageNo(), pageForm.getPageSize());
//		}
//		if (!StringUtils.isEmpty(userModel.getNickName())) {
//			userModel.setNickName("%"+userModel.getNickName()+"%");
//		}
//		List<UserModel> userList = userMapper.queryByTrem(userModel);
//
//		// 返回分页对象
//		PageInfo<UserModel> userPageInfo = new PageInfo<>(userList);
//		return userPageInfo;
//	}

}