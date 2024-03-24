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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
          ListNode dummy = new ListNode(0);
        dummy.next = list1;

        ListNode prevA = dummy;
        for (int i = 0; i < a; i++) {
            prevA = prevA.next;
        }

        ListNode nodeB = prevA.next;
        for (int i = a; i <= b; i++) {
            nodeB = nodeB.next;
        }

        ListNode lastList2Node = list2;
        while (lastList2Node.next != null) {
            lastList2Node = lastList2Node.next;
        }

        prevA.next = list2;
        lastList2Node.next = nodeB;

        return dummy.next;
    }
}