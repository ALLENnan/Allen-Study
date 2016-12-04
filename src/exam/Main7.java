package exam;

import java.util.Scanner;

public class Main7 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int p = in.nextInt();
		int arr[][] = new int[n][m];
		int visited[][] = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = in.nextInt();
			}
		}
		boolean flag = false;
		int i = 0;
		int j = 0;
		String res = "";
		while (p > 0) {
			if (j < m - 1 && arr[i][j + 1] == 1) {
				visited[i][j] = 1;
				res = res + "[" + i + "," + j + "]" + ",";
				p = p - 1;
				j++;
				// System.out.println("you");
			} else if (i >= 1 && visited[i - 1][j] == 0 && arr[i - 1][j] == 1) {
				visited[i][j] = 1;
				res = res + "[" + i + "," + j + "]" + ",";
				i--;
				p = p - 3;
				// System.out.println("shang");
			} else if (i < n - 1) {
				visited[i][j] = 1;
				res = res + "[" + i + "," + j + "]" + ",";
				i++;
				// System.out.println("下");
			} else {
				flag = true;
				break;

			}
			// System.out.println(i + "+" + j);
			if (i == 0 && j == m - 1) {
				break;
			}

		}
		if (flag || p < 0) {
			System.out.println("Can not escape!");
		} else {
			// for (int i2 = 0; i2 < n; i2++) {
			// for (int j2 = 0; j2 < m; j2++) {
			// if (visited[i2][j2] == 1) {
			// res = res + "[" + i + "," + j + "]" + ",";
			// }
			// }
			// }
			res = res + "[" + "0" + "," + (m-1) + "]";
			System.out.println(res);
		}
	}
}
