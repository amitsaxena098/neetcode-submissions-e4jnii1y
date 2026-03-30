class LRUCache {

    Map<Integer, ListNode> map = new HashMap<>();
    ListNode head = new ListNode(-1, -1);
    ListNode tail = new ListNode(-1, -1);
    int capacity;
    int currCapacity = 0;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        }
        ListNode node = map.get(key);
        int ans = node.val;
        // map.remove(node.key);
        deleteNode(node);
        addNode(node);
        // map.put(key, node);
        return ans;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            ListNode node = map.get(key);
            deleteNode(node);
        }
        if(capacity == currCapacity) {
            ListNode node = tail.prev;
            deleteNode(node);
            map.remove(node.key);
        }
        ListNode node = new ListNode(key, value);
        addNode(node);
        map.put(key, node);
    }

    public void addNode(ListNode node) {
        ListNode oldNext = head.next;
        head.next = node;
        node.prev = head;
        node.next = oldNext;
        oldNext.prev = node;
        currCapacity++;
    }
    public void deleteNode(ListNode node) {
        ListNode nextNode = node.next;
        ListNode prevNode = node.prev;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        currCapacity--;
    }
}

class ListNode {
    ListNode next;
    ListNode prev;
    int key, val;

    ListNode(int key, int val) {
        this.key = key;
        this.val = val;
        next = null;
        prev = null;
    }
}
