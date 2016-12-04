package 笔试;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class 采购单 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int n = in.nextInt();
			int m = in.nextInt();
			int[] array = new int[n];
			for (int i = 0; i < n; i++) {
				array[i] = in.nextInt();
			}
			Map<String, Integer> map = new TreeMap<String, Integer>();
			for (int i = 0; i < m; i++) {
				String str = in.next();
				if (map.containsKey(str)) {
					map.put(str, 1 + map.get(str));
				} else {
					map.put(str, 1);
				}
			}

			// 这里将map.entrySet()转换成list
			List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(
					map.entrySet());
			// 然后通过比较器来实现排序
			Collections.sort(list,
					new Comparator<Map.Entry<String, Integer>>() {
						// 升序排序
						public int compare(Entry<String, Integer> o1,
								Entry<String, Integer> o2) {
							return o1.getValue().compareTo(o2.getValue());
						}

					});

			// for (Map.Entry entry : map.entrySet()) {
			// System.out.println(entry.getValue());
			// }
			Arrays.sort(array);
			int min = 0, max = 0;
			int k = map.size() - 1;
			for (Map.Entry entry : list) {
				int value = (Integer) entry.getValue();
				min = min + array[k] * value;
				k--;
			}
			int k2 = n - map.size();
			for (Map.Entry entry : list) {
				int value = (Integer) entry.getValue();

				max = max + array[k2] * value;
				// System.out.println(array[k2] + "* " + value);
				k2++;
			}
			System.out.println(min + " " + max);
		}
	}
}


