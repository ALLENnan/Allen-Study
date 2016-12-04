package 算法题;

/**
 * @author Allen Lin
 * @date 2016-8-25
 * @desc 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则
 */
public class _8合并两个排序的链表 {
	// 递归版本
	public ListNode Merge(ListNode list1, ListNode list2) {
		if (list1 == null)
			return list2;
		else if (list2 == null)
			return list1;

		ListNode mergeHead = null;
		if (list1.val < list2.val) {
			mergeHead = list1;
			mergeHead.next = Merge(list1.next, list2);
		} else {
			mergeHead = list2;
			mergeHead.next = Merge(list1, list2.next);
		}
		return mergeHead;
	}

	// 非递归版本
	public ListNode Merge2(ListNode list1, ListNode list2) {
		if (list1 == null)
			return list2;
		else if (list2 == null)
			return list1;

		ListNode head = null;
		ListNode current = null;

		while (list1 != null && list2 != null) {
			if (list1.val < list2.val) {
				if (head == null) {
					head = current = list1;
				} else {
					current.next = list1;
					current = current.next;
				}
				list1 = list1.next;
			} else {
				if (head == null) {
					head = current = list2;
				} else {
					current.next = list2;
					current = current.next;
				}
				list2 = list2.next;
			}
		}
		if (list1 == null)
			current.next = list2;
		if (list2 == null)
			current.next = list1;

		return head;
	}

}
