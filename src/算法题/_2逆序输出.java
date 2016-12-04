package 算法题;

import java.util.Scanner;

/**
 * @author Allen Lin
 * @date 2016-8-25
 * @desc 描述： 输入一个整数，将这个整数以字符串的形式逆序输出 程序不考虑负数的情况，若数字含有0，则逆序形式也含有0，如输入为100，则输出为001
 */
public class _2逆序输出 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNextInt()) {
			String str = in.nextLine();
			StringBuffer sb = new StringBuffer();
			for (int i = str.length() - 1; i >= 0; i--) {
				sb.append(str.charAt(i));
			}
			System.out.print(sb.toString());
		}
	}
}
