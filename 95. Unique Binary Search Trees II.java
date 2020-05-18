// 95. Unique Binary Search Trees II
// G(n) = f(1)+f(2)+...+f(n)
// f(i) = G(i-1) * G(n-i)
// see 96 for more info
// Recursive solution easy understand
class Solution {
    public List<TreeNode> generateTrees(int n) {
        if(n == 0) return new ArrayList<>();
        return generator(1, n);
    }

    private List<TreeNode> generator(int low, int high) {
        List<TreeNode> res = new ArrayList<>();
        if(low > high) {
            res.add(null);
            return res; // 树的定义中 空树也算一棵树
        }
        for(int i=low; i<=high; i++) {
            List<TreeNode> leftTree = generator(low, i-1);   // 生成左子树
            List<TreeNode> rightTree = generator(i+1, high); // 生成右子树
            for(TreeNode lnode: leftTree) { // 所有的左子树和右子树都以i为根节点连接成一颗树
                for(TreeNode rnode: rightTree) {
                    TreeNode root = new TreeNode(i);
                    root.left = lnode;
                    root.right = rnode;
                    res.add(root)；
                }
            }
        }
        return res;
    }
}