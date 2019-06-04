package xingkong.tool.core;

import xingkong.tool.core.web.vo.ResponseVo;

/**
 * 通用WEB项目返回响应Vo工具类
 * 
 * @author 星空
 */
public class ResponseTool {
	public static ResponseVo error(String message) {
		return new ResponseVo(ResponseVo.ERROR, message);
	}
	
	public static ResponseVo error(String message, String log) {
		return new ResponseVo(ResponseVo.ERROR, message, log);
	}

	public static ResponseVo success() {
		return new ResponseVo(ResponseVo.OK, "OK");
	}

	public static  ResponseVo success(Object data) {
		return new ResponseVo(ResponseVo.OK, "OK", data);
	}
	
	public static  ResponseVo success(Object data, String message) {
		return new ResponseVo(ResponseVo.OK, message, data);
	}
}
