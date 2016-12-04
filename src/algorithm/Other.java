package algorithm;
/**
 * @author Allen Lin
 * @date 2016-8-16
 * @desc
 */
public class Other {
	public static void main(String[] args) {
		String str1 = "111";
		String str2 = "11";
		multiply(str1, str2);
	}

	/**
	 * 大整数乘法(复杂度：O(m*n))
	 * 
	 * @param str1
	 * @param str2
	 */
	public static void multiply(String str1, String str2) {
		char[] c1 = str1.toCharArray();
		char[] c2 = str2.toCharArray();
		int m = str1.length();
		int n = str2.length();
		int array[] = new int[m + n];// 两数乘积位数不会超过两数的位数之和
		// 高低位对调,为了低位对齐
		covert(c1);
		covert(c2);

		// 对齐逐位相乘
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++) {
				array[i + j] = array[i + j] + Integer.parseInt(c1[i] + "")
						* Integer.parseInt(String.valueOf(c2[j]));
			}

		// 进位
		for (int i = 0; i < m + n; i++) {
			int temp = array[i] / 10;
			if (temp > 0) {
				array[i] = array[i] % 10;
				array[i + 1] += temp;
			}
		}
		String res = "";
		for (int i = m + n - 1; i >= 0; i--) {
			res = res + array[i];
		}
		// 删除结果前面的0
		int i = 0;
		while (res.charAt(i) == '0') {
			i++;
		}
		System.out.print(res.substring(i));
	}

	public static void covert(char[] c) {
		for (int i = 0; i < c.length / 2; i++) {
			char temp = c[i];
			c[i] = c[c.length - 1 - i];
			c[c.length - 1 - i] = temp;
		}
	}
}
