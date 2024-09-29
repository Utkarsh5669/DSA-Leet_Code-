public class Node {

    int freq;
    Node prev;
    Node next;
    Set<String> strSet = new HashSet<>();

    Node(int freq) {
        this.freq = freq;
    }
}

class AllOne {

    Node head;
    Node tail;
    Map<String, Node> strToNodeMap = new HashMap<>();

    AllOne() {
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
    }

    public void inc(String key) {
        if (strToNodeMap.containsKey(key)) {
            Node node = strToNodeMap.get(key);
            int freq = node.freq;
            node.strSet.remove(key);

            Node nextNode = node.next;
            if (nextNode == tail || nextNode.freq != freq + 1) {
                Node newNode = new Node(freq + 1);
                newNode.strSet.add(key);
                newNode.prev = node;
                newNode.next = nextNode;
                node.next = newNode;
                nextNode.prev = newNode;
                strToNodeMap.put(key, newNode);
            } else {
                nextNode.strSet.add(key);
                strToNodeMap.put(key, nextNode);
            }

            if (node.strSet.isEmpty()) {
            deleteNode(node);
            }
        }
         else {
            Node firstNode = head.next;
            if (firstNode == tail || firstNode.freq > 1) {
                Node newNode = new Node(1);
                newNode.strSet.add(key);
                newNode.prev = head;
                newNode.next = firstNode;
                head.next = newNode;
                firstNode.prev = newNode;
                strToNodeMap.put(key, newNode);
            } else {
                firstNode.strSet.add(key);
                strToNodeMap.put(key, firstNode);
            }
        }
    }

    public void dec(String key) {
        if (!strToNodeMap.containsKey(key)) {
            return;
        }

        Node node = strToNodeMap.get(key);
        node.strSet.remove(key);
        int freq = node.freq;

        if (freq == 1) {
            strToNodeMap.remove(key);
        } else {
            Node prevNode = node.prev;
            if (prevNode == head || prevNode.freq != freq - 1) {
                Node newNode = new Node(freq - 1);
                newNode.strSet.add(key);
                newNode.prev = prevNode;
                newNode.next = node;
                prevNode.next = newNode;
                node.prev = newNode;
                strToNodeMap.put(key, newNode);
            } else {
                prevNode.strSet.add(key);
                strToNodeMap.put(key, prevNode);
            }
        }

        if (node.strSet.isEmpty()) {
            deleteNode(node);
        }
    }

    public String getMaxKey() {
        if (tail.prev == head) {
            return "";
        }
        return tail.prev.strSet.iterator().next();
    }

    public String getMinKey() {
        if (head.next == tail) {
            return "";
        }
        return head.next.strSet.iterator().next();
    }

    private void deleteNode(Node node) {
        Node prevNode = node.prev;
        Node afterNode = node.next;

        prevNode.next = afterNode;
        afterNode.prev = prevNode;
    }
}