// 887. Super Egg Drop

// 解释参见: https://www.jianshu.com/p/50103a152617

class Solution {
    public int superEggDrop(int K, int N) {
        if(K == 0 && N != 0) return -1;
        int[] dp = new int[K+1];

        for(int i=1; i<N+1; i++) {
            for(int k=K; k>0; k--) {
                dp[k] += dp[k-1] + 1;
                if(dp[k] >= N) return i;
            }
        }
        return N;
    }
}

// dp[k] = dp[k] + dp[k-1] + 1
// 以上计算式，是从以下转移方程简化而来
// 抽象一个函数dp该函数仅与k有关 与moves无关

// dp[moves][k] = 1 + dp[moves-1][k-1] + dp[moves-1][k] 
// 假设 dp[moves-1][k-1] = n0, dp[moves-1][k] = n1
// 首先检测，从第 n0+1 楼丢下鸡蛋会不会破。
// 如果鸡蛋破了，F 一定是在 [1：n0] 楼中，
//      利用剩下的 moves-1 次机会和 k-1 个鸡蛋，可以把 F 找出来。
// 如果鸡蛋没破，假如 F 在 [n0+2:n0+n1+1] 楼中
//      利用剩下的 moves-1 次机会和 k 个鸡蛋把，也可以把 F 找出来。
// 所以，当有 moves 个放置机会和 k 个鸡蛋的时候
// F 在 [1, n0+n1+1] 中的任何一楼，都能够被检测出来。
// 当n0+n1+1 >= N时 F处于一定能被检测的位置 问题求解结束 此时的i即为moves

class Solution {
    public int superEggDrop(int K, int N) {
        if(K == 0 && N != 0) return -1;
        int[][] dp = new int[N+1][K+1];

        for(int i=1; i<N+1; i++) {
            for(int k=K; k>0; k--) {
                dp[i][k] = dp[i-1][k-1] + dp[i-1][k] + 1;
                if(dp[i][k] >= N) return i;
            }
        }
        return N;
    }
}
