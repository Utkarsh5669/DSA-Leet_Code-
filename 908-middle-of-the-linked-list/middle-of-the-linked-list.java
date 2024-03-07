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
    public ListNode middleNode(ListNode head) {
         if(head==null)
         return null;

         ListNode i = head;
         ListNode j = head;

         while(j!=null && j.next!=null)
         {
           i=i.next;
           j=j.next.next;
         }
         return i; 
    }
}