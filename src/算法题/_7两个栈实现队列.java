package 算法题;

import java.util.Stack;

/**
 * @author Allen Lin
 * @date 2016-8-25
 * @desc 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型
 */

public class _7两个栈实现队列 {
	// 入队：将元素进栈1; 出队：判断栈2是否为空，如果为空，则将栈1中所有元素pop，并push进栈2，栈2出栈； 如果不为空，栈2直接出栈。
	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();

	public void push(int node) {
		stack1.push(node);
	}

	public int pop() {
		if (stack2.empty()) {
			while (!stack1.empty()) {
				stack2.push(stack1.pop());
			}
		}
		return stack2.pop();
	}
}
