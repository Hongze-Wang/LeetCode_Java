// 297. Serialize and Deserialize Binary Tree

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    // 仅有前序遍历序列是无法确定二叉树的 因此提供的序列是层次访问序列
    public String serialize(TreeNode root) {
        if(root == null) return "null";
        Queue<TreeNode> queue = new LinkedList();
        StringBuilder sb = new StringBuilder();
        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if(cur == null) {
                sb.append("null ");
                continue;
            } else {
                sb.append(cur.val + " ");
            }
            queue.offer(cur.left);
            queue.offer(cur.right);
        }
        return sb.toString();
    }
    
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.equals("null")) return null;
        String[] s = data.split(" ");
        Queue<TreeNode> queue = new LinkedList();
        TreeNode root = new TreeNode(Integer.parseInt(s[0]));
        queue.offer(root);
        for(int i=1; i<s.length; i++) {
            TreeNode cur = queue.poll();
            if(!s[i].equals("null")) {
                cur.left = new TreeNode(Integer.parseInt(s[i]));
                queue.offer(cur.left);
            }
            if(!s[++i].equals("null")) {
                cur.right = new TreeNode(Integer.parseInt(s[i]));
                queue.offer(cur.right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
