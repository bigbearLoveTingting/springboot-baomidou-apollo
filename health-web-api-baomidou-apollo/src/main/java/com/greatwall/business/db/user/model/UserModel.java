package com.greatwall.business.db.user.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

/**
 * @author xingkong
 */

@Data
@ToString
@Table(name = "user")
public class UserModel {
	@Id
	@Column(name = "user_id")
	private Integer userId;
	
	/**
	 * 微信Id
	 */
	private String wxOpenId;
	
	/**
	 * 用户手机号码
	 */
	private String mobile;
	
	/**
	 * 用户昵称
	 */
	private String nickName;
	
	/**
	 * 用户真实姓名
	 */
	private String realName;
	
	/**
	 * 用户头像
	 */
	private String avatar;
	
	/**
	 * 用户性别, 0 女 1 男 2 保密
	 */
	private Integer sex;
	
	
	/**
	 * 用户状态,0 正常 1 禁用
	 */
	private Integer status;
	
	/**
	 * 用户注册时间
	 */
	private Date createTime;
	
}