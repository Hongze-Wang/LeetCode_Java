// 138. Copy List with Random Pointer

// deep copy
// The hashmap is used here to avoid repetitively create nodes
// Note that random nodes are still need to be created because of deep copy

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
        Node dummyHead = new Node(-1);
        Node node = dummyHead, oldNode = head;
        Map<Node, Node> map = new HashMap();
        while(oldNode != null) {
            Node newNode = map.getOrDefault(oldNode, new Node(oldNode.val));
            map.put(oldNode, newNode);
            if(oldNode.random != null) {
                Node newRandomNode = map.getOrDefault(oldNode.random, new Node(oldNode.random.val));
                map.put(oldNode.random, newRandomNode);
                newNode.random = newRandomNode;
            }
            oldNode = oldNode.next;
            node.next = newNode;
            node = newNode;
        }
        return dummyHead.next;
    }
}
