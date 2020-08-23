// 375. Guess Number Higher or Lower II

// 猿辅导20200822 扩展 可以免费猜k次
// 维持一个容量为k的最大堆
// 最后的结果减去最大堆里的所有元素即可

// 下面是这道题的思路
// dp(i, j) 最大数为j时猜到i所付出的最小代价
// 初始化dp(i, i+1) = i 即最大数为i+1时最少付出的代价为i (猜i对了或者猜低了都能得出答案)

// bottom up DP
// dp(1, n) 即从最大数为n猜到1所付出的代价 即为所求
// dp(i, j) = max(dp(i, k), dp(k+1, j)) + k 用来给dp(i, j)初始化 因为这是需要付出的最高代价
// 即i到j之间 (i+1, j) 开区间 选一个数字k猜测需要付出的代价 大于k则为dp(k+1, j) 小于则为dp(i, k-1) 初始化两者取最大

// 如果dp(i, j)已经初始化 那看一看是否能通过在开区间(i+1, j) 寻找一个k来降低代价
// 循环判断所有可取的k取最小值


class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n+1][n+1];
        for(int i=1; i<n; i++) {
            dp[i][i+1] = i;
        }
        // 从dp(n-2, n) k可取n-1开始 倒推
        for(int i=n-2; i>0; i--) { // dp[n-1][n] = n-1 已初始化 最少考虑i j差2
            for(int j=i+2; j<n+1; j++) {
                for(int k=i+1; k<j; k++) {
                    if(dp[i][j] == 0) { // 未初始化 进行初始化
                        dp[i][j] = Math.max(dp[i][k-1], dp[k+1][j] + k);
                    } else {            // 已经初始化 看能不能找到新的k值 降低代价
                        dp[i][j] = Math.min(dp[i][j], Math.max(dp[i][k-1], dp[k+1][j]) + k);
                    }
                }
            }
        }
        return dp[1][n];
    }
}
