// 224. Basic Calculator

// class Solution {
//     public int calculate(String s) {
//         Stack<Integer> stack = new Stack<>();
//         int op = 0, sign = 1, res = 0;
        
//         for(int i=0; i<s.length(); i++) {
//             char c = s.charAt(i);
//             if(Character.isDigit(c)) {
//                 op = op * 10 + c - '0'; // cumulate mutil-digits oprand
//             } else if(c == '(') {
//                 stack.push(res); // store the result outside the () in the stack as oprand
//                 stack.push(sign); // store the corresponding sign in the stack
//                 sign = 1; // new computation start, so reset sign
//                 res = 0;  // new computation start, so reset res
//             } else if(c == '+') {
//                 res += sign * op; // finish last computation
//                 sign = 1; // new add operation reset sign
//                 op = 0;   // new add operation reset op
//             } else if(c == '-') {
//                 res += sign * op; // finish last computation
//                 sign = -1; // new minus operation reset sign
//                 op = 0;    // new minus operation reset op
//             } else if(c == ')') {
//                 res += sign * op; // finish last computation
//                 res *= stack.pop(); // recover the sign of the ()
//                 res += stack.pop(); // revover the oprand outside the () and perform computation
//                 op = 0;             // new computation start reset op;
//             }
//         }
        
//         res += sign * op; // do not forget the last computation
        
//         return res;
//     }
// }

class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int op = 0, sign = 1, res = 0;
        char[] strs = s.toCharArray();
        
        for(int i=0; i<s.length(); i++) {
            if(Character.isDigit(strs[i])) {
                op = op * 10 + strs[i] - '0'; // cumulate mutil-digits oprand
            } else if(strs[i] == '(') {
                stack.push(res); // store the result outside the () in the stack as oprand
                stack.push(sign); // store the corresponding sign in the stack
                sign = 1; // new computation start, so reset sign
                res = 0;  // new computation start, so reset res
            } else if(strs[i] == '+') {
                res += sign * op; // finish last computation
                sign = 1; // new add operation reset sign
                op = 0;   // new add operation reset op
            } else if(strs[i] == '-') {
                res += sign * op; // finish last computation
                sign = -1; // new minus operation reset sign
                op = 0;    // new minus operation reset op
            } else if(strs[i] == ')') {
                res += sign * op; // finish last computation
                res *= stack.pop(); // recover the sign of the ()
                res += stack.pop(); // revover the oprand outside the () and perform computation
                op = 0;             // new computation start reset op;
            }
        }
        
        res += sign * op; // do not forget the last computation
        
        return res;
    }
}