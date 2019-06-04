package xingkong.tool.core.web.vo;

import lombok.Data;

/**
 * 通用WEB项目返回响应Vo
 * 
 * @author 星空
 */
@Data
public class ResponseVo {

	
	public static final int OK = 200;
	public static final int ERROR = 500;
	
	/**
	 * 响应的编码, OK代表成功, 500表示出现内部错误
	 */
	private int code;

	/**
	 * 信息提示
	 */
	private String message;

	/**
	 * 日志信息
	 */
	private String log;

	/**
	 * 返回结果对象
	 */
	private Object data;

	public ResponseVo(){
		this(ResponseVo.OK, "OK", null);
	}
	
	public ResponseVo(Object data) {
		this(ResponseVo.OK, "OK", data);
	}

	public ResponseVo(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public ResponseVo(int code, String message, Object data) {
		this.code = code;
		this.message = message;
		this.data = data;
	}

}
