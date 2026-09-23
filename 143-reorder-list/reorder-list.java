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
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        Stack<ListNode> stack = new Stack();
        ListNode node = head;
        while(node != null) {
            stack.add(node);
            node = node.next;
        }
        int n = stack.size();
        ListNode prev = head;
        for(int index = 0;index<n;index += 2) {
            prev = head.next;
            head.next = stack.pop();
            head.next.next = prev;
            head = prev;
        }
        if((n&1) == 0)
            head.next = null;
        else 
            head.next.next = null;
    }
}