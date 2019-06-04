package com.greatwall.business.controller.weixin;



import java.util.Arrays;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.greatwall.business.db.weixin.form.WexinCheckForm;

import lombok.extern.slf4j.Slf4j;
import xingkong.framework.config.WexinConfig;
import xingkong.tool.core.JsonTool;

/**
 * 
 * @author xingkong
 *
 */
@Slf4j
@Controller
public class WexinCheckController {


	@Autowired
	private WexinConfig wexinConfig;

	/**
	 * 微信检查
	 * @param wexinCheckForm
	 * @param model
	 * @return
	 */
	@RequestMapping(path = "/wx.check.html")
	@ResponseBody
	public String check(WexinCheckForm wexinCheckForm, Model model) {

		log.info("request: " + JsonTool.toJSONString(wexinCheckForm));

		String reSignature = null;
		try {
			String[] str = { wexinConfig.getToken(), wexinCheckForm.getTimestamp(), wexinCheckForm.getNonce() };
			Arrays.sort(str);
			String bigStr = str[0] + str[1] + str[2];
			reSignature = DigestUtils.sha1Hex(bigStr).toLowerCase();
			log.info("reSignature:" + reSignature);
		} catch (Exception e) {
			log.error("read form error", e);
		}
		if (null != reSignature && reSignature.equals(wexinCheckForm.getSignature())) {
			log.info("check ok");
			return wexinCheckForm.getEchostr();
		} else {
			log.info("check error");
			return "error request! the request is not from weixin server";
		}
	}

}
