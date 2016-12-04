package algorithm;

/**
 * @author Allen Lin
 * @date 2016-8-12
 * @desc
 */
public class Sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int data[] = { 3, 6, 24, -1, 3, 2, 8, -8, 12, 9 };
		System.out.print("排序前： ");
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i] + " ");
		}
		// bubbleSort(data);
		// heapSort(data);
		// quickSort(data, 0, data.length - 1);
		selectSort(data);
		System.out.println("");
		System.out.print("排序后： ");
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i] + " ");
		}
	}

	/**
	 * 插入排序
	 * 
	 * @param arr
	 */
	public static void insertSort(int arr[]) {
		for (int i = 1; i < arr.length; i++) {
			int temp = arr[i];
			int j = i;
			while (j > 0 && temp < arr[j - 1]) {
				arr[j] = arr[j - 1];
				j--;
			}
			arr[j] = temp;
		}
	}

	/**
	 * 冒泡排序
	 * 
	 * @param array
	 */
	public static void bubbleSort(int array[]) {
		if (array == null || array.length == 0) {
			return;
		}
		for (int i = 0; i < array.length - 1; i++) {// 执行n-1趟
			boolean flag = false;// 标志位，判断这一趟排序是否有交换位置
			for (int j = 0; j < array.length - 1 - i; j++) {
				if (array[j] > array[j + 1]) {
					// 利用异或的自反性交换值
					array[j] = array[j] ^ array[j + 1];
					array[j + 1] = array[j] ^ array[j + 1];
					array[j] = array[j] ^ array[j + 1];
					flag = true;
				}
			}
			if (!flag) {
				break;
			}
		}

	}

	/**
	 * 简单选择排序
	 * 
	 * @param array
	 */
	public static void selectSort(int array[]) {
		int len = array.length;
		for (int i = 0; i < len - 1; i++) {
			int min = i;
			for (int j = i + 1; j < len; j++) {
				if (array[j] < array[min]) {
					min = j;
				}
			}
			// 交换
			if (min != i) {
				int temp = array[i];
				array[i] = array[min];
				array[min] = temp;
			}
		}
	}

	/**
	 * 堆排序
	 * 
	 * @param array
	 */
	public static void heapSort(int array[]) {

		createHeap(array);
		for (int i = array.length - 1; i > 0; i--) {
			// 交换
			int temp = array[0];
			array[0] = array[i];
			array[i] = temp;
			adjustHeap(array, 0, i);// 调整前面剩下的i个元素，后面的元素不要动
		}
	}

	// 建初堆
	public static void createHeap(int array[]) {
		for (int i = array.length / 2; i >= 0; i--) {// 从最后一个非终端结点开始
			adjustHeap(array, i, array.length);
		}
	}

	// 调整堆
	public static void adjustHeap(int array[], int parentNode, int maxSize) {
		int leftChildNode = (parentNode << 1) + 1;// 位运算效率更高
		int rightChildNode = (parentNode << 1) + 2;
		int maxNode = parentNode;
		// 选出三个之中最大值的下标
		if (leftChildNode < maxSize && array[parentNode] < array[leftChildNode]) {// 有左孩子结点(且此孩子结点在未排序的范围内)
			maxNode = leftChildNode;
		}
		if (rightChildNode < maxSize && array[maxNode] < array[rightChildNode]) {// 有右孩子结点
			maxNode = rightChildNode;
		}
		if (maxNode != parentNode) {
			// 交换
			array[maxNode] = array[maxNode] ^ array[parentNode];
			array[parentNode] = array[maxNode] ^ array[parentNode];
			array[maxNode] = array[maxNode] ^ array[parentNode];

			adjustHeap(array, maxNode, maxSize);// 重新调整孩子结点所在树为大根堆
		}

	}

	/**
	 * 快速排序
	 * 
	 * @param array
	 * @param low
	 * @param high
	 */
	public static void quickSort(int array[], int low, int high) {
		if (low < high) {// 长度大于1
			int p = partition(array, low, high);
			quickSort(array, low, p - 1);
			quickSort(array, p + 1, high);
		}
	}

	// 每一趟排序确定此数组第一个数的最终位置，并返回下标
	public static int partition(int array[], int low, int high) {
		int key = array[low];// 取次数组第一个数为枢轴
		while (low < high) {
			while (low < high && array[high] >= key) {
				high--;
			}
			array[low] = array[high];
			while (low < high && array[low] <= key) {
				low++;
			}
			array[high] = array[low];
		}
		array[low] = key;
		return low;

	}
}
