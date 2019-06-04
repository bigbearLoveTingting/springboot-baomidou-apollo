package xingkong.tool.core.web.form;

import lombok.Data;

/**
 * 通用分页Form
 * 
 * @author 星空
 */
@Data
public class PageForm {

	/**
	 * 需要显示的分页编号
	 */
	private Integer pageNo;

	/**
	 * 每页展示条数
	 */
	private Integer pageSize;
}
