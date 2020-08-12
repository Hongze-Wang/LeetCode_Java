// 0001. Binary Tree Longest Path Length
// 添加：求二叉树的最长路径长度

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
    int res = 0;
    public int maxPathLength(TreeNode root) {
        if(root == null) return 0;
        getMaxLength(root);
        return res;
    }

    public int getMaxLength(TreeNode root) {
        if(root == null) return 0;
        int left = getMaxLength(root.left);
        int right = getMaxLength(root.right);
        res = Math.max(res, left + right);
        return Math.max(left, right) + 1;
    }
}
