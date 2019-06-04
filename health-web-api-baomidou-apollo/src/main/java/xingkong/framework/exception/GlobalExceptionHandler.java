package xingkong.framework.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.session.ExpiredSessionException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;
import xingkong.tool.core.JsonTool;
import xingkong.tool.core.ResponseTool;
import xingkong.tool.core.ServeletTool;
import xingkong.tool.core.StatckTool;
import xingkong.tool.core.web.vo.ResponseVo;

/**
 * 
 * @author xingkong
 *
 */
@Slf4j
@ControllerAdvice
@Order(value = Ordered.HIGHEST_PRECEDENCE)
public class GlobalExceptionHandler {

	@ExceptionHandler(value = AuthorizationException.class)
	@ResponseBody
	public ResponseVo handleAuthorizationException() {
		return ResponseTool.error("暂无权限，请联系管理员!", "权限异常");
	}

	@ExceptionHandler(value = ExpiredSessionException.class)
	public String handleExpiredSessionException() {
		return "login";
	}

	/**
	 * Validate校验出错统一返回
	 * 
	 * @param e
	 * @param response
	 * @return
	 */
	@ExceptionHandler(BindException.class)
	@ResponseBody
	public ResponseVo constraintExceptionHandler(BindException e, HttpServletResponse response) {
		BindingResult validateResult = e.getBindingResult();
		List<FieldError> fieldErrors = validateResult.getFieldErrors();
		Map<String, String> errorList = new HashMap<>();
		for (int i = 0; i < fieldErrors.size(); i++) {
			// 返回验证出错的信息
			errorList.put(fieldErrors.get(i).getField(), fieldErrors.get(i).getDefaultMessage());
		}
		response.setStatus(500);
		return new ResponseVo(errorList);
	}

	@ExceptionHandler(Exception.class)
	public ModelAndView errorHandler(HttpServletRequest request,HttpServletResponse response, Exception e)  {
		String requestPath = request.getRequestURL().toString();
		if (ServeletTool.isAjax(request, requestPath)) {

			String content = JsonTool.toJSONString(ResponseTool.error(e.getMessage(), StatckTool.toStringFirstLine(e)), true);
			ServeletTool.writeJson(response, content);
			return null;
		}
		ModelAndView mav = new ModelAndView();
		mav.addObject("message", e.getMessage());
		mav.addObject("trace", StatckTool.toString(e));
		mav.setViewName("error/500");
		return mav;
	}

}
