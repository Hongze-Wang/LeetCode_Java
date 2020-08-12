// 236. Lowest Common Ancestor of a Binary Tree

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
// 当前node为null则没有最低公共祖先 返回null
// 当前node为p则p是q的祖先 最低公共祖先即为p 返回p
// 当前node为q则q是p的祖先 最低公共祖先即为q 返回q
// 以上均为递归终止条件 归纳为 if(root == null || root == p || root == q) return root

// 若不是以上情况 则向左子树 右子树深度遍历 左右子树都能找到最低公共结点时 当前节点即为所求
// 否则 从能找到最低公共结点的子树 继续遍历

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        if(left != null && right != null) return root;
        return left != null ? left : right;
    }
}
