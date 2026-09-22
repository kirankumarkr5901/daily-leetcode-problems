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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || head.next == null) return head;
        ListNode prev = null;
        ListNode curr = head;
        int dLeft = left;
        while(dLeft > 1) {
            prev = curr;
            curr = curr.next;
            dLeft--;
        }
        Stack<ListNode> stack = new Stack();
        int gap = right - left;
        while(gap >= 0) {
            stack.add(curr);
            curr = curr.next;
            gap--;
        }
        while(!stack.isEmpty()) {
            if(prev == null) {
                head = stack.pop();
                prev = head;
            } else {
                prev.next = stack.pop();
                prev = prev.next;
            }
        }
        prev.next = curr;
        return head;
    }
}