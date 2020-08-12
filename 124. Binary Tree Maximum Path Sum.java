// 124. Binary Tree Maximum Path Sum

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

// 最大值有两种情况 包含当前结点和左右节点的路径和 或者 仅包含当前结点与左子树路径和或右子树路径和

class Solution {
    int res = Integer.MIN_VALUE;
    public int maxSum(TreeNode root) {
        if(root == null) return 0;
        int left = maxSum(root.left), right = maxSum(root.right);
        int maxSingle = Math.max(Math.max(left, right) + root.val, root.val);
        int maxTop = Math.max(maxSingle, left + right + root.val);
        res = Math.max(res, maxTop);
        return maxSingle;
    }
    public int maxPathSum(TreeNode root) {
        maxSum(root);
        return res;
    }
}
