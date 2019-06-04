package com.greatwall.business.page.index;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@CrossOrigin
public class I18nPage {
	/**
	 * 改变语言
	 * @param request
	 * @param response
	 * @param lang
	 * @return
	 */
	@GetMapping("/changeLang.html")
	public ModelAndView language(HttpServletRequest request, HttpServletResponse response, String lang) {
		Locale locale = request.getLocale();
		LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
		lang = lang.toLowerCase();
		log.info("language:" + lang);
		if (lang == null || lang.equals("")) {
			localeResolver.setLocale(request, response, Locale.CHINA);
		} else {
			if ("zh_cn".equals(lang)) {
				localeResolver.setLocale(request, response, Locale.CHINA);
			} else if ("en_us".equals(lang)) {
				localeResolver.setLocale(request, response, Locale.US);
			}
		}
		return new ModelAndView("redirect:index.html");
	}
}
