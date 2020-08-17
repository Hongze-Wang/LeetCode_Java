// 55. Jump Game

// The Solution of this question is very detail and inspring
// I recommend you to read it for more info and idea: https://leetcode.com/problems/jump-game/solution/

// Usually, solving and fully understanding a dynamic programming problem is a 4 step process:
// Start with the recursive backtracking solution
// Optimize by using a memoization table (top-down dynamic programming)
// Remove the need for recursion (bottom-up dynamic programming)
// Apply final tricks to reduce the time / memory complexity

// Approach 1: Backtracking (Brute Force)
// check every pos from curr pos and all the reachable
// Time Limit Exceeded
// class Solution {
//     public boolean canJumpFromPosition(int pos, int[] nums) {
//         if(pos == nums.length - 1) {
//             return true;
//         }
//         int fur = Math.min(pos + nums[pos], nums.length-1);
//         for(int next = pos+1; next<=fur; next++) {
//             if(canJumpFromPosition(next, nums)) {
//                 return true;
//             }
//         }
//         return false;
//     }
//     public boolean canJump(int[] nums) {
//         return canJumpFromPosition(0, nums);
//     }
// }

// Approach 1: Backtracking (Brute Force) Optimized
// check every pos from curr pos and all the reachable from right to left
// this means we always try to make the biggest jump such that we reach the end as soon as possible (greedy policy)
// Time Limit Exceeded
// class Solution {
//     public boolean canJumpFromPosition(int pos, int[] nums) {
//         if(pos == nums.length - 1) {
//             return true;
//         }
//         int fur = Math.min(pos + nums[pos], nums.length-1);
//         for(int next = fur; next>pos; next--) {
//             if(canJumpFromPosition(next, nums)) {
//                 return true;
//             }
//         }
//         return false;
//     }
//     public boolean canJump(int[] nums) {
//         return canJumpFromPosition(0, nums);
//     }
// }

// Approach 2: Dynamic Programming Top-down
// It relies on the observation that once we determine that a certain index is good / bad, this result will never change. 
// This means that we can store the result and not need to recompute it every time.
// memoization

// enum Index {
//     GOOD, BAD, UNKNOW
// }

// public class Solution {
//     Index[] memo;
    
//     public boolean canJumpFromPosition(int pos, int[] nums) {
//         if(memo[pos] != Index.UNKNOW) {
//             return memo[pos] == Index.GOOD ? true : false;
//         }
//         int fur = Math.min(pos+nums[pos], nums.length-1);
//         for(int next=pos+1; next<=fur; next++) {
//             if(canJumpFromPosition(next, nums)) {
//                 memo[pos] = Index.GOOD;
//                 return true;   
//             }
//         }
//         memo[pos] = Index.BAD;
//         return false;
//     }
    
//     public boolean canJump(int[ ] nums) {
//         memo = new Index[nums.length];
//         for(int i=0; i<memo.length; i++) {
//             memo[i] = Index.UNKNOW;
//         }
//         memo[memo.length-1] = Index.GOOD;
//         return canJumpFromPosition(0, nums);
//     }
// }

// Top down dp
// public class Solution {
//     public boolean canJumpFromPostion(int pos, int[] nums, int[] memo) {
//         if(memo[pos] != 0) {
//             return memo[pos] == 1 ? true : false;
//         }
//         int fur = Math.min(pos+nums[pos], nums.length-1);
//         for(int next=pos+1; next <= fur; next++) {
//             if(canJumpFromPostion(next, nums, memo)) {
//                 memo[pos] = 1;
//                 return true;
//             }
//         }
//         memo[pos] = 2;
//         return false;
//     }

//     public boolean canJump(int[] nums) {
//         int[] memo = new int[nums.length];
//         memo[nums.length-1] = 1;
//         return canJumpFromPostion(0, nums, memo);
//     }
// }

// Approach 3: Dynamic Programming Bottom-up
// Top-down to bottom-up conversion is done by eliminating recursion
// The recursion is usually eliminated by trying to reverse the order of the steps from the top-down approach.

// enum Index {
//     GOOD, BAD, UNKNOW
// }

// public class Solution {
//     public boolean canJump(int[] nums) {
//         Index[] memo = new Index[nums.length];
//         for(int i=0; i<nums.length; i++) {
//             memo[i] = Index.UNKNOW;
//         }
//         memo[nums.length-1] = Index.GOOD;
//         for(int i=nums.length-2; i>=0; i--) {
//             int fur = Math.min(i+nums[i], nums.length-1);
//             for(int j=i+1; j<=fur; j++) {
//                 if(memo[j] == Index.GOOD) {
//                     memo[i] = Index.GOOD;
//                     break;
//                 } 
//             }
//         }
//         return memo[0] == Index.GOOD;
//     }
// }

// Bottom up dp
// public class Solution {
//     public boolean canJump(int[] nums) {
//         int[] memo = new int[nums.length];
//         memo[nums.length-1] = 1;
        
//         for(int i=nums.length-2; i>=0; i--) {
//             int fur = Math.min(i+nums[i], nums.length-1);
//             for(int j=i+1; j<=fur; j++) {
//                 if(memo[j] == 1) {
//                     memo[i] = 1;
//                     break;
//                 }
//             }
//         }
//         return memo[0] == 1;
//     }
// }

// Approach 4: Greedy
// Greedy Policy 
// try to make the biggest jump such that we reach the start from the end as soon as possible
public class Solution {
    public boolean canJump(int[] nums) {
        int lastPos = nums.length-1;
        for(int i=nums.length-1; i>=0; i--) {
            if(i+nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }
}
