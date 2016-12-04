package exam;

import java.util.Scanner;

public class temp {

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
		//
		// for (int i = 0; i < n; i++) {
		// for (int j = 0; j < m; j++) {
		// System.out.println(arr[i][j]);
		// }
		// }
		boolean flag = false;
		int i = 0;
		int j = 0;
		while (p > 0) {
			if (i < m - 1 && arr[i + 1][j] == 1) {
				visited[i][j] = 1;
				p = p - 1;
				i++;
			} else if (j >= 1 && visited[i][j - 1] == 0 && arr[i][j - 1] == 1) {
				visited[i][j] = 1;
				j--;
				p = p - 3;
			} else if (j < n - 1 && visited[i][j + 1] == 1) {
				visited[i][j] = 1;
				j++;
			} else {
				flag = true;
				break;

			}
			if (i == 0 && j == m - 1) {
				break;
			}

		}
		if (flag || p < 0) {
			System.out.println("Can not escape!");
		} else {
			for (int i2 = 0; i2 < n; i2++) {
				for (int j2 = 0; j2 < m; j2++) {
					if (visited[i2][j2] == 1) {
						System.out.println(i2 + "," + j2);
					}
				}
			}
		}
	}
}
