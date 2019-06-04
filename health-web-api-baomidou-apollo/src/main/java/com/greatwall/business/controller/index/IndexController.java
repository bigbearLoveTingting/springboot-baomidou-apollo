package com.greatwall.business.controller.index;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import xingkong.tool.core.ResponseTool;
import xingkong.tool.core.web.vo.ResponseVo;

/**
 * 
 * @author xingkong
 *
 */
@Slf4j
@RestController
@CrossOrigin
public class IndexController {
	@Autowired
	private MessageSource messageSource;

	/**
	 * 首页
	 * @return
	 */
	@RequestMapping(value = "/index")
	public ResponseVo index() {
		log.info("[info] visit index");
		log.debug("[debug] visit index");
		log.error("[error] visit index");
		log.warn("[warn] visit index");
		Locale locale = LocaleContextHolder.getLocale();
		String navMenuIndex = messageSource.getMessage("nav.menu.index", null, locale);
		return ResponseTool.success(navMenuIndex);
	}
}