package exam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main4 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		List<Integer> list = new ArrayList<Integer>();
		String str = in.nextLine();

		String[] res = str.split(",");
		for (String s : res) {
			list.add(Integer.parseInt(s));
		}

		int firstBuy = Integer.MIN_VALUE, firstSell = 0;

		for (int curPrice : list) {
			firstBuy = Math.max(firstBuy, -curPrice);
			firstSell = Math.max(firstSell, firstBuy + curPrice);
		}

		System.out.println(firstSell);
	}
}
