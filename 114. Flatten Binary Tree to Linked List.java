// 114. Flatten Binary Tree to Linked List

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

class Solution {
    TreeNode prev;
    public void flatten(TreeNode root) {
        if(root == null) return;
        TreeNode left = root.left, right = root.right;
        if(prev != null) {
            prev.right = root;
            prev.left = null;
        }
        prev = root;
        flatten(left);
        flatten(right);
    }
}
