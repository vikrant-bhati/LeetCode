package linkedList;

import java.util.Stack;

//Definition for a Node.
class Node {
	public int val;
	public Node prev;
	public Node next;
	public Node child;
};

public class FlattenMultilevelDoublyLinkedList {
	public Node flatten(Node head) {
		if (head == null)
			return head;
		Node temp = head;
		boolean isStack = false;
		Stack<Node> stack = new Stack<>();

		while (temp.next != null || !stack.empty() || temp.child != null) {
			if (temp.child != null) {

				if (temp.next != null)
					stack.push(temp.next);
				temp.next = temp.child;
				temp.child.prev = temp;
				temp.child = null;

			}
			if (temp.next == null && !stack.empty()) {
				isStack = true;
			}
			if (isStack) {
				temp.next = stack.pop();
				temp.next.prev = temp;
				isStack = false;
			}
			temp = temp.next;

		}

		return head;
	}
}