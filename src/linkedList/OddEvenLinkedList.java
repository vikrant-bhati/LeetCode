package linkedList;

import referenceClasses.ListNode;

/**
 * https://leetcode.com/problems/odd-even-linked-list/
 * solution to above code for linked list
 * @author Administrator
 * Description below
 * 
 * Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

 *	You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
 */


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null)
        {
             return head;
        }
           
        
        ListNode odd=head;
        ListNode even=head.next;
        ListNode temp=even;
        while(even.next!=null && odd.next!=null){
            if(even.next!=null){
                odd.next=odd.next.next;
                odd=odd.next;
            }if(odd.next!=null){
                even.next=even.next.next;
                even=even.next;
            }
        }
        even.next=null;
        odd.next=temp;
       
        return head;
    }
}