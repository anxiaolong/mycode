package java_02_oop;
/**
 * 字符串常用操作方法
 * @author Administrator
 *
 */
public class TestString2 {
	public static void main(String[] args) {
		String s = "anxiaolong";
		String s1 = "Anxiaolong";
		String s2 = "an xiaolong";
		System.out.println(s.charAt(3)); //s[3]是什么字母
		System.out.println(s.length()); //计算字符串长度，不是从0开始计数
		System.out.println(s.equals(s1));
		System.out.println(s.equals(s2)); //比较两个字符串是否相同
		System.out.println(s.equalsIgnoreCase(s1)); //互虐大小写进行比较
		System.out.println(s.indexOf("an")); //包含字符串为0，不包含-1
		System.out.println(s.indexOf('w')); //包含字符判断方法，返回值0或-1
		String s3 = s2.replace(' ', '&'); //字符替换	
		System.out.println(s3);
		System.out.println(s.startsWith("an")); //是否以an开头
		System.out.println(s.endsWith("long")); //是否以long结尾
		System.out.println(s.substring(3)); //从s[3]开始到结尾，提取字符串
		System.out.println(s.substring(3, 5)); //提取s[4]-s[4]字符串
		System.out.println(s1.toLowerCase()); //全部转小写
		System.out.println(s1.toUpperCase()); //全部转大写
		String s4 = "  an xiao long  ";
		System.out.println(s4.trim()); //去除字符串前后空格
		System.out.println(s4); //字符串这些方法本质上不会改变定义的好的字符串，字符串不可改变
		
		
	}
}	
