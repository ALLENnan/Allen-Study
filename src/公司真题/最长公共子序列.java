package 公司真题;

/**
 * @author Allen Lin
 * @date 2016-8-26
 * @desc 请编写一个函数，输入两个字符串，求它们的最长公共子串，并打印出最长公共子串。
 *       例如：输入两个字符串BDCABA和ABCBDAB，字符串BCBA和BDAB都是是它们的最长公共子序列
 *       ，则输出它们的长度4，并打印任意一个子序列。
 * 
 *       解题思路： 由最长公共子序列问题的最优子结构性质可知，要找出X=<x1, x2, …, xm>和Y=<y1, y2, …,
 *       yn>的最长公共子序列， 可按以下方式递归地进行：当xm=yn时，找出Xm-1和Yn-1的最长公共子序列，然后在其尾部加上xm
 *       (=yn)即可得X和Y的一个最长公共子序列。
 *       当xm≠yn时，必须解两个子问题，即找出Xm-1和Y的一个最长公共子序列及X和Yn-1的一个最长公共子序列
 *       。这两个公共子序列中较长者即为X和Y的一个最长公共子序列。
 */
public class 最长公共子序列 {

	public static void main(String[] args) {

	}

}
