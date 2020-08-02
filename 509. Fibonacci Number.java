// 509. Fibonacci Number

// in a interview, this question is not ask for your easy recusive solution or 100% dp solution alone.
// it tests your knowledge about multi-various method and your understand about recursive and dp
// the last two math methods are the bonus point

// Approach 1: Recursion
// Standard Solution： Recursion
// class Solution {
//     public int fib(int N) {
//         if(N == 0) return 0;
//         if(N == 1) return 1;
//         return fib(N-1) + fib(N-2);
//     }
// }

// Approach 2: Bottom-Up Approach using Memoization
// 100% faster 5.07% memory less
// class Solution {
//     public int fib(int N) {
//         if(N <= 1) {
//             return N;
//         }
//         return memoize(N);
//     }
//     private int memoize(int n) {
//         int[] memo = new int[n+1];
//         memo[1] = 1;
//         for(int i=2; i<=n; i++) {
//             memo[i] = memo[i-1] + memo[i-2];
//         }
//         return memo[n];
//     }
// }

// Approach 3: Top-Down Approach using Memoization
// Top-Down is worse than Bottom-up in most case
// Because it involves recusive and backtrack two process
// class Solution {
//     private Integer[] cache = new Integer[31];
    
//     public int fib(int N) {
//         if(N <= 1) return N;
//         cache[0] = 0;
//         cache[1] = 1;
//         return memoize(N);
//     }
    
//     public int memoize(int N) {
//         if(cache[N] != null) {
//             return cache[N];
//         }
//         cache[N] = memoize(N-1) + memoize(N-2);
//         return memoize(N);
//     }
// }

// Approach 4: Iterative Top-Down Approach
// shoudle be correctfied as Iterative Bottom up  
// class Solution {
//     public int fib(int N) {
//         if(N <= 1) {
//             return N;
//         }
//         if(N == 2) {
//             return 1;
//         }
//         int cur = 0, prev1 = 1, prev2 = 1;
//         for(int i=3; i<=N; i++) {
//             cur = prev1 + prev2;
//             prev2 = prev1;
//             prev1 = cur;
//         }
//         return cur;
//     }
// }

// Approach 5: Matrix Exponentiation
// (1 1)^n  = (F(n+1) F(n))
// (1 0)      (F(n)   F(n-1))

// class Solution {
//     public int fib(int N) {
//         if(N <= 1) return N;
//         int[][] A = new int[][]{{1, 1}, {1, 0}};
//         matrixPower(A, N-1);
        
//         return A[0][0];
//     }
//     public void matrixPower(int[][] A, int N) {
//         if(N <= 1) return;
//         matrixPower(A, N/2);
//         multiply(A, A);
        
//         int[][] B = new int[][]{{1, 1}, {1, 0}};
//         if(N%2 != 0) {
//             multiply(A, B);
//         }
//     }
//     public void multiply(int[][] A, int[][] B) {
//         int x = A[0][0] * B[0][0] + A[0][1] * B[1][0];
//         int y = A[0][0] * B[0][1] + A[0][1] * B[1][1];
//         int z = A[1][0] * B[0][0] + A[1][1] * B[1][0];
//         int w = A[1][0] * B[0][1] + A[1][1] * B[1][1];
        
//         A[0][0] = x;
//         A[0][1] = y;
//         A[1][0] = z;
//         A[1][1] = w;
//     }
// }


// Approach 6: Math
class Solution {
    public int fib(int N) {
        double goldRatio = (1 + Math.sqrt(5)) / 2;
        return (int) Math.round(Math.pow(goldRatio, N) / Math.sqrt(5));
    }
}
