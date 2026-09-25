class LFUCache {

    class Node {
        int key;
        int val;
        int freq;
        Node next;
        Node prev;

        Node() {}
        Node(int key, int val) {
            this.key = key;
            this.val = val;
            freq = 1;
        }
    }

    int capacity;
    int currentSize;
    int leastf;
    Map<Integer, Node> fmap;
    Map<Integer, Node> kmap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        currentSize = 0;
        leastf = 0;
        fmap = new HashMap();
        kmap = new HashMap();
    }
    private boolean isFreqEmpty(int f) {
        return !fmap.containsKey(f) || fmap.get(f).prev == fmap.get(f).next;
    }
    private void remove(int key, Node node) {
        Node next = node.next;
        Node prev = node.prev;
        prev.next = next;
        next.prev = prev;

        node.next = null;
        node.prev = null;
        if (isFreqEmpty(this.leastf)) {
            this.leastf++;
        }
    }

    private Node delete(int key) {
        Node tail = fmap.get(key).prev;
        Node node = tail.prev;
        tail.prev = node.prev;
        tail.prev.next = tail;

        node.next = null;
        node.prev = null;
        return node;
    }

    private void add(int key, Node node) {
        if(fmap.containsKey(key)) {
            Node head = fmap.get(key);
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
            node.prev = head;
        } else {
            Node head = new Node();
            Node tail = new Node();
            head.prev = tail;
            tail.next = head;

            head.next = node;
            tail.prev = node;
            node.next = tail;
            node.prev = head;

            fmap.put(key, head);
        }
    }

    
    public int get(int key) {
        if(kmap.containsKey(key)) {
            Node node = kmap.get(key);
            remove(node.freq, node);
            node.freq++;
            add(node.freq, node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(kmap.containsKey(key)) {
            Node node = kmap.get(key);
            node.val = value;
            remove(node.freq, node);
            node.freq++;
            add(node.freq, node);
            return;
        } 
        
        if(currentSize == this.capacity){
            Node deleteNode = delete(this.leastf);
            kmap.remove(deleteNode.key);
            this.currentSize--;
        }

        Node newNode = new Node(key, value);
        kmap.put(key, newNode);
        add(1, newNode);
        this.currentSize++;
        this.leastf = 1;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */