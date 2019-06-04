package com.greatwall.business.db.user.vo;

import java.util.Date;

import javax.persistence.Id;

import lombok.Data;
import lombok.ToString;

/**
 *
 * @author xingkong
 * @date 2018/07/18 09:13
 */

@Data
@ToString
public class UserVo {

	/**
	 * 用户ID
	 */
	@Id
	private String userId;

	/**
	 * 头像
	 */
	private String avatar;

	/**
	 * 手机号码
	 */
	private String mobile;

	/**
	 * 密码
	 */
	private String password;

	/**
	 * 真实姓名
	 */
	private String realName;

	/**
	 * 性别 0-男 1-女 放到词典中, sex条目
	 */
	private String sex;

	/**
	 * 状态 0锁定 1有效 放到词典中,user_status条目
	 */
	private String status;

	/**
	 * 用户名
	 */
	private String userName;

	/**
	 * 创建时间
	 */
	private Date createTime;

}