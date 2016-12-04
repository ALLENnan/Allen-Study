package exam;

import java.util.Scanner;

public class Main3 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();// n个顶点
		int weight[][] = new int[n][n];

		for (int i = 0; i < n; i++) {
			String str = in.nextLine();
			String[] res = str.split(",");
			for (int j = 0; j < n; j++) {
				System.out.println(res[j]);
				weight[i][j] = Integer.parseInt(res[j]);
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.println(weight[i][j]);
			}
		}
		// int[] shortPath = Dijsktra(weight, 0);
		//
		// // for (int i = 0; i < shortPath.length; i++)
		// System.out.println(+shortPath[shortPath.length - 1]);

	}

	public static int[] Dijsktra(int[][] weight, int start) {
		int n = weight.length;
		int[] shortPath = new int[n];
		String[] path = new String[n];
		for (int i = 0; i < n; i++)
			path[i] = new String(start + "-->" + i);
		int[] visited = new int[n];

		shortPath[start] = 0;
		visited[start] = 1;

		for (int count = 1; count <= n - 1; count++) // 要加入n-1个顶点
		{

			int k = -1;
			int dmin = Integer.MAX_VALUE;
			for (int i = 0; i < n; i++) {
				if (visited[i] == 0 && weight[start][i] < dmin
						&& weight[start][i] != 0) {
					dmin = weight[start][i];
					k = i;
				}

			}
			shortPath[k] = dmin;
			visited[k] = 1;
			// 以k为中间点，修正从start到未访问各点的距离
			for (int i = 0; i < n; i++) {
				if (visited[i] == 0
						&& weight[start][k] + weight[k][i] < weight[start][i]) {
					weight[start][i] = weight[start][k] + weight[k][i];
					path[i] = path[k] + "-->" + i;
				}

			}

		}
		// for (int i = 0; i < n; i++)
		// System.out.println("从" + start + "出发到" + i + "的最短路径为：" + path[i]);
		// System.out.println("=====================================");

		return shortPath;
	}

}
