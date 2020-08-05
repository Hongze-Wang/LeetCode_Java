// 106. Construct Binary Tree from Inorder and Postorder Traversal

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

// class Solution {
//     HashMap<Integer, Integer> map = new HashMap();
//     public TreeNode buildTree(int[] inorder, int[] postorder) {
//         for(int i=0; i<inorder.length; i++) {
//              map.put(inorder[i], i);
//         }
//         return buildTree(inorder, postorder, 0, inorder.length-1, postorder.length-1);
//     }
    
//     public TreeNode buildTree(int[] inorder, int[] postorder, int left, int right, int rootIndex) {
//         if(left > right) return null;
//         int val = postorder[rootIndex];
//         TreeNode root = new TreeNode(val);
        
//         int p = map.get(val);
        
//         root.right = buildTree(inorder, postorder, p+1, right, rootIndex-1);         // 先左子树或者右子树没有影响
//         root.left = buildTree(inorder, postorder, left, p-1, rootIndex-1-(right-p)); // right-p has been used
        
//         return root;
//     }
// }


class Solution {
    HashMap<Integer, Integer> map = new HashMap();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i=0; i<inorder.length; i++) {
             map.put(inorder[i], i);
        }
        return buildTree(inorder, postorder, 0, inorder.length-1, postorder.length-1);
    }
    
    public TreeNode buildTree(int[] inorder, int[] postorder, int left, int right, int rootIndex) {
        if(left > right) return null;
        TreeNode root = new TreeNode(postorder[rootIndex]);
        
        int p = map.get(postorder[rootIndex]);
        
        root.right = buildTree(inorder, postorder, p+1, right, rootIndex-1);         // 先左子树或者右子树没有影响
        root.left = buildTree(inorder, postorder, left, p-1, rootIndex-1-(right-p)); // right-p has been used
        
        return root;
    }
}
