package LeetCode;
// 110. Balanced Binary Tree
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        if(Math.abs(treeDepth(root.left) - treeDepth(root.right)) <= 1) {
            return isBalanced(root.left) && isBalanced(root.right);
        } else return false;
    }
    public int treeDepth(TreeNode root) {
        if(root == null) return 0;
        return Math.max(treeDepth(root.left), treeDepth(root.right)) + 1;
    }
}
