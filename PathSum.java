package LeetCode;
// 112.Path Sum
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        // Path value condition need that the last node must be a leaf node
        if((sum -= root.val) == 0 && root.left == null && root.right == null) {
            return true;
        }
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }
}
