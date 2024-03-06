/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
       if(head==null || head.next==null){
           return false;
       }
       ListNode i = head;
       ListNode j = head.next;

       while(i!=j){
           if(j==null||j.next==null){
               return false;
           }
           i = i.next;
           j= j.next.next;
       }
       return true;
    }
}