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
    public int pairSum(ListNode head) {
        ListNode node1 = head;
        ListNode node2 = head.next;
        while(node2 != null && node2.next != null) {
            node1 = node1.next;
            node2 = node2.next.next;
        }

        ListNode secondHead = node1.next;
        node1.next = null;

        // Reverse the second half list
        ListNode prev = null;
        ListNode curr = secondHead;
        ListNode next = curr;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        int twinSum = 0;
        node1 = head;
        node2 = prev;

        while(node1 != null) {
            twinSum = Math.max(twinSum, node1.val + node2.val);
            node1 = node1.next;
            node2 = node2.next;
        }
        return twinSum;
    }
}