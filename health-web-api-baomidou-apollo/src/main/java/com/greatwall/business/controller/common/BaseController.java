package com.greatwall.business.controller.common;

import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import com.greatwall.business.db.user.vo.UserSessionVo;

/**
 * 
 * @author xingkong
 *
 */
public class BaseController {

//	protected Map<String, Object> getDataTable(PageInfo<?> pageInfo) {
//		Map<String, Object> rspData = new HashMap<>();
//		rspData.put("rows", pageInfo.getList());
//		rspData.put("total", pageInfo.getTotal());
//		return rspData;
//	}

	public static Subject getSubject() {
		return SecurityUtils.getSubject();
	}

	protected UserSessionVo getCurrentUser() {
		UserSessionVo userSessionVo = new UserSessionVo();
		System.out.println(userSessionVo.getClass().getClassLoader());
		System.out.println(getSubject().getPrincipal().getClass().getClassLoader());
		return (UserSessionVo) getSubject().getPrincipal();
	}

	protected Session getSession() {
		return getSubject().getSession();
	}

	protected Session getSession(Boolean flag) {
		return getSubject().getSession(flag);
	}

	protected void login(AuthenticationToken token) {
		getSubject().login(token);
	}
}
