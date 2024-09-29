class Node {
    int cnt;
    Set<String> keys;
    Node prev, next; 
    public Node(int c) {
        cnt = c;
        keys = new HashSet<>();
        prev = next = null;
    }
}
class AllOne {
    private Map<String, Integer> keyCnt; 
    private Map<Integer, Node> cntNodeMap; 
    private Node head, tail;
    public AllOne() {
        keyCnt = new HashMap<>();
        cntNodeMap = new HashMap<>();
        head = new Node(Integer.MIN_VALUE);
        tail = new Node(Integer.MAX_VALUE);
        head.next = tail;
        tail.prev = head;
    }
    private Node addNodeAfter(Node node, int c) {
        Node newNode = new Node(c);
        newNode.next = node.next;
        newNode.prev = node;
        node.next.prev = newNode;
        node.next = newNode;
        cntNodeMap.put(c, newNode);
        return newNode;
    }
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        cntNodeMap.remove(node.cnt);
    }
    public void inc(String key) {
        int c = keyCnt.getOrDefault(key, 0);
        keyCnt.put(key, c + 1);
        Node curr = cntNodeMap.get(c);
        Node next = cntNodeMap.get(c + 1);
        if (next == null) next = addNodeAfter(curr == null ? head : curr, c + 1);
        next.keys.add(key);
        if (curr != null) {
            curr.keys.remove(key);
            if (curr.keys.isEmpty()) removeNode(curr);
        }
    }
    public void dec(String key) {
        int c = keyCnt.get(key);
        if (c == 1) keyCnt.remove(key);
        else keyCnt.put(key, c - 1);

        Node curr = cntNodeMap.get(c);
        Node prev = cntNodeMap.get(c - 1);

        if (c > 1 && prev == null) prev = addNodeAfter(curr.prev, c - 1);
        if (c > 1) prev.keys.add(key);

        curr.keys.remove(key);
        if (curr.keys.isEmpty()) removeNode(curr);
    }
    public String getMaxKey() {
        return tail.prev == head ? "" : tail.prev.keys.iterator().next();
    }
    public String getMinKey() {
        return head.next == tail ? "" : head.next.keys.iterator().next();
    }
}