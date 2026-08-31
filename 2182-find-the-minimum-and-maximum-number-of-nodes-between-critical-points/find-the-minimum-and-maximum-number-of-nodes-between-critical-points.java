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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if(head == null || head.next == null) {
            return new int[]{-1, -1};
        }
        ListNode prev = head;
        ListNode curr = head.next;
        List<Integer> list = new ArrayList();
        int index = 1;
        while(curr.next != null) {
            if(prev.val > curr.val && curr.val < curr.next.val) {
                list.add(index);
            }
            if(prev.val < curr.val && curr.val > curr.next.val) {
                list.add(index);
            }
            index++;
            prev = curr;
            curr = curr.next;
        }
        int size = list.size();
        if(size < 2) return new int[]{-1, -1};
        int maxDistance = list.get(size-1) - list.get(0);
        int minDistance = maxDistance;
        for(int i = 1;i<size;i++) {
            int distance = list.get(i) - list.get(i-1);
            minDistance = Math.min(distance, minDistance);
        }
        return new int[]{minDistance, maxDistance};
    }
}