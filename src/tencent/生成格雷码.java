package tencent;

import java.util.*;

/**
 * 在一组数的编码中，若任意两个相邻的代码只有一位二进制数不同， 则称这种编码为格雷码(Gray Code)，请编写一个函数，使用递归的方法生成N位的格雷码。
 * 给定一个整数n，请返回n位的格雷码，顺序为从0开始。 测试样例： 1 返回：["0","1"]
 * 
 * 1:0 1
 * 
 * 2:00 01 11 10
 * 
 * 3:000 001 011 010 110 111 101 100
 */
public class 生成格雷码 {

	public static void main(String[] args) {
		String[] str = getGray(3);
		for (int i = 0; i < str.length; i++) {
			System.out.println(str[i]);
		}
	}

	public static String[] getGray(int n) {

		if (n == 1) {
			return new String[] { "0", "1" };
		}
		String[] str = getGray(n - 1);

		int len = str.length;
		String[] res = new String[len * 2];

		for (int i = 0; i < len * 2; i++) {

			if (i >= len) {
				res[i] = "1" + str[len - 1 - (i - len)];
			} else {
				res[i] = "0" + str[i];
			}
		}
		return res;

		// write code here
	}
}
