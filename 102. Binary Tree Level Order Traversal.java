// 102. Binary Tree Level Order Traversal
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Stack<TreeNode> stack = new LinkedList<TreeNode>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        TreeNode node;
        if(root == null) return res;
        stack.add(root);
        stack.add(null);
        while(stack.size() > 1) {
            node = stack.poll();
            if(node == null) {
                res.add(temp);
                temp = new ArrayList<Integer>();
                stack.add(null);
            } else {
                temp.add(node.val);
                if(node.left != null) {
                    stack.add(node.left);
                }
                if(node.right != null) {
                    stack.add(node.right);
                }
            }
        }
        res.add(temp);
        return res;
    }
}
