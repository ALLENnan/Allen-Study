package algorithm;

import java.util.Stack;

/**
 * @author Allen Lin
 * @date 2016-8-14
 * @desc 动态规划(最优子结构)
 */
public class Dp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int data[] = { 5, 6, 7, 1, 2, 8 };
		int data2[][] = { { 5, 0 }, { 1, 2 } };
		// System.out.print(LIS(data));
		System.out.print(minPath(data2));
	}

	/**
	 * 01背包
	 * 
	 * @param v
	 * @param w
	 * @param W
	 * @return
	 */
	public static int knapsack(int v[], int w[], int W) {
		int row = v.length;
		int c[][] = new int[row + 1][W + 1];// c[i][j]选择前i个物品放入质量为j的背包的最大价值
		for (int i = 0; i <= row; i++) {
			c[i][0] = 0;
		}
		for (int i = 0; i <= W; i++) {
			c[0][i] = 0;
		}
		for (int i = 1; i <= row; i++) {
			for (int j = 1; j <= W; j++) {
				if (w[i] > j) {
					c[i][j] = c[i - 1][j];
				} else {
					c[i][j] = c[i - 1][j] > v[i] + c[i - 1][j - w[i]] ? c[i - 1][j]
							: v[i] + c[i - 1][j - w[i]];
				}
			}
		}
		return c[row][W];
	}

	/**
	 * 格子取数/走棋盘问题
	 * 问题描述：给定一个m*n的矩阵，每个位置是一个非负整数，从左上角开始放一个机器人，它每次只能朝右和下走，走到右下角，求机器人的所有路径中
	 * ，总和最小的那条路径
	 * 
	 * @param array
	 *            原始棋盘数组
	 * @return 最小总和
	 */
	public static int minPath(int[][] array) {
		if (array == null || array.length == 0) {
			return 0;
		}
		int row = array.length;
		int col = array[0].length;
		int[][] dp = new int[row][col];
		dp[0][0] = array[0][0];
		for (int i = 1; i < row; i++) {
			dp[i][0] = dp[i - 1][0] + array[i][0];
		}
		for (int i = 1; i < col; i++) {
			dp[0][i] = dp[0][i - 1] + array[0][i];
		}
		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				dp[i][j] = (dp[i - 1][j] < dp[i][j - 1] ? dp[i - 1][j]
						: dp[i][j - 1]) + array[i][j];
			}
		}
		return dp[row - 1][col - 1];
	}

	/**
	 * 最长单调递增子序列
	 * 问题描述：给定长度为N的数组A，计算A的最长单调递增的子序列（不一定连续）。如给定数组A{5，6，7，1，2，8}，则A的LIS为
	 * {5，6，7，8}，长度为4.
	 * 
	 * @param array
	 *            原始序列
	 * @return 最大长度
	 */
	public static int LIS(int array[]) {

		if (array == null || array.length == 0) {
			return 0;
		}
		int len = array.length;
		int b[] = new int[len];// b[i]表示以下标i元素结束的 最长单调递增子序列的长度
		Stack<Integer> stack = new Stack<Integer>();
		int pre[] = new int[len]; // 前驱元素数组，记录当前以该元素作为最大元素的递增序列中该元素的前驱节点，用于打印序列用
		for (int i = 0; i < len; i++) {
			pre[i] = i;
		}

		int maxLen = 1;
		int index = 0;
		b[0] = 1;
		for (int i = 1; i < len; i++) {
			int max = 0;
			for (int j = 0; j < i; j++) {
				if (array[j] < array[i] && max < b[j]) {
					max = b[j];
					pre[i] = j;
				}
			}
			b[i] = max + 1;
			// 得到当前最长递增子序列的长度，以及该子序列的最末元素的位置
			if (maxLen < b[i]) {
				maxLen = b[i];
				index = i;
			}
		}
		// 输出序列
		while (pre[index] != index) {
			stack.add(array[index]);
			index = pre[index];
		}
		stack.add(array[index]);
		while (!stack.empty()) {
			System.out.println("s=" + stack.pop());
		}
		return maxLen;
	}
}
