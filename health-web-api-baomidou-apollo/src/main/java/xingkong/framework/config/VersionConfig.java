package xingkong.framework.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 
 * @author xingkong
 *
 */
@Component
@ConfigurationProperties(prefix = "version")
public class VersionConfig {

	private String base;

	// 版本号
	private String svnid;

	// 打包时间
	private String time;

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public String getSvnid() {
		return svnid;
	}

	public void setSvnid(String svnid) {
		this.svnid = svnid;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}
