package exam;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class wangyi3 {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		String str = in.nextLine();

		// for (int i = 0; i < str.length(); i++) {
		//
		// }
		int n = str.length();
		Set<String> set = new HashSet<String>();
		for (int i = 0; i < n; i++) {
			for (int j = 2; i + j - 1 < n; j += 2) {

				int left = i, right = i + j / 2;
				boolean f = true;
				for (int k = 0; k < j / 2; k++) {
					if (str.charAt(left + k) != str.charAt(right + k)) {
						f = false;
						break;
					}
				}
				if (f) {
					set.add(str.substring(i, j));
				}
			}
		}
		System.out.println(set.size());
	}
}
