// 113. Path Sum II

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, sum, res, new ArrayList());
        return res;
    }

    public void dfs(TreeNode root, int sum, List<List<Integer>> res, List<Integer> list) {
        if(root == null) return;
        
        sum -= root.val;
        list.add(root.val);
        
        if(root.left == null && root.right == null) {
            if(sum == 0) {
                res.add(new ArrayList(list));
            }
            list.remove(list.size()-1);
            // sum += root.val; 不再向下递归 这一句有没有都一样
            return;
        }
        dfs(root.left, sum, res, list);
        dfs(root.right, sum, res, list);
        list.remove(list.size()-1);
        // sum += root.val; 不再向下递归 这一句有没有都一样
    }
}
