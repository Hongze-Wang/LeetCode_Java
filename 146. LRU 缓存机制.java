// 146. LRU Cache

// class LRUCache {
    
//     private HashMap<Integer, Integer> map;
//     private LinkedList<Integer> list;
//     private int size;

//     public LRUCache(int capacity) {
//         map = new HashMap<>();
//         list = new LinkedList<>();
//         size = capacity;
//     }
    
//     public int get(int key) {
//         if(map.containsKey(key)) {
//             list.removeFirstOccurrence(key);
//             list.add(key);
//             return map.get(key);
//         } else {
//             return -1;
//         }
//     }
    
//     public void put(int key, int value) {
//         if(map.containsKey(key)) {
//             list.removeFirstOccurrence(key);
//             list.add(key);
//             map.put(key, value);
//         } else {
//             map.put(key, value);
//             if(map.size() > size) {
//                 map.remove(list.get(0));
//                 list.remove(0);
//             }
//             list.add(key);
//         }
//     }
// }


class LRUCache extends LinkedHashMap<Integer, Integer> {

    private int capacity;

    public LRUCache(int capacity) {
        super(capacity, 075F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

public class LRUCache {
    
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev, next;
        public DLinkedNode() {}
        public DLinkedNode(int _key, int _value) {key = _key; value = _value;}
    }

    public void addToHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private DLinkedNode removeTail() {
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }

    private Map<Integer, DLinkedNode> cache;
    private int size;
    private int capacity;
    private DLinkedNode head, tail;

    // 从双端连 队头到队尾 访问频次降低
    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        cache = new HashMap<>()
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if(node == null) {
            return -1;
        }
        moveToHead(node);     // 每次访问置队头
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key); 
        if(node == null) {
            DLinkedNode newNode = new DLinkedNode(key, value);
            cache.put(key, newNode);
            addToHead(newNode);   // 添加到队头则不需要移动到队头
            size++;
            if(size > capacity) { // 创建新节点 并加入哈希表 移动到队头之后 要判断是否超限
                DLinkedNode tail = removeTail(); // 超限则删除尾节点
                cache.remove(tail.key);          // 同时从哈希表中移除
                size--;
            }
        } else {
            node.value = value;
            moveToHead(node); // 每次访问置队头
        }
    }
}
