// 103. Binary Tree Zigzag Level Order Traversal

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

// 广搜层次遍历 设置一个计数位 0直接访问 奇数从右至左(取逆) 偶数从左至右

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        if(root == null) return res;
        
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        int level = 0;
        while(!queue.isEmpty()) {
            int len = queue.size();
            ArrayList<Integer> list = new ArrayList();
            for(int i=0; i<len; i++) {
                TreeNode cur = queue.poll();
                list.add(cur.val);
                if(cur.left != null) {
                    queue.add(cur.left);
                }
                if(cur.right != null) {
                    queue.add(cur.right);
                }
            }
            level++;
            if((level & 1) == 0) {
                Collections.reverse(list);
            }
            res.add(list);
        }
        return res;
    }
}
