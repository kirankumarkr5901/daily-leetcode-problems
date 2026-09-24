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
    public int[] nextLargerNodes(ListNode head) {
        Stack<ListNode> track = new Stack();

        ListNode node = head;
        while(node != null) {
            track.add(node);
            node = node.next;
        }
        int n = track.size();
        int[] answer = new int[n];

        Stack<ListNode> greater = new Stack();

        for(int i = n-1;i>=0;i--) {
            ListNode curr = track.pop();
            while(!greater.isEmpty() && curr.val >= greater.peek().val) {
                greater.pop();
            }
            if(greater.isEmpty()) {
                answer[i] = 0;
            } else {
                answer[i] = greater.peek().val;
            }
            greater.add(curr);
        }
        return answer;
    }
}