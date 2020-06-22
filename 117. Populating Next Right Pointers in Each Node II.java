// 117. Populating Next Right Pointers in Each Node II

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

// BFS by Queue
// class Solution {
//     public Node connect(Node root) {
//         if(root == null) return null;
//         Queue<Node> queue = new LinkedList<>();
    
//         queue.offer(root);
        
//         while(!queue.isEmpty()) {
//             int len = queue.size();
//             Node prev = null;
//             for(int i=0; i<len;i++) {
//                 Node curr = queue.poll();
//                 if(prev != null) {
//                     curr.next = prev;
//                 }
//                 if(curr.right != null) {
//                     queue.offer(curr.right);
//                 }
//                 if(curr.left != null) {
//                     queue.offer(curr.left);
//                 }
//                 prev = curr;
//             }
//         }
//         return root;
//     }
// }

// Recursive
class Solution {
    public Node connect(Node root) {
        return iteratePopulate(root, 0, new ArrayList());
    }
    private Node iteratePopulate(Node node, int depth, List<Node> list) {
        if(node == null) return node;
        if(depth < list.size()) {
            list.get(depth).next = node;
            list.set(depth, node);
        } else {
            list.add(node);
        }
        iteratePopulate(node.left, depth+1, list);
        iteratePopulate(node.right, depth+1, list);
        return node;
    }
}
