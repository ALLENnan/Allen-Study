package 剑指offer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class 数据结构相关 {

	/**
	 * 题目描述 :输入一个链表，从尾到头打印链表每个节点的值。
	 * 
	 * 输入描述: 输入为链表的表头
	 * 
	 * 输出描述: 输出为需要打印的“新链表”的表头
	 * 
	 */
	class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

	// 递归实现

	ArrayList<Integer> arrayList = new ArrayList<Integer>();

	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		if (listNode != null) {
			printListFromTailToHead(listNode.next);
			arrayList.add(listNode.val);
		}
		return arrayList;
	}

	/*
	 * 重建二叉树
	 * 
	 * 题目描述
	 * 
	 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,2,4,7
	 * ,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
	 */
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
		TreeNode root = reConstructBinaryTree(pre, 0, pre.length - 1, in, 0,
				in.length - 1);
		return root;

	}

	private TreeNode reConstructBinaryTree(int[] pre, int startPre, int endPre,
			int[] in, int startIn, int endIn) {

		if (startPre > endPre || startIn > endIn)
			return null;
		TreeNode root = new TreeNode(pre[startPre]);

		for (int i = startIn; i <= endIn; i++)
			if (in[i] == pre[startPre]) {
				root.left = reConstructBinaryTree(pre, startPre + 1, startPre
						+ i - startIn, in, startIn, i - 1);
				root.right = reConstructBinaryTree(pre, i - startIn + startPre
						+ 1, endPre, in, i + 1, endIn);
			}

		return root;
	}

	/**
	 * 
	 * 二叉树的镜像
	 * 
	 * 操作给定的二叉树，将其变换为源二叉树的镜像。
	 */
	public class TreeNode2 {
		int val = 0;
		TreeNode2 left = null;
		TreeNode2 right = null;

		public TreeNode2(int val) {
			this.val = val;

		}

	}

	public void Mirror(TreeNode2 root) {
		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null) {
			return;
		}

		TreeNode2 tn = root.left;
		root.left = root.right;
		root.right = tn;

		if (root.left != null) {
			Mirror(root.left);
		}
		if (root.right != null) {
			Mirror(root.right);
		}
	}

	/**
	 * 包含min函数的栈
	 * 
	 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数
	 */

	Stack<Integer> data = new Stack<Integer>();
	Stack<Integer> min = new Stack<Integer>();

	public void push(int node) {

		data.push(node);
		if (min.size() == 0) {
			min.push(node);
		} else {
			if (node < min.peek()) {
				min.push(node);

			} else {
				min.push(min.peek());
			}
		}
	}

	public void pop() {
		data.pop();
		min.pop();

	}

	public int top() {
		return data.peek();
	}

	public int min() {
		return min.peek();
	}

	/**
	 * 
	 * 从上往下打印二叉树( 广度优先遍历二叉树)
	 * 
	 * 思路是用arraylist模拟一个队列来存储相应的TreeNode
	 */
	public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<>();
		ArrayList<TreeNode> queue = new ArrayList<>();
		if (root == null) {
			return list;
		}
		queue.add(root);
		while (queue.size() != 0) {
			TreeNode temp = queue.remove(0);
			if (temp.left != null) {
				queue.add(temp.left);
			}
			if (temp.right != null) {
				queue.add(temp.right);
			}
			list.add(temp.val);
		}
		return list;
	}

	/**
	 * 
	 * 栈的压入、弹出序列
	 * 
	 * 题目描述:
	 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如序列1,2,3,4,5
	 * 是某栈的压入顺序
	 * ，序列4，5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
	 */
	public boolean IsPopOrder(int[] pushA, int[] popA) {
		if (pushA.length == 0 || popA.length == 0)
			return false;
		Stack<Integer> s = new Stack<Integer>();
		// 用于标识弹出序列的位置
		int popIndex = 0;
		for (int i = 0; i < pushA.length; i++) {
			s.push(pushA[i]);
			// 如果栈不为空，且栈顶元素等于弹出序列
			while (!s.empty() && s.peek() == popA[popIndex]) {
				// 出栈
				s.pop();
				// 弹出序列向后一位
				popIndex++;
			}
		}
		return s.empty();
	}

	/**
	 * 二叉搜索树的后序遍历序列
	 * 
	 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
	 */

	// 左子树一定比右子树小，因此去掉根后，数字分为left，right两部分，right部分的
	// 最后一个数字是右子树的根他也比左子树所有值大
	public boolean VerifySquenceOfBST(int[] sequence) {
		int size = sequence.length;
		if (0 == size)
			return false;

		int i = 0;
		while (size != 0) {
			while (sequence[i] < sequence[size - 1]) {
				i++;
			}
			while (sequence[i] > sequence[size - 1]) {
				i++;
			}

			if (i != size - 1)
				return false;
			i = 0;
			size--;
		}
		return true;
	}

	/**
	 * 二叉树中和为某一值的路径
	 * 
	 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
	 */
	// TODO 没懂
	private ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
	private ArrayList<Integer> list = new ArrayList<Integer>();

	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
		if (root != null) {
			list.add(root.val);
			target -= root.val;
			if (target == 0 && root.left == null && root.right == null)
				listAll.add(new ArrayList<Integer>(list));
			FindPath(root.left, target);
			FindPath(root.right, target);
			target += root.val;
			list.remove(list.size() - 1);
		}
		return listAll;
	}

	/**
	 * 字符串的排列
	 * 
	 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,
	 * bac,bca,cab和cba。 结果请按字母顺序输出
	 */
	// TODO 重点

	public static ArrayList<String> Permutation(String str) {
		ArrayList<String> al = new ArrayList<String>();
		if (str == null || str.length() == 0) {
			return al;
		}
		Set<String> set = new HashSet<String>();
		permutation(set, str.toCharArray(), 0);
		al.addAll(set);
		Collections.sort(al);
		return al;
	}

	public static void permutation(Set<String> set, char[] buf, int k) {
		if (k == buf.length - 1) {// 当只要求对数组中一个字母进行全排列时，只要就按该数组输出即可
			set.add(new String(buf));
			return;
		} else {// 多个字母全排列
			for (int i = k; i < buf.length; i++) {
				char temp = buf[k];// 交换数组第一个元素与后续的元素
				buf[k] = buf[i];
				buf[i] = temp;

				permutation(set, buf, k + 1);// 后续元素递归全排列

				temp = buf[k];// 将交换后的数组还原
				buf[k] = buf[i];
				buf[i] = temp;
			}
		}

	}

	public static void main(String[] args) {
		// char[] buf = new char[] { 'a', 'b', 'c' };
		ArrayList<String> al = Permutation("abc");
		for (String str : al) {
			System.out.println(str);
		}

	}

}
