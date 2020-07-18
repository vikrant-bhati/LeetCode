package linkedList;

import java.util.Stack;

import referenceClasses.ListNode;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
public class AddTwoNumbersII {
	Stack<Integer> stack1 = new Stack<>();
	Stack<Integer> stack2 = new Stack<>();
	Stack<Integer> toStoreSum = new Stack<>();

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l2 == null) {
			return l1;
		}
		if (l1 == null) {
			return l2;
		}
		while (l1 != null || l2 != null) {
			if (l1 != null) {
				stack1.push(l1.val);
				l1 = l1.next;
			}
			if (l2 != null) {
				stack2.push(l2.val);
				l2 = l2.next;
			}

		}
		int sum = 0;

		while (!stack1.empty() && !stack2.empty()) {

			int val = (Integer) stack1.pop() + (Integer) stack2.pop() + sum;
			sum = val / 10;
			val = val % 10;
			toStoreSum.push(val);
		}
		while (!stack1.empty()) {
			int val = (Integer) stack1.pop() + sum;
			sum = val / 10;
			val = val % 10;
			toStoreSum.push(val);
		}
		while (!stack2.empty()) {
			int val = (Integer) stack2.pop() + sum;
			sum = val / 10;
			val = val % 10;
			toStoreSum.push(val);
		}
		if (sum != 0) {
			toStoreSum.push(sum);
		}
		ListNode head = null;
		ListNode temp = null;
		while (!toStoreSum.empty()) {

			ListNode node = new ListNode((Integer) toStoreSum.pop());
			if (head == null) {
				head = node;
				temp = head;

			} else {

				temp.next = node;
				temp = temp.next;
			}
		}
		temp.next = null;
		return head;
	}

}