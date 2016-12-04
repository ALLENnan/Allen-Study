package 算法题;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * @author Allen Lin
 * @date 2016-8-25
 * @desc 
 *       明明想在学校中请一些同学一起做一项问卷调查，为了实验的客观性，他先用计算机生成了N个1到1000之间的随机整数（N≤1000），对于其中重复的数字
 *       ， 只保留一个，把其余相同的数去掉，不同的数对应着不同的学生的学号。然后再把这些数从小到大排序，按照排好的顺序去找同学做调查。请你协助明明完成
 *       “去重”与“排序”的工作。 Input Param n 输入随机数的个数 inputArray n个随机整数组成的数组 Return
 *       Value OutputArray 输出处理后的随机整数
 */

public class _1去重与排序 {

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		TreeSet<Integer> ts = new TreeSet<Integer>();

		// TreeSet<People> ts = new TreeSet<People>(new Comparator<People>() {
		// public int compare(People p1, People p2) {
		// if (p1.getAge() > p2.getAge())
		// return -1;
		// else if (p1.getAge() < p2.getAge())
		// return 1;
		// else {
		// return 0;
		// }
		// }
		//
		// });
		// ts.add(new People(2));
		// ts.add(new People(9));
		// ts.add(new People(4));

		int n = cin.nextInt();
		for (int i = 0; i < n; i++) {
			ts.add(cin.nextInt());
		}
		Iterator<Integer> it = ts.iterator();

		while (it.hasNext()) {
			System.out.println(it.next());
		}
		// for (Integer i : ts) {
		// System.out.println(i);
		// }
	}

}

// class People {
// int age;
//
// public int getAge() {
// return age;
// }
//
// public void setAge(int age) {
// this.age = age;
// }
//
// public People(int age) {
// this.age = age;
// }
// }
