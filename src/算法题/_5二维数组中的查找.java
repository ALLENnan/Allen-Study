package 算法题;

/**
 * @author Allen Lin
 * @date 2016-8-25
 * @desc 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，
 *       判断数组中是否含有该整数。
 */
public class _5二维数组中的查找 {

	// 矩阵是有序的，从左下角开始，向上递减，向右递增。因此从左下角开始查找，当要查找数字比左下角数字大时，右移； 要查找数字比左下角数字小时，上移
	public boolean Find(int[][] array, int target) {
		int row = array.length;
		int col = array[0].length;
		int i = row - 1, j = 0;
		while (i >= 0 && j < col) {
			if (target == array[i][j]) {
				return true;
			} else if (target > array[i][j]) {
				j++;
			} else {
				i--;
			}
		}
		return false;
	}
}
