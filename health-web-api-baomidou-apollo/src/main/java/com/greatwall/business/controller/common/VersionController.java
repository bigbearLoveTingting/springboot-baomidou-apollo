package com.greatwall.business.controller.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import xingkong.framework.config.VersionConfig;
import xingkong.tool.core.ResponseTool;
import xingkong.tool.core.web.vo.ResponseVo;
import xingkong.tool.core.web.vo.VersionVo;
/**
 * 版本控制器
 * @author 聂芳华
 */
@Controller
public class VersionController {
	
	@Autowired
	private VersionConfig versionConfig;
	
	@Value("${spring.profiles.active}")
	private String profile;
	
	@Value("${spring.application.name}")
	private String applicationName;
	
	/**
	 * 获取API版本
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/api/version")
	public Object getVersion() {
		VersionVo versionVo = new VersionVo();
		versionVo.setName(applicationName);
		versionVo.setLine(profile);
		versionVo.setVersion("v"+versionConfig.getBase()+"."+versionConfig.getSvnid()+"."+versionConfig.getTime());
		ResponseVo responseVo=ResponseTool.success(versionVo);
		return responseVo;
	}
}
