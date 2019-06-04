package xingkong.tool.fake;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BirthdayTool {
	/**
	 * 随机生成出生日期
	 * 不带参数的话，从1960年算起，到目前60年
	 * @return
	 */
	public static String gen() {
		return BirthdayTool.gen(1950, 60);
	}
	
	public static String gen(int start, int num) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, start + (int) (Math.random() * num) );
		calendar.set(Calendar.MONTH, (int) (Math.random() * 12));
		calendar.set(Calendar.DATE,  (int) (Math.random() * 31));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date birthDay = calendar.getTime();
		return sdf.format(birthDay);
	}
	
	public static void main(String[] args) {
		for(int i=0; i<10; i++)
		{
			log.info(BirthdayTool.gen());
		}
	}
}
