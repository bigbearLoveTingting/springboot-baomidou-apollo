package com.greatwall.business.db.user.vo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class UserSessionVo  implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private String userId;
	private String mobile;
	private String nickName;
	private String realName;
	private String sex;
	private String avatar;
	private String status;
	private Date createTime;
	
}
