// 515. Find Largest Value in Each Tree Row

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

// level order traversal, store the maximum element in every for loop

// class Solution {
//     public List<Integer> largestValues(TreeNode root) {
//         List<Integer> res = new ArrayList<>();
//         if(root == null) return res;
        
//         Queue<TreeNode> queue = new LinkedList<>();
//         queue.offer(root);
//         while(!queue.isEmpty()) {
//             int max = Integer.MIN_VALUE;
//             int len = queue.size();
//             for(int i=0; i<len; i++) {
//                 TreeNode node = queue.poll();
//                 max = Math.max(max, node.val);
//                 if(node.left != null) {
//                     queue.offer(node.left);
//                 }
//                 if(node.right != null) {
//                     queue.offer(node.right);
//                 }
//             }
//             res.add(max);
//         }
//         return res;
//     }
// }

// 使用存储结果的arraylist大小以及层号作为判断依据
// 每一个层号对应一个最大值
// 递归访问树上每一个元素 层号小于结果集大小时 需要按层号更新最大值
// 结果集大小小于等于层号时 访问的是新的一层的第一个结点 直接加入结果集 供后面更新

class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        
        getLargestValues(root, 0, res);
        return res;
    }
    
    public void getLargestValues(TreeNode root, int index, List<Integer> res) {
        if(root == null) return;
        
        if(res.size() > index) {
            int max = Math.max(res.get(index), root.val);
            res.set(index, max);
        } else {
            res.add(root.val);
        }
        getLargestValues(root.left, index+1, res);
        getLargestValues(root.right, index+1, res);
    }
}