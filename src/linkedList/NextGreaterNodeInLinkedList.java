package linkedList;

import java.util.LinkedList;
import java.util.Queue;

import referenceClasses.ListNode;

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
public class NextGreaterNodeInLinkedList {
    public int[] nextLargerNodes(ListNode head) {
      if(head==null){
          return new int[0];
      }
        Queue<Integer> queue = new LinkedList<>();
        boolean isAdded=false;
        int count=0;
    while(head!=null){
       
        int toCompare=head.val;
         ListNode temp=head.next;
        while(temp!=null){
            int beCompared=temp.val;
            if(beCompared>toCompare){
                queue.add(beCompared);
                isAdded=true;
                break;
            }
            temp=temp.next;
        }
        if(!isAdded)
        {
             queue.add(0);
        }    
        isAdded=false;
        head=head.next;
        count++;
        
    }
       
        int init=0;
        int[] array=new int[count];
        while(!queue.isEmpty()){
            array[init]=queue.poll();
            init++;
        }
        return array;
    }
}