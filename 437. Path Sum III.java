// 437. Path Sum III

// use hashmap to speed search
// hashmap maintain the mapping between curSum and its number
// every recusion we use curSum - target to get diff
// if diff always in hashmap, it means that curSum - diff = target
// we find the path sum to target by removing the steps that move from root to diff
// and the hashmap stored how many thses paths exist
// modified ans by increase the value of diff in the hashmap 

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
    int ans = 0;
    private void dfs(TreeNode root, int sum, int target, Map<Integer, Integer> map) {
        if(root == null) return;
        int curSum = sum + root.val;
        int diff = curSum - target;

        if(map.containsKey(diff) && map.get(diff) != 0) {
            ans += map.get(diff);
        }
        map.put(curSum, map.getOrDefault(curSum, 0)+1);
        dfs(root.left, curSum, target, map);
        dfs(root.right, curSum, target, map);
        map.put(curSum, map.get(curSum)-1);
    }

    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> map = new HashMap();
        map.put(0, 1);
        dfs(root, 0, sum, map);
        return ans;
    }
}
