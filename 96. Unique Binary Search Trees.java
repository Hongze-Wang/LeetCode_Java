// 96. Unique Binary Search Trees
// denote the number of binary search trees in n nodes as G (n)
// denote the number of binary search tree rooted at i as f(n)
// G(n) = f(1)+f(2)+...+f(n)
// f(i) = G(i-1) * G(n-i)
// 即以i为根的二叉搜索树的数目 = i-1个结点构成的左子树的数目 * （n-i）个结点组成的右子树的数目
// G(n) = G(0)*G(n-1)+G(1)*G(n-2)+...+G(n-1)*G(0) Catalan formula
class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=i; j++) {
                dp[i] += dp[j-1] * dp[i-j];
            }
        }
        return dp[n];
    }
}