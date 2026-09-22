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

    private ListNode reverse(ListNode node) {
        ListNode prev = null;
        ListNode curr = node;
        ListNode next = node;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;
        int n = 0;
        ListNode temp = head;
        while(temp != null) {
            n++;
            temp = temp.next;
        }
        k = k % n;
        if(k == 0) return head;
        ListNode rHead = reverse(head);
        ListNode head1 = rHead;
        ListNode node1 = head1;
        while(k > 1) {
            node1 = node1.next;
            k--;
        }
        ListNode head2 = node1.next;
        node1.next = null;
        head = reverse(head1);
        head1.next = reverse(head2);
        return head;
    }
}