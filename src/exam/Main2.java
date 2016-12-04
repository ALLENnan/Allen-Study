package exam;

import java.util.Scanner;

public class Main2 {
	public static void func(int len, int arr[]) {
		if (arr.length <= 0)
			return;
		int min = 0;
		int max = 0;
		int temp1, temp2;
		for (int i = 0; i < arr.length; i++) {
			int temp = len - arr[i];
			if (arr[i] <= temp) {
				temp1 = arr[i];
				temp2 = len - arr[i];
			} else {
				temp1 = len - arr[i];
				temp2 = arr[i];
			}
			if (max < temp2) {
				max = temp2;
			}
			if (min < temp1) {
				min = temp1;
			}

		}
		System.out.println(min + " " + max);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		while (n != 0) {
			n--;
			int len = in.nextInt();
			int num = in.nextInt();
			int arr[] = new int[num];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = in.nextInt();
			}
			func(len, arr);
		}
	}
}