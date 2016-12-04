package algorithm;
/**
 * @author Allen Lin
 * @date 2016-8-17
 * @desc 回溯法，复杂度O(n*n^2)。用动态规划更好，O(n*C)，C为背包容量
 */
public class HuiShuo {
	static int n;// 物品数量
	static int w[], v[];// 物品的重量，价值
	static int s;// 包的容量
	static int x[];// 暂时选中情况
	static int bestx[];// 最好的选中情况
	static int maxv;// 最大的价值

	public static void main(String[] arg) {
		n = 4;
		w = new int[] { 0, 7, 3, 4, 5 };
		v = new int[] { 0, 42, 12, 40, 25 };
		s = 10;
		x = new int[n + 1];
		bestx = new int[n + 1];
		backTrack(1, 0, 0);
		for (int j = 1; j <= n; j++) {
			if (bestx[j] == 1) {
				System.out.println(v[j] + " ");
			}
		}
		System.out.println("maxv" + maxv);
	}

	private static void backTrack(int i, int cv, int cw) {
		if (i > n) {
			if (cv > maxv) {
				maxv = cv;
				for (int j = 1; j <= n; j++) {
					bestx[j] = x[j];
				}
			}
		} else {
			// 左子树
			if (cw + w[i] <= s) {
				x[i] = 1;
				cw += w[i];
				cv += v[i];
				backTrack(i + 1, cv, cw);
				cw -= w[i];
				cv -= v[i];
			}
			// 右子树
			if (bound(i + 1, cv, cw) > maxv) {
				x[i] = 0;
				backTrack(i + 1, cv, cw);
			}
		}
	}

	// 上界函数
	private static int bound(int i, int cv, int cw) {

		int b = cv;
		int left_w = s - cw;
		while (i <= n && left_w >= w[i]) {
			left_w -= w[i];
			b += v[i];
			i++;
		}
		// 装满背包
		if (i <= n) {
			b += v[i] / w[i] * left_w;
		}
		return b;
	}
}
