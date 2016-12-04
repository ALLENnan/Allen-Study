package algorithm;

public class Search {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] data2 = { 1, 2, 3, 4, 5, 5, 6 };
		int tar = 2;
		// System.out.print(binSearch(data2, tar));
		System.out.print(binSearch(data2, tar, 0, data2.length - 1));
	}

	/**
	 * 二分查找 非递归
	 * 
	 * @param array
	 * @param tar
	 * @return
	 */
	public static int binSearch(int array[], int tar) {
		int len = array.length;
		int low = 0;
		int high = len - 1;
		while (low <= high) {

			int mid = (low + high) / 2;
			if (array[mid] == tar) {
				return mid;
			} else if (array[mid] > tar) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}

	/**
	 * 二分查找 递归
	 * 
	 * @param array
	 * @param tar
	 * @param low
	 * @param high
	 * @return
	 */
	public static int binSearch(int array[], int tar, int low, int high) {
		if (low > high) {
			return -1;
		}
		int mid = (low + high) / 2;
		if (array[mid] == tar) {
			return mid;
		} else if (array[mid] > tar) {
			return binSearch(array, tar, low, mid - 1);
		} else {
			return binSearch(array, tar, mid + 1, high);
		}
	}

}
