// 513. Find Bottom Left Tree Value

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

// 层次遍历 右节点先入，左节点后入
// class Solution {
//     public int findBottomLeftValue(TreeNode root) {
//         TreeNode cur = null;
//         Queue<TreeNode> que = new LinkedList();
//         que.offer(root);
//         while(!que.isEmpty()) {
//             cur = que.poll();
//             if(cur.right != null) {
//                 que.offer(cur.right);
//             }
//             if(cur.left != null) {
//                 que.offer(cur.left);
//             }
//         }
//         return cur.val;
//     }
// }

class Solution {
    private int maxHeight=0, res=0;
    private void dfs(TreeNode root, int height) {
        if(root == null) return;
        if(height > maxHeight) {
            maxHeight = height;
            res = root.val;
        }
        dfs(root.left, height+1);
        dfs(root.right, height+1);
    }
    
    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 1);
        return res;
    } 
}
