// 98. Validate Binary Search Tree

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

// Approach 1: Recursion
// 
// class Solution {
//     public boolean isBST(TreeNode node, Integer low, Integer up) {
//         if(node == null) return true;
        
//         int val = node.val;
//         if(low != null && val <= low) return false;
//         if(up != null && val >= up) return false;
//         // if(low != null && val <= low || up != null && val >= up) return false;
        
//         return isBST(node.left, low, val) && isBST(node.right, val, up);
//     }
    
    
//     public boolean isValidBST(TreeNode root) {
//         return isBST(root, null, null);
//     }
// }

// Approach 2: Iteration
//
// class Solution {
//     LinkedList<TreeNode> queue = new LinkedList();
//     LinkedList<Integer> ups = new LinkedList(), lows = new LinkedList();
    
//     public void update(TreeNode root, Integer low, Integer up) {
//         queue.add(root);
//         lows.add(low);
//         ups.add(up);
//     }
    
//     public boolean isValidBST(TreeNode root) {
//         Integer low = null, up = null, val;
//         update(root, low, up);
        
//         while(!queue.isEmpty()) {
//             root = queue.poll();
//             low = lows.poll();
//             up = ups.poll();
            
//             if(root == null) continue;
//             val = root.val;
//             if(low != null && val <= low || up != null && val >= up) return false;
//             update(root.left, low, val);
//             update(root.right, val, up);
//         }
//         return true;
//     }
// }

// Approach 3: Inorder traversal
// Inorder travel the tree store the val of the node in order
// check the array we get is ASC or not

// solution taught in class
// class Solution {
//     ArrayList<Integer> array = new ArrayList();
    
//     public void inorder(TreeNode root) {
//         if(root == null) return;
//         inorder(root.left);
//         array.add(root.val);
//         inorder(root.right);
//     }
    
//     public boolean isValidBST(TreeNode root) {
//         if(root == null) return true;
//         inorder(root);
//         for(int i=0; i<array.size()-1; i++) {
//             if(array.get(i) >= array.get(i+1)) return false;
//         }
//         return true;
//     } 
// }

// public class Solution {
//     public boolean isValidBST(TreeNode root) {
//         Stack<TreeNode> stack = new Stack();
//         double inorder = -Double.MAX_VALUE;
        
//         while(!stack.isEmpty() || root != null) {
//             while(root != null) {
//                 stack.push(root);
//                 root = root.left;
//             }
//             root = stack.pop();
//             if(root.val <= inorder) return false;
//             inorder = root.val;
//             root = root.right;
//         }
//         return true;
//     }
// }

// 100 % faster solution
class Solution {
    public boolean isBST(TreeNode node, Integer low, Integer up) {
        if(node == null) return true;
        
        if((low != null && node.val <= low) || (up != null && node.val >= up)) return false;
        return isBST(node.left, low, node.val) && isBST(node.right, node.val, up);
    }
    
    public boolean isValidBST(TreeNode root) {
        return isBST(root, null, null);
    }
}
