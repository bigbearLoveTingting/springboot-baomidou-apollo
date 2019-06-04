package xingkong.framework.exception;

/**
 * 
 * @author xingkong
 *
 */
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.SearchStrategy;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import xingkong.tool.core.JsonTool;
import xingkong.tool.core.ResponseTool;
import xingkong.tool.core.ServeletTool;
@Slf4j
public class BaseHttpErrorHandler extends BasicErrorController {


	public BaseHttpErrorHandler(ErrorAttributes errorAttributes, ErrorProperties errorProperties, List<ErrorViewResolver> errorViewResolvers) {
		super(errorAttributes, errorProperties, errorViewResolvers);
	}

	@Override
	public ModelAndView errorHtml(HttpServletRequest request, HttpServletResponse response) {
		HttpStatus status = getStatus(request);
		Map<String, Object> model = Collections.unmodifiableMap(getErrorAttributes(request, isIncludeStackTrace(request, MediaType.TEXT_HTML)));
		String path = (String) model.get("path");

		// 判断是否是ajax请求
		if (ServeletTool.isAjax(request, path)) {

			String content = JsonTool.toJSONString(ResponseTool.error("not find " + path));
			ServeletTool.writeJson(response, content);
			return null;
		}

		// 如果不是ajax请求，显示相关信息
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("timestamp", model.get("timestamp"));
		modelAndView.addObject("status", model.get("status"));
		modelAndView.addObject("error", model.get("error"));
		modelAndView.addObject("message", model.get("message"));
		modelAndView.addObject("path", model.get("path"));

		modelAndView.setViewName("error/404");
		return modelAndView;
	}
}
