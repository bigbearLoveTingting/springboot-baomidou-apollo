package com.greatwall.business.controller.user;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatwall.business.db.user.form.UserLoginForm;
import com.greatwall.business.db.user.model.UserModel;
import com.greatwall.business.db.user.service.UserService;
import com.greatwall.business.db.user.vo.UserSessionVo;

import lombok.extern.slf4j.Slf4j;
import xingkong.tool.core.ResponseTool;
import xingkong.tool.core.StringTool;
import xingkong.tool.core.web.form.PageForm;
import xingkong.tool.core.web.vo.ResponseVo;

/**
 *
 * @author xingkong
 */

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	/**
	 * 用户列表
	 * 
	 * @param userModel 用户模型
	 * @param pageForm  分页参数
	 * @return
	 */
	@RequestMapping("/list")
	public ResponseVo list(UserModel userModel, PageForm pageForm) {
		return ResponseTool.success(userService.list(userModel, pageForm));
	}

	/**
	 * 查看用户
	 * 
	 * @param userModel 用户模型
	 * @return
	 */
	@RequestMapping("/view")
	public ResponseVo view(UserModel userModel) {
		return ResponseTool.success(userService.view(userModel));
	}

	/**
	 * 查询用户
	 * 
	 * @param userModel 用户模型
	 * @param pageForm
	 * @return
	 */
//	@RequestMapping("/queryByTrem")
//	public ResponseVo queryByTrem(UserModel userModel, PageForm pageForm) {
//		return ResponseTool.success(userService.queryByTrem(userModel, pageForm));
//	}

	/**
	 * 添加用户
	 * 
	 * @param userModel 用户模型
	 * @return
	 */
	@RequestMapping("/add")
	public ResponseVo add(@RequestBody UserModel userModel) {
		userService.add(userModel);
		return ResponseTool.success();
	}

	/**
	 * 删除用户
	 * 
	 * @param userModel 用户模型
	 * @return
	 */
	@RequestMapping("/delete")
	public ResponseVo delete(@RequestBody UserModel userModel) {
		userService.deleteUserByMobile(userModel);
		return ResponseTool.success();
	}

	/**
	 * 更新用户
	 * 
	 * @param userModel 用户模型
	 * @return
	 */
	@RequestMapping("/update")
	public ResponseVo update(@RequestBody(required = false) UserModel userModel) {
		userService.update(userModel);
		return ResponseTool.success();
	}

	/**
	 * 用户状态查询
	 * 
	 * @return
	 */
	@RequestMapping("/loginStatus/view")
	public ResponseVo loginStatusView() {
		Subject currentUser = SecurityUtils.getSubject();
		if (!currentUser.isAuthenticated()) {
			return ResponseTool.error("你还没有登录，请先登录");
		} else {
			UserSessionVo sessionVo = (UserSessionVo) currentUser.getSession().getAttribute("user");
			return ResponseTool.success(sessionVo, "你已经登录");
		}
	}

	/**
	 * 用户退出
	 * 
	 * @return
	 */
	@RequestMapping("/logout")
	public ResponseVo logout() {
		Subject currentUser = SecurityUtils.getSubject();
		currentUser.logout();
		return ResponseTool.success("成功退出登录");
	}

	/**
	 * 用户登录
	 * 
	 * @param userLoginForm
	 * @return
	 */
	@RequestMapping("/login")
	public ResponseVo login(@RequestBody UserLoginForm userLoginForm) {
		if (StringTool.isNotEmpty(userLoginForm.getUserName()) && StringTool.isNotEmpty(userLoginForm.getPassword())) {
			try {
				UserSessionVo sessionVo = userService.login(userLoginForm);
				return ResponseTool.success(sessionVo, "登录成功");
			} catch (Exception e) {
				log.error("认证错误", e);
				return ResponseTool.error("登录失败", e.getMessage());
			}
		} else {
			return ResponseTool.error("登录失败,用户名或者密码不正确", "用户名或者密码为空");
		}

	}
}
