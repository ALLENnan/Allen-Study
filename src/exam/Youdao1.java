package exam;

import java.util.Scanner;

public class Youdao1 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		// while (in.hasNextInt()) {
		int n = in.nextInt();
		int a = in.nextInt();
		int b = in.nextInt();
		int[] arr = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			arr[i] = in.nextInt();
		}

		for (int i = 2; i < n;) {
			while (arr[i] > 0) {
				arr[i] -= a;
				arr[i - 1] -= b;
				arr[i + 1] -= b;
			}
			System.out.println(i);
			if (i + 2 < n - 1) {
				i += 2;
			} else if (i + 2 == n - 1) {
				i = i + 1;
				System.out.println(i);
				while (arr[i + 1] > 0) {
					arr[i] -= a;
					arr[i - 1] -= b;
					arr[i + 1] -= b;
				}
				break;
			} else if (i + 2 > n - 1) {

				while (arr[i + 1] > 0) {
					arr[i] -= a;
					arr[i - 1] -= b;
					arr[i + 1] -= b;
				}
				break;
			}
		}

	}
}
