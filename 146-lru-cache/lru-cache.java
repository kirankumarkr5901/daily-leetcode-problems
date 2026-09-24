class Node {
    int key;
    int val;
    Node next;
    Node prev;

    Node() {}
    Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class LRUCache {

    private int capacity;
    private Map<Integer, Node> map;
    private Node head;
    private Node tail;
    private int currCap;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        currCap = 0;
        map = new HashMap();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    private void add(Node node) {
        Node next = head.next;
        head.next = node;
        node.prev = head;
        next.prev = node;
        node.next = next;
    }

    private void delete(Node node) {
        Node next = node.next;
        Node prev = node.prev;
        prev.next = next;
        next.prev = prev;
        node.next = null;
        node.prev = null;
    }
    
    public int get(int key) {
        if(this.map.containsKey(key)) {
            Node node = map.get(key);
            this.delete(node);
            this.add(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(this.map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            this.get(key);
            return;
        }
        if(currCap == capacity) {
            Node deleteNode = tail.prev;
            this.delete(deleteNode);
            this.map.remove(deleteNode.key);
            currCap--;

        }
        Node newNode = new Node(key, value);
        this.add(newNode);
        this.map.put(key, newNode);
        currCap++;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */