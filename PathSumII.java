package LeetCode;
// 113.Path Sum II
import java.util.ArrayList;
import java.util.List;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, sum, res, new ArrayList());
        return res;
    }

    public void dfs(TreeNode root, int sum, List<List<Integer>> res, List<Integer> list) {
        if(root == null) {
            return;
        }
        list.add(root.val);
        sum -= root.val;

        if(root.left == null && root.right == null) {
            if(sum == 0) {
                res.add(new ArrayList(list));
            }
            list.remove(list.size() - 1);
            return;
        }
        dfs(root.left, sum, res, list);
        dfs(root.right, sum, res, list);
        list.remove(list.size() - 1);

        return;
    }
}
