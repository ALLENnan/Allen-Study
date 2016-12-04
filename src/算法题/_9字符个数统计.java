package 算法题;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Allen Lin
 * @date 2016-8-25
 * @desc 编写一个函数，计算字符串中含有的不同字符的个数。字符在ACSII码范围内(0~127)。不在范围内的不作统计 输入描述:
 *       输入N个字符，字符在ACSII码范围内(0~127)。
 * 
 *       输出描述: 输出字符的个数。
 * 
 *       输入例子: abc 输出例子: 3
 */
public class _9字符个数统计 {
	// 使用set或者数组实现
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		char[] chars = str.toCharArray();
		Set<Character> set = new HashSet<Character>();
		for (char c : chars) {
			set.add(c);
		}
		System.out.print(set.size());
	}

	// public static void main(String[] args) {
	// Scanner sc = new Scanner(System.in);
	// String str = sc.nextLine();
	// int count = 0;
	// int[] tab = new int[128];
	// for (int i = 0; i < str.length(); i++) {
	// if (tab[str.charAt(i)] == 0)
	// tab[str.charAt(i)]++;
	// }
	// for (int i = 0; i < tab.length; i++) {
	// if (tab[i] != 0)
	// count++;
	// }
	// System.out.println(count);
	// }
}
