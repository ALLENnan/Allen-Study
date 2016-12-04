package 算法题;

/**
 * @author Allen Lin
 * @date 2016-8-25
 * @desc 请实现一个函数，将一个字符串中的空格替换成“%20”。 例如，当 字符串为We Are
 *       Happy.则经过替换之后的字符串为We%20Are%20Happy
 */

public class _0替换空格 {

	// public static void main(String[] args) {
	// StringBuffer string = new StringBuffer("We Are Happy");
	// System.out.print(replaceSpace(string));
	//
	// }

	public static String replaceSpace(StringBuffer str) {
		return str.toString().replaceAll(" ", "%20");
	}

}
