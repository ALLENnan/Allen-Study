package exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class M {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int x = in.nextInt();
		int n = in.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = in.nextInt();
		}
		int res = binSearch(arr, x, 0, arr.length - 1);
		System.out.println(res);
	}

	public static int binSearch(int array[], int tar, int low, int high) {
		if (low > high) {
			return (-1 - low);
		}
		int mid = (low + high) / 2;
		if (array[mid] == tar) {
			return mid;
		} else if (array[mid] > tar) {
			return binSearch(array, tar, low, mid - 1);
		} else {
			return binSearch(array, tar, mid + 1, high);
		}
	}
}
