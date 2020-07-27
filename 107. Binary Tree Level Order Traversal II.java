package LeetCode;

import java.util.ArrayList;
import java.util.List;

// 107. Binary Tree Level Order Traversal II
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// public class BinaryTreeLevelOrderTraversalII {
//     List<List<Integer>> result;

//     public List<List<Integer>> levelOrderBottom(TreeNode root) {
//         result = new ArrayList<>();

//         bfs(root, 0);
//         List<List<Integer>> output = new ArrayList<>();
//         for(List<Integer> res: result) {
//             output.add(0, res);
//         }
//         return output;
//     }

//     void bfs(TreeNode root, int level) {
//         if(root == null) { return; }
//         if(result.size() == level) {
//             List<Integer> list = new ArrayList<>();
//             result.add(list);
//         }
//         result.get(level).add(root.val);

//         bfs(root.left, level+1);
//         bfs(root.right, level+1);
//     }
// }

public class Solution {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        BFS(pRoot, 1, res);
        return res;
    }
    private void BFS(TreeNode root, int depth, ArrayList<ArrayList<Integer>> list) {
        if(root == null) return;
        if(depth > list.size()) {
            list.add(new ArrayList<Integer>());
        }
        list.get(depth-1).add(root.val);
        BFS(root.left, depth+1, list);
        BFS(root.right, depth+1, list);
    }
}
