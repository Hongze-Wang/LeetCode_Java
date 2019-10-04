package LeetCode;
// 101. Symmetric Tree
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// class Solution {
//     public boolean isSymmetric(TreeNode root) {
//         if(root == null) return true;
//         else return isSymm(root.left, root.right);
//     }

//     private boolean isSymm(TreeNode left, TreeNode right) {
//         if(left == null && right == null) return true;
//         if((left == null || right == null) || left.val != right.val) return false;
//         else return isSymm(left.left, right.right) && isSymm(left.right, right.left);
//     }
// }

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    public boolean isMirror(TreeNode left, TreeNode right) {
        if(left == null && right == null) return true;
        if(left == null || right == null || left.val != right.val) return false;
        else return isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }
}
