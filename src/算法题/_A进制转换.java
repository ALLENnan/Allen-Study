package 算法题;

import java.util.Scanner;

/**
 * @author Allen Lin
 * @date 2016-8-25
 * @desc 写出一个程序，接受一个十六进制的数值字符串，输出该数值的十进制字符串。（多组同时输入 ）
 */
public class _A进制转换 {

	public static void main(String[] args) {
		// 先不考虑大数 = =
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String str = sc.nextLine().substring(2);
			System.out.println(Integer.parseInt(str, 16));
		}
	}
}
