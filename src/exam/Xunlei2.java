package exam;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Xunlei2 {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		List<String> list = new ArrayList<String>();
		String str = "";

		while (in.hasNextLine()) {
			String str2 = in.nextLine();
			if (str2.length() != 0) {
				// System.out.println(str2);
				str = str + str2;
			} else {
				break;
			}
		}

		if (!str.contains("thunder://")) {
			System.out.print("no");
			return;
		}
		while (true) {

			int i = str.indexOf("<a href=\"thunder://");
			if (i >= 0) {
				// System.out.println(i);
				String temp = str.substring(i, str.indexOf("</a>"));
				if (!list.contains(temp.substring(9, str.indexOf("/\">")))) {
					list.add(temp.substring(9, str.indexOf("/\">")));
				}
				str = str.substring(str.indexOf("</a>" + 3));
			} else {
				break;
			}

		}
		System.out.println(list.size());
		for (String s : list) {
			System.out.println(s);
		}
	}
}
