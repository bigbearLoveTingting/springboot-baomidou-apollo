package com.greatwall.business.db.user.service;


import com.greatwall.business.db.user.form.UserLoginForm;
import com.greatwall.business.db.user.model.UserModel;
import com.greatwall.business.db.user.vo.UserSessionVo;

import xingkong.tool.core.web.form.PageForm;

public interface UserService {

	/**
	 * 添加新的用户
	 * @param userModel
	 */
	int add(UserModel userModel);

    /**
     * 删除用户
     * @param userModel
     */
    void delete(UserModel userModel);
    
    /**
     * 删除用户
     * @param userModel
     * @return 
     */
    void deleteUserByMobile(UserModel userModel);
    /**
     * 更新用户
     * @param userModel
     */
    void update(UserModel userModel);

    /**
     * 查看用户
     * @param userModel
     * @return
     */
    UserModel view(UserModel userModel);

    /**
     * 查看用户列表
     * @param userModel
     * @param pageForm
     * @return
     */
	Object list(UserModel userModel, PageForm pageForm);
	
	
    /**
     * 根据搜索条件查看用户列表
     * @param userModel
     * @param pageForm
     * @return
     */
	//Object queryByTrem(UserModel userModel, PageForm pageForm);

	UserSessionVo login(UserLoginForm userLoginForm);

	


}