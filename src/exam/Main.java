package exam;

import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		while (n != 0) {
			n--;
			int num = in.nextInt();
			int res = 0;
			for (int i = 0; i < num; i++) {
				int temp = in.nextInt();
				res = res ^ temp;
			}
			for (int i = 0; i < num - 1; i++) {
				int temp = in.nextInt();
				res = res ^ temp;
			}
			System.out.println(res);
		}
	}
}