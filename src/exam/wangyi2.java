package exam;

import java.util.Scanner;

public class wangyi2 {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();		
		int k = n;
		int count = 0;
		// 忽略0
		while ((k & 0x01) == 0) {
			k = k >> 1;
			count++;
		}
		// 遇见1则右移一位，直到遇见0
		while ((k & 0x01) == 1) {
			k = k >> 1;
			count++;
		}

		// 0置1
		int temp = 1 << (count);
		n = n | temp;
		// 1置0
		int temp2 = ~(1 << (count - 1));
		n = n & temp2;
		System.out.println(n);
	}
}
