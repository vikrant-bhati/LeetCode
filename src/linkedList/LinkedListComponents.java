package linkedList;

import referenceClasses.ListNode;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
public class LinkedListComponents {
	public int numComponents(ListNode head, int[] G) {
		ListNode temp = head;
		int count = 0;
		boolean start = false;
		while (temp != null) {
			boolean isSearch = search(temp.val, G);
			if (isSearch && !start) {
				start = true;
			}
			if (!isSearch && start) {
				start = false;
				count++;
			}
			temp = temp.next;
		}
		if (start)
			return ++count;
		return count;

	}

	public boolean search(int val, int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (val == arr[i]) {
				return true;
			}
		}
		return false;
	}
}