package 公司真题;


/**
 * 个int32整数m和n的二进制表达，有多少个位(bit)不同？
 */
public class 二进制 {

	/**
	 * 获得两个整形二进制表达位数不同的数量
	 * 
	 * @param m
	 *            整数m
	 * @param n
	 *            整数n
	 * @return 整型
	 */
	public int countBitDiff(int m, int n) {
		int diff = m ^ n;
		int count = 0;
		while (diff != 0) {
			diff = diff & (diff - 1);
			count++;
		}
		return count;
	}

}
