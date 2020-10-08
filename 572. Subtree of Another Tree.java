// 572. Subtree of Another Tree

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

// 剑指Offer17 wrong answer for leetcode
// class Solution {
//     private boolean subTree(TreeNode s, TreeNode t) {
//         if(t == null) return true;
//         if(s == null) return false;
//         if(t.val != s.val) return false;
//         return subTree(s.left, t.left) && subTree(s.right, t.right);
//     }
    
//     public boolean isSubtree(TreeNode s, TreeNode t) {
//         if(s == null || t == null) return false;
        
//         return subTree(s, t) || subTree(s.left, t) || subTree(s.right, t);
//     }
// }

// class Solution {
//     public boolean isSubtree(TreeNode s, TreeNode t) {
//         return traverse(s, t);
//     }
//     public boolean equals(TreeNode s, TreeNode t) {
//         if(s == null && t == null) return true;
//         if(s == null || t == null) return false;
//         return s.val == t.val && equals(s.left, t.left) && equals(s.right, t.right);
//     }
//     public boolean traverse(TreeNode s, TreeNode t) {
//         return s != null && (equals(s, t) || traverse(s.left, t) || traverse(s.right, t));
//     }
// }

class Solution {
    private boolean equals(TreeNode s, TreeNode t) {
        if(s == null && t == null) return true;
        if(s == null || t == null) return false;
        return s.val == t.val && equals(s.left, t.left) && equals(s.right, t.right);
    }
    
    public boolean isSubtree(TreeNode s, TreeNode t) {
        return s != null && (equals(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t));
    }
}
