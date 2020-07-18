package linkedList;

import referenceClasses.ListNode;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class SwapNodesInPairs {
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		} /*
			 * else if(head.next.next==null){ ListNode current = head; ListNode next =
			 * head.next; head=next; head.next=current; head.next.next=null; return head; }
			 */
		ListNode current = head;
		ListNode next = head.next;
		ListNode prev = null;
		head = next;
		while (current != null && current.next != null) {
			if (prev == null) {
				current.next = next.next;
				next.next = current;

			} else {
				current.next = next.next;
				next.next = current;
				prev.next = next;
			}

			if (current != null && current.next != null) {
				prev = current;
				current = current.next;
				next = current.next;
			}
		}

		return head;
	}
}