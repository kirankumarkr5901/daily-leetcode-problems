/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return head;
        Node dummy = new Node(-1);
        Node node = dummy;

        Node iter = head;
        // Count the nodes
        Map<Node, Integer> map = new HashMap();
        while(iter != null) {
            map.put(iter, map.size());
            iter = iter.next;
        }

        int count = map.size();
        Node[] arr = new Node[count];
        iter = head;
        for(int i = 0;i<count && iter != null;i++){
            Node curr = new Node(iter.val);
            node.next = curr;
            node = curr;
            arr[i] = curr;
            iter = iter.next;
        }
        iter = head;
        for(int i = 0;i<count && iter != null;i++) {
            Node curr = arr[i];
            curr.random = iter.random == null ? null : arr[map.get(iter.random)];
            iter = iter.next;
        }
        return dummy.next;
    }
}