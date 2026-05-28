class MyHashMap {
    // A prime number helps distribute keys more evenly
    private final int CAPACITY = 1009; 
    private Node[] buckets;

    private class Node {
        int key, value;
        Node next;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public MyHashMap() {
        buckets = new Node[CAPACITY];
    }

    private int hash(int key) {
        return key % CAPACITY;
    }

    public void put(int key, int value) {
        int index = hash(key);
        if (buckets[index] == null) {
            buckets[index] = new Node(key, value);
            return;
        }
        
        Node curr = buckets[index];
        while (true) {
            if (curr.key == key) {
                curr.value = value; // Update existing key
                return;
            }
            if (curr.next == null) break;
            curr = curr.next;
        }
        curr.next = new Node(key, value); // Add new node at the end of the chain
    }

    public int get(int key) {
        int index = hash(key);
        Node curr = buckets[index];
        while (curr != null) {
            if (curr.key == key) return curr.value;
            curr = curr.next;
        }
        return -1; // Key not found
    }

    public void remove(int key) {
        int index = hash(key);
        Node curr = buckets[index];
        if (curr == null) return;
        
        if (curr.key == key) {
            buckets[index] = curr.next;
            return;
        }
        
        while (curr.next != null) {
            if (curr.next.key == key) {
                curr.next = curr.next.next;
                return;
            }
            curr = curr.next;
        }
    }
}