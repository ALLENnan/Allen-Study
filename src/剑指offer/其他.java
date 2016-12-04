package 剑指offer;

public class 其他 {

	public static void main(String[] args) {

	}

	/**
	 * 旋转数组的最小数字
	 * 
	 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，并保证奇数和奇数，
	 * 偶数和偶数之间的相对位置不变。
	 * 
	 * 解法:类似插入排序，奇数前移，o(n^2)
	 */
	public void reOrderArray(int[] array) {
		for (int i = 1; i < array.length; i++) {
			if ((array[i] & 1) == 1) {// 奇数
				int temp = array[i];
				int j = i;
				while (j > 0 && (array[j - 1] & 1) == 0) {
					array[j] = array[j - 1];
					j--;
				}
				array[j] = temp;
			}
		}
	}
}
