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
    public ListNode partition(ListNode head, int x) {
        ListNode lHead = new ListNode(-1);
        ListNode gHead = new ListNode(-1);
        ListNode lnode = lHead;
        ListNode gnode = gHead;

        ListNode node = head;
        while(node != null) {
            if(node.val < x) {
                lnode.next = node;
                lnode = node;
                node = node.next;
                lnode.next = null;
            } else {
                gnode.next = node;
                gnode = node;
                node = node.next;
                gnode.next = null;
            }
        }
        lnode.next = gHead.next;
        return lHead.next;
    }
}