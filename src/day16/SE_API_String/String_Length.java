package day16.SE_API_String;
/**
 * int length()
 * 获取字符串长度
 * 无论中文还是英文每个字符都是一个长度
 * @author 冼嘉辉Castle
 *
 */
public class String_Length {

	public static void main(String[] args) {
		String str = "I love Java!";
		System.out.println(str.length()); //字符串的长度
		
		
//--------------------------------------------------------------------
//---以下为String在内存中的占用情况。		
		String s1 = "123abc"; //s1和s2的地址是一样的，字符串重用
		String s2 = "123abc"; 
		String s3 = new String("123abc");
		//System.out.println(s1==s2); //true
		//System.out.println(s1==s3); //false
		//System.out.println(s1.equals(s3)); //true
		
		s1=s1+"!"; //创建新对象
		//System.out.println(s1); //123abc!
		//System.out.println(s2); //123abc
		//System.out.println(s1==s2); //false
		
		String s4 = "123"+"abc"; //JVM让两个字符字面量相加后成123abc再编译为CLASS文件。
		//System.out.println(s4==s2); //true
		
		String str1 = "123";
		String str2 = "abc";
		String s5 = str1 + str2;
		//System.out.println(s5==s2); //fasle

	}

}
