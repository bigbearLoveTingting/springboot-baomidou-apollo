package xingkong.framework.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@ConfigurationProperties(prefix="weixin")
@Data
public class WexinConfig {
	private String appid ="wx1c6ac7202457dbe2";
	private String appSecret ="af1602d2f48684783a9ea7903059f1ef";
	private String token = "KEEP";
	private String redirectUrl = "http://cc.knooc.com/wx.logincallback";
}
