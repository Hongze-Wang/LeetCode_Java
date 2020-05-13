// 94. Binary Tree Inorder Traversal
// 数据结构基本操作
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
// 递归是最简单的方法
// class Solution {
//     public List<Integer> inorderTraversal(TreeNode root) {
//         List<Integer> res = new ArrayList<Integer>();
//         inorder(root, res);
//         return res;
        
//     }
//     private void inorder(TreeNode root, List<Integer> list) {
//         if(root == null) return;
//         inorder(root.left, list);
//         list.add(root.val);
//         inorder(root.right, list);
//     }
// }
// 非递归需借助栈来实现
// class Solution {
//     public List<Integer> inorderTraversal(TreeNode root) {
//         if(root == null) return new ArrayList<Integer>();
        
//         List<Integer> res = new ArrayList<>();
//         Stack<TreeNode> stack = new Stack<>();
        
//         TreeNode curr = root;
//         while(curr != null || !stack.isEmpty()) {
//             while(curr != null) {
//                 stack.push(curr);
//                 curr = curr.left;
//             }
//             curr = stack.pop();
//             res.add(curr.val);
//             curr = curr.right;
//         }
//         return res;
//     }
// }
// 除此之外 还有一种我在课堂上没有见过的算法 叫做镜像法
// Step1: Initialize curr as root
// Step2: While curr is not null
//        If curr does not have left child
//              a. Add curr.val
//              b. Go to right child, i.e., curr = curr.right
//        Else
//              a. In curr's left subtree, set curr as the rightmost node
//              b. Go to left child, i.e., curr = curr.left
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) return new ArrayList<Integer>();
        
        List<Integer> res = new ArrayList<>();
        TreeNode curr = root, pre, temp;
        while(curr != null) {
            if(curr.left == null) {
                res.add(curr.val);
                curr = curr.right;
            } else {
                pre = curr.left;
                while(pre.right != null) {
                    pre = pre.right;
                }
                pre.right = curr;
                temp = curr;
                curr = curr.left;
                temp.left = null;
            }
        }
        return res;
    }
}