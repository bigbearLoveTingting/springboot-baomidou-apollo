package xingkong.framework.beetl;

import javax.servlet.http.HttpServletRequest;

import org.beetl.core.Context;
import org.beetl.core.Function;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.support.RequestContextUtils;

public class BeetlI18n implements Function {

	private final static Logger log = LoggerFactory.getLogger(BeetlI18n.class);

	@Override
	public Object call(Object[] obj, Context context) {
		HttpServletRequest request = (HttpServletRequest) context.getGlobal("request");

		ApplicationContext ctx = RequestContextUtils.findWebApplicationContext(request);
		Object[] arg = null;
		if (obj[0] != null) {
			return ctx.getMessage((String) obj[0], arg, RequestContextUtils.getLocale(request));
		} else {
			return "";
		}
	}

}
