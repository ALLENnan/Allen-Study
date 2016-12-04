package tencent;

import java.util.Scanner;

public class 逆序打印 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		String temp = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			if (str.charAt(i) == ' ') {
				System.out.print(temp + " ");
				temp = "";
			} else {
				temp = str.charAt(i) + temp;
			}
			if (i == 0) {
				System.out.print(temp);
			}
		}
	}
}
