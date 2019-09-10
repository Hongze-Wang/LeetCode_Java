package LeetCode;
// 70. Climbing Stairs
/*
// Appraoch 1: Brute Force
// climbStairs(i, n) = climbStairs(i+1, n) + climbStairs(i+2,n)
public class Solution {
    public int climbStairs(int n) {
        return climb_Stairs(0, n);
    }
    public int climb_Stairs(int i, int n) {
        if(i>n) return 0;
        if(i==n) return 1;

        return climb_Stairs(i+1, n) + climb_Stairs(i+2, n)

    }
}


// Time: O(2^n) because the size of the recursion tree is 2^n
// Space: O(n) because the depth of the recursion trss is n

// Approach 2: Recursion with Memoization
// Memoization is a common trick to reduce repeat computation in Recursion
// Appiled frequently in dynamic programming
public class Solution {
    public int climbStairs(int n) {
        int memo[] = new int[n+1];
        return climb_Stairs(0, n, memo);
    }
    public int climb_Stairs(int i, int n, int memo[]) {
        if(i>n) return 0;
        if(i==n) return 1;
        if(memo[i]>0) return memo[i];

        memo[i] = climb_Stairs(i+1, n, memo) + climb_Stairs(i+2, n, memo);
        return memo[i];
    }
}
// Time: O(n) because the size of the recursion tree is reduced to n
// Why? Because when if(memo[i]>0), we return, no recusion there
// Space: O(n) because the depth of the recursion trss is n

// Approach 3: Dynamic Programming
// One can always reach ith step in two ways
// 1. Taking a single step from (i-1)th step
// 2. Taking a step of 2 from (i-2) step
// So the recursion formula is dp[i] = dp[i-1] + dp[i-2]
public class Solution{
    public int climbStairs(int n) {
        if(n==1) return 1;

        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3; i<=n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
// Time complexity : O(n). Single loop upto n.
// Space complexity : O(n). dp array of size n is used
*/
public class ClimbingStairs {
    public int climbStairs(int n) {
        int nums[] = new int[n+1];

        for(int i=0; i<n+1; i++) {
            nums[i] = i;
        }

        for(int i=4; i<n+1; i++){
            nums[i] = nums[i-2] + nums[i-1];
        }

        return nums[n];
    }
}
