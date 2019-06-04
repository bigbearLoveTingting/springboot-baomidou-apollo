package xingkong.tool.core.web.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 通用返回结果
 * 
 * @author 星空
 */

public class PageResponseVo extends ResponseVo {

	PageResponseVo(int code, String message) {
		super(code, message);
	}

	/**
	 * 每页展示数据条数
	 */
	@Getter
	@Setter
	private int pageSize;

	/**
	 * 当前显示的数据页编号
	 */
	@Getter
	@Setter
	private int pageNo;

	/**
	 * 数据总条数
	 */
	@Getter
	@Setter
	private int totalNum;

	/**
	 * 数据总页数
	 */
	@Getter
	@Setter
	private int totalPage;

}
