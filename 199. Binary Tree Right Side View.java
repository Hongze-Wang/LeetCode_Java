// 199. Binary Tree Right Side View

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
    private void rightSideView(TreeNode root, List<Integer> res, int level) {
        if(root == null) return;
        if(res.size() < level) {
            res.add(root.val);
        }
        rightSideView(root.right, res, level+1);
        rightSideView(root.left, res, level+1);
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList();
        rightSideView(root, res, 1);
        return res;
    }
}
