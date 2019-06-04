package com.greatwall.business.controller.weixin;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.greatwall.business.db.weixin.model.WxUserModel;

import lombok.extern.slf4j.Slf4j;
import xingkong.framework.config.WexinConfig;
import xingkong.tool.core.WexinTool;
import xingkong.tool.core.web.vo.ResponseVo;

@Slf4j
@Controller
public class WexinLoginController {

	@Autowired
	private WexinConfig wexinConfig;

	/**
	 * 微信登录跳转操作
	 * @return
	 */
	@RequestMapping("/wx.login")
	ModelAndView login() {

		String url=null;

		try {
			url = "https://open.weixin.qq.com/connect/oauth2/authorize?" + "appid=" + wexinConfig.getAppid()
					+ "&redirect_uri=" + URLEncoder.encode(wexinConfig.getRedirectUrl(), "UTF-8")
					+ "&response_type=code" + "&scope=snsapi_userinfo" + "&state=STATE#wechat_redirect";
		} catch (UnsupportedEncodingException e) {
			log.error(e.getMessage(), e);
		}

		log.info(url);
		return new ModelAndView("redirect:" + url);
	}

	/**
	 * 微信回调请求
	 * @param code
	 * @param model
	 * @return
	 */
	@RequestMapping("/wx.logincallback")
	String loginCallback(String code, Model model) {
		log.info("Enter loginCallback");
		ResponseVo responseVo = null;

		try {
			// 第一步，获取access_token
			String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + wexinConfig.getAppid()
					+ "&secret=" + wexinConfig.getAppSecret() + "&code=" + code + "&grant_type=authorization_code";

			JSONObject jsonObject = WexinTool.doGetJson(url);
			String accessToken = jsonObject.getString("access_token");
			String openId = jsonObject.getString("openId");
			log.info("accessToken:" + accessToken + " " + "openId:" + openId);
			log.info(url);

			// 第二部, 拉取用户信息
			String infoUrl = "https://api.weixin.qq.com/sns/userinfo?access_token=" + accessToken + "&openid=" + openId
					+ "&lang=zh_CN";
			JSONObject userInfo = WexinTool.doGetJson(infoUrl);
			WxUserModel wxUser = userInfo.toJavaObject(WxUserModel.class);
			model.addAttribute("wxUser", wxUser);

			log.info(infoUrl);
			log.info(userInfo.toJSONString());
			
			
			

		} catch (Exception e) {

			log.error("", e);
		}

		return "logincallback";
	}
}
