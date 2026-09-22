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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return  head;

        ListNode next = head;
        ListNode node1 = null;
        ListNode node2 = null;
        ListNode prev = null;
        ListNode answerHead = next.next;
        while(next != null && next.next != null) {
            prev = node1;
            node1 = next;
            node2 = next.next;
            next = next.next.next;
            node2.next = node1;
            node1.next = next;
            if(prev != null) prev.next = node2;
        }
        return answerHead;
    }
}