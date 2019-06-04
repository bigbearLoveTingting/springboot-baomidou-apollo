package com.greatwall.business.page.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@CrossOrigin
public class IndexPage {

	/**
	 * 根目录
	 * @return
	 */
	@RequestMapping(value = "/")
	public ModelAndView root() {
		return new ModelAndView("redirect:/index.html");
	}

	/**
	 * 首页
	 * @return
	 */
	@RequestMapping(value = "/index.html")
	public ModelAndView index() {

		return new ModelAndView("index");
	}

}
