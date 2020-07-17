// 230. Kth Smallest Element in a BST

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
// class Solution {
//     private ArrayList<Integer> inorder(TreeNode root, ArrayList<Integer> arr) {
//         if(root == null) return arr;
//         inorder(root.left, arr);
//         arr.add(root.val);
//         inorder(root.right, arr);
//         return arr;
//     }
//     public int kthSmallest(TreeNode root, int k) {
//         List<Integer> res = inorder(root, new ArrayList<Integer>());
//         return res.get(k-1);
//     }
// }

class Solution {
    int res=-1, n;
    private void inorder(TreeNode root) {
        if(root == null) return;
        inorder(root.left);
        n--;
        if(n == 0) res = root.val;
        if(n > 0) inorder(root.right);
        
    }
    public int kthSmallest(TreeNode root, int k) {
        n = k;
        inorder(root);
        return res;
    }
}
