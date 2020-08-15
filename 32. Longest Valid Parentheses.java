// 32. Longest Valid Parentheses

// brute force: Time Limit Exceeded

// class Solution {
//     public boolean isValid(String s) {
//         Stack<Character> stack = new Stack();
//         for(int i=0; i<s.length(); i++) {
//             if(s.charAt(i) == '(') {
//                 stack.push('(');
//             } else if(!stack.empty() && stack.peek() == '(') {
//                 stack.pop();
//             } else {
//                 return false;
//             }
//         }
//         return stack.empty();
//     }
//     public int longestValidParentheses(String s) {
//         int maxLen = 0, strLen = s.length();
//         for(int i=0; i<strLen; i++) {
//             for(int j=i+2; j<=strLen; j+=2) {
//                 if(isValid(s.substring(i ,j))) {
//                     maxLen = Math.max(maxLen, j-i);
//                 }
//             }
//         }
//         return maxLen;
//     }
// }

// DP
// if s[i] = ')'
//    if s[i-1] = '(' we found one valid "()"                dp[i] = dp[i-2] + 2
//    else if s[i-dp[i-1]-1] == '(' we found one valid "()"  dp[i] = dp[i-dp[i-1]-2] + 2 

// explanation
// s [i-dp[i-1]-1] means that the first '(' after dp[i-1] pair "()"
// dp [i - dp[i-1] - 2] store the number of '()' pair before current match

class Solution {
    public int longestValidParentheses(String s) {
        int max = 0, strLen = s.length();
        int dp[] = new int[strLen];
        for(int i=1; i<strLen; i++) {
            if(s.charAt(i) == ')') {
                if(s.charAt(i-1) == '(') {
                    dp[i] = (i >= 2 ? dp[i-2] : 0) + 2;
                } else if(i - dp[i-1] > 0 && s.charAt(i-dp[i-1]-1) == '(') {
                    dp[i] = dp[i-1] + (i-dp[i-1] >= 2 ? dp[i-dp[i-1]-2] : 0) + 2;
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}


// using stack
class Solution {
    public int longestValidParentheses(String s) {
        int max = 0;
        Stack<Integer> stack = new Stack();
        stack.push(-1);
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if(stack.empty()) {
                    stack.push(i);
                } else {
                    max = Math.max(max, i-stack.peek());
                }
            }
        }
        return max;
    }
}
