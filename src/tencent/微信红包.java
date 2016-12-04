package tencent;

import java.util.Arrays;

/**
 * 春节期间小明使用微信收到很多个红包，非常开心。在查看领取红包记录时发现，某个红包金额出现的次数超过了红包总数的一半。请帮小明找到该红包金额。
 * 写出具体算法思路和代码实现，要求算法尽可能高效。 给定一个红包的金额数组gifts及它的大小n，请返回所求红包的金额。
 * 
 * 若没有金额超过总数的一半，返回0。
 * 
 * 测试样例： [1,2,3,2,2],5 返回：2
 * 
 * 
 */
public class 微信红包 {

	public int getValue(int[] gifts, int n) {
		Arrays.sort(gifts);
		int count = 0;
		for (int i = 0; i < gifts.length; i++) {
			if (gifts[i] == gifts[n / 2]) {
				count++;
			}
		}
		if (count >= (n / 2)) {
			return gifts[n / 2];
		}
		return 0;
	}
}
