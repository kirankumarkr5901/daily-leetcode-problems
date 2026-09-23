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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode node = head;
        ListNode prevNode = new ListNode(-1);
        ListNode answerHead = prevNode;
        while(node != null) {
            boolean isUnique = true;
            while(node.next != null && node.val == node.next.val) {
                isUnique = false;
                node = node.next;
            }

            if(isUnique) {
                prevNode.next = node;
                prevNode = node;
                node = node.next;
            } else {
                node = node.next;
                prevNode.next = node;
            }
        }
        return answerHead.next;
    }
}