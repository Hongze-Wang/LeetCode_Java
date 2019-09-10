package LeetCode;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class MinimumDepthofBinaryTree {
    public int minDepth(TreeNode root) {
        return depth(root);
    }
    private int depth(TreeNode root) {
        if(root == null ) return 0;
        if(root.left == null && root.right != null) {
            return depth(root.right) + 1;
        }
        if(root.left != null && root.right == null) {
            return depth(root.left) + 1;
        }
        return Math.min(depth(root.left), depth(root.right)) + 1;
    }
}
