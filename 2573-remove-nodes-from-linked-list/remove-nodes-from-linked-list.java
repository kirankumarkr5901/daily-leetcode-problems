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
    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> track = new Stack();
        ListNode node = head;

        while(node != null) {
            track.add(node);
            node = node.next;
        }

        ListNode prev = null;
        ListNode curr = null;

        int currentMax = -1;
        while(!track.isEmpty()) {
            curr = track.pop();
            curr.next = null;
            if(curr.val >= currentMax) {
                currentMax = Math.max(currentMax, curr.val);
                curr.next = prev;
                prev = curr;
            }
        }
        return prev;
    }
}