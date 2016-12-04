package exam;

import java.util.Scanner;

public class Main6 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int j;
		int count = 0;
		for (int i = 1; i <= n; i++) {
			j = i;
			while (j % 5 == 0) {
				count++;
				j = j / 5;
			}
		}
		System.out.println(count);
	}

}
