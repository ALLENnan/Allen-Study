package 算法题;

/**
 * @author Allen Lin
 * @date 2016-8-25
 * @desc 输入一个链表，输出该链表中倒数第k个结点
 */

public class _6链表中倒数第k个结点 {
	/**
	 * 两个指针，先让第一个指针和第二个指针都指向头结点，然后再让第一个指针走(k-1)步，到达第k个节点。
	 * 然后两个指针同时往后移动，当第一个结点到达末尾的时候，第二个结点所在位置就是倒数第k个节点了
	 */
	public ListNode FindKthToTail(ListNode head, int k) {
		if (head == null || k <= 0) {
			return null;
		}
		ListNode pre = head;
		ListNode last = head;
		for (int i = 1; i <= k - 1; i++) {
			if (pre.next != null) {
				pre = pre.next;
			} else {
				return null;
			}
		}

		while (pre.next != null) {
			pre = pre.next;
			last = last.next;
		}
		return last;
	}
}
