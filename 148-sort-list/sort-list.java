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

    private ListNode mergeList(ListNode left, ListNode right) {
        ListNode head = new ListNode(-1);
        ListNode node = head;

        while(left != null && right != null) {
            if(left.val < right.val) {
                node.next = left;
                node = left;
                left = left.next;
            } else {
                node.next = right;
                node = right;
                right = right.next;
            }
        }
        if(left == null) {
            node.next = right;
        } else {
            node.next = left;
        }
        return head.next;
    }
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode second = slow.next;
        slow.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(second);

        return mergeList(left, right);
    }
}