package 算法题;

/**
 * @author Allen Lin
 * @date 2016-8-25
 * @desc 输入一个链表，反转链表后，输出链表的所有元素
 */

public class _3反转链表 {

	public ListNode ReverseList(ListNode head) {
		ListNode next = null;
		ListNode pre = null;
		while (head != null) {
			next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}
		return pre;

	}
}
