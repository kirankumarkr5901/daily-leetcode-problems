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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((ListNode a, ListNode b) -> Integer.compare(a.val, b.val));

        for(ListNode node: lists) {
            if(node != null) pq.offer(node);
        }
        if(pq.isEmpty()) return null;
        ListNode head = pq.poll();
        if(head.next != null) {
            pq.offer(head.next);
        }
        ListNode curr = head;
        while(!pq.isEmpty()) {
            ListNode node = pq.poll();
            curr.next = node;
            curr = node;
            if(node.next != null) pq.offer(node.next);
        }
        return head;
    }
}