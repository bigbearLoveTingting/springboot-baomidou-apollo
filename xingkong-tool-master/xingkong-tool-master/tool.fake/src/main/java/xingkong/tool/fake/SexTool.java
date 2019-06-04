package xingkong.tool.fake;

public class SexTool {
	/**
	 * 生成性别
	 * 
	 * @return
	 */
	public static int genSex() {
		int sex = (int) (Math.random() * 2);
		return sex;
	}
}
