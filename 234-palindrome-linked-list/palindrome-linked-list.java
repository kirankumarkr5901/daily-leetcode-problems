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
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode node1 = head;
        ListNode node2 = head.next;
        while(node2 != null && node2.next != null) {
            node1 = node1.next;
            node2 = node2.next.next;
        }
        
        ListNode secondHead = node1.next;
        node1.next = null;

        ListNode prev = null;
        ListNode curr = secondHead;
        ListNode next = curr;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        node1 = head;

        while(prev != null) {
            if(prev.val != node1.val) return false;
            node1 = node1.next;
            prev = prev.next;
        }
        return true;
    }
}