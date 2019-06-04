package com.greatwall.business.db.weixin.model;

import lombok.Data;

@Data
public class WxUserModel {
	String country;
	String province;
	String city;
	String openid;
	String sex;
	String nickname;
	String headimgurl;
	String language;
}
