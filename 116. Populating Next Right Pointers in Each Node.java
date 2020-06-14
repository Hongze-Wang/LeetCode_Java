// 116. Populating Next Right Pointers in Each Node
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

// Brute Force: level order traversal store the node in a 2D arraylist
// then link the elem in arraylist

// class Solution {
//     public Node connect(Node root) {
//         ArrayList<ArrayList<Node>> res = new ArrayList();
//         BFS(root, 1, res);
//         for(int i=0; i<res.size(); i++) {
//             ArrayList<Node> temp1 = res.get(i);
//             for(int j=0; j<temp1.size(); j++) {
//                 Node temp2 = temp1.get(j);
//                 if(temp2 == temp1.get(temp1.size()-1)) {
//                     temp2.next = null;
//                 } else {
//                     temp2.next = temp1.get(j+1);
//                 }
//             }
//         }
//         return root;
//     }

//     private void BFS(Node root, int depth, ArrayList<ArrayList<Node>> list) {
//         if(root == null) return;
//         if(depth > list.size()) {
//             list.add(new ArrayList<Node>());
//         }
//         list.get(depth-1).add(root);
//         BFS(root.left, depth+1, list);
//         BFS(root.right, depth+1, list);
//     }
// }


// slower than above
// class Solution {
//     public Node connect(Node root) {        
//         if(root == null) return null;
        
//         Queue<Node> queue = new LinkedList<Node>();
//         ArrayList<ArrayList<Node>> res = new ArrayList<ArrayList<Node>>();
//         ArrayList<Node> temp = new ArrayList<Node>();
//         Node node;

        
//         queue.add(root);
//         queue.add(null);
//         while(queue.size() > 1) {
//             node = queue.poll();
//             if(node == null) {
//                 res.add(temp);
//                 temp = new ArrayList<Node>();
//                 queue.add(null);
//             } else {
//                 temp.add(node);
//                 if(node.left != null) {
//                     queue.add(node.left);
//                 }
//                 if(node.right != null) {
//                     queue.add(node.right);
//                 }
//             }
//         }
//         res.add(temp);
        
//         for(int i=0; i<res.size(); i++) {
//             ArrayList<Node> temp1 = res.get(i);
//             for(int j=0; j<temp1.size(); j++) {
//                 Node temp2 = temp1.get(j);
//                 if(temp2 == temp1.get(temp1.size()-1)) {
//                     temp2.next = null;
//                 } else {
//                     temp2.next = temp1.get(j+1);
//                 }
//             }
//         }
//         return root;
//     }
// }

class Solution {
    public Node connect(Node root) {
        return iteratePopulate(root, null);
    }
    private Node iteratePopulate(Node node, Node right) {
        if(node == null) return node;
        node.next = right;
        node.left = iteratePopulate(node.left, node.right);
        node.right = iteratePopulate(node.right, right==null ? null : right.left);
        return node;
    }
}
