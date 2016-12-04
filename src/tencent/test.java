package tencent;

import java.util.Scanner;

public class test {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int[] arr = new int[32];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = 0;
		}
		while (in.hasNextInt()) {
			int n1 = in.nextInt();
			int n2 = in.nextInt();
			// 赋值
			int temp = 1 << (n1 % 32);
			arr[n1 / 32 - 1] = arr[n1 / 32 - 1] | temp;
			// 取值
			if (n2 < 1 || n2 > 1024) {
				System.out.print(-1);
			} else {
				int bit = arr[n2 / 32 - 1] >> (n2 % 32);
				if ((bit & 0x01) == 1) {
					System.out.print(1);
				} else {
					System.out.print(0);
				}
			}
		}
	}
}
