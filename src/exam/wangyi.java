package exam;

import java.util.Scanner;

public class wangyi {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		String str = in.next();
		int sum = 0;
		for (int i = 0; i < str.length(); i++) {
			sum = sum + Integer.parseInt(str.charAt(i) + "");
		}
		int min = Integer.MAX_VALUE;
		int res = 0;
		for (int i = a; i <= b; i++) {
			String s = i + "";
			int temp = 0;
			for (int j = 0; j < s.length(); j++) {
				temp = temp + Integer.parseInt(s.charAt(j) + "");
			}
			if (Math.abs(temp - sum) < min) {
				min = Math.abs(temp - sum);
				res = i;
			}
		}
		System.out.println(res);

	}
}
