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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode nodeFront = head;
        while(n > 0) {
            nodeFront = nodeFront.next;
            n--;
        }
        if(nodeFront == null) return head.next;

        nodeFront = nodeFront.next;
        ListNode nodeBack = head;
        while(nodeFront != null) {
            nodeFront = nodeFront.next;
            nodeBack = nodeBack.next;
        }
        nodeBack.next = nodeBack.next.next;
        return head;
    }
}