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
        if(head == null || head.next == null || head.next.next == null) return head;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode node = even.next;
        odd.next = null;
        even.next = null;
        ListNode evenStart = even;
        while(node != null) {
            odd.next = node;
            node = node.next;
            odd = odd.next;
            odd.next = null;

            if(node != null) {
                even.next = node;
                node = node.next;
                even = even.next;
                even.next = null;
            }
        }
        odd.next = evenStart;
        return head;
    }
}