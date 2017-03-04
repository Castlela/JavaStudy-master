package day16.SE_API_String;
/**
 * int indexOf(String str)
 * 该方法使用来查找指定字符串在当前字符中的位置，
 * 该就去有几个重载方法。
 * @author 冼嘉辉Castle
 *
 */
public class String_indexOf {
	public static void main(String[] args) {
		//            0123456789012345
		String str = "thinking in java"; //这是一本书名
		
		int index = str.indexOf("In"); //找不到，返回 -1
		System.out.println("index:"+index);
	}

}
