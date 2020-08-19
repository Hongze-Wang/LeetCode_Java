// 887. Super Egg Drop
// 美团点评2020算法第一道题 问答形式

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
// 抽象一个函数dp该函数仅与k有关 与moves无关 X


// 假设移动x次,k个鸡蛋,最优解的最坏条件下可以检测n层楼,层数n=黑箱子函数f(x,k)

// 假设从n0+1层丢下鸡蛋,
//     1, 鸡蛋破了
//         剩下x-1次机会和k-1个鸡蛋,可以检测n0层楼
//     2, 鸡蛋没破
//         剩下x-1次机会和k个鸡蛋,可以检测n1层楼
//     那么 临界值层数F在[1,n0+n1+1]中的任何一个值,都都能被检测出来
// 归纳的状态转移方程式为:f(x,k) = f(x-1,k-1)+f(x-1,k)+1,即x次移动的函数值可以由x-1的结果推导,这个思路很抽象,需要花时间去理解,具体看代码,对照着代码理解

// 可以简化为黑箱子函数的返回值只跟鸡蛋个数k有关系:
// 本次fun(k) = 上次fun(k-1)+上次fun(k)+1

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
