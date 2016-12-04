package exam;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

class LRUCache<K, V> extends LinkedHashMap<K, V> {

	private int cacheSize;

	public LRUCache(int cacheSize) {
		super(16, 0.75f, true);
		this.cacheSize = cacheSize;
	}

	protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
		return size() > cacheSize;
	}
}

public class Xunlei1 {

	static LRUCache<Integer, Integer> cache;

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		cache = new LRUCache<>(n);
		while (in.hasNext()) {
			String str = in.nextLine();
			if (str.length() != 0) {
				String[] res = str.split(" ");
				// System.out.println("ce:" + str);
				if (res.length == 2) {
					// System.out.println("ce:" + Integer.parseInt(res[0]) + " "
					// + Integer.parseInt(res[1]));
					cache.put(Integer.parseInt(res[0]),
							Integer.parseInt(res[1]));
				} else {
					if (cache.get(Integer.parseInt(res[0])) != null) {
						System.out.println(cache.get(Integer.parseInt(res[0])));
					} else {
						System.out.println(-1);
					}

				}
			}

		}

	}
}
