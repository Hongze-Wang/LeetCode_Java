// 146. LRU Cache

class LRUCache {
    
    private HashMap<Integer, Integer> map;
    private LinkedList<Integer> list;
    private int size;

    public LRUCache(int capacity) {
        map = new HashMap();
        list = new LinkedList();
        size = capacity;
    }
    
    public int get(int key) {
        if(map.containsKey(key)) {
            list.removeFirstOccurrence(key);
            // list.remove(list.indexOf(key));
            list.add(key);
            return map.get(key);
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            list.removeFirstOccurrence(key);
            // list.remove(list.indexOf(key));
            list.add(key);
            map.put(key, value);
        } else {
            map.put(key, value);
            if(map.size() > size) {
                map.remove(list.get(0));
                list.remove(0);
            }
            list.add(key);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
