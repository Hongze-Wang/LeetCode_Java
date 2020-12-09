// 105. Construct Binary Tree from Preorder and Inorder Traversal

// 使用HashMap加速索引

class Solution {
    HashMap<Integer, Integer> map = new HashMap();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(inorder, preorder, 0, inorder.length-1, 0);
    } 

    public TreeNode buildTree(int[] inoider, int[] preorder, int left, int right, int rootIndex) {
        if(left > right) return null;
 
        TreeNode root = new TreeNode(preorder[rootIndex]);
        int p = map.get(val);
        
        root.left = buildTree(inorder, preorder, left, p-1, rootIndex+1);
        root.right = buildTree(inorder, preorder, p+1, right, rootIndex+1+(p-left)); // p-left has been used
        return root;
    }
}
