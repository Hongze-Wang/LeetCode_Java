// 22. Generate Parentheses
// Approach 2: Backtracking

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList();
        backtrack(res, "", 0, 0, n);
        return res;
    }
    private void backtrack(List<String> ans, String cur, int open, int close, int max) {
        if(cur.length() == max*2) {
            ans.add(cur);
            return;
        }
        if(open < max) {
            backtrack(ans, cur+"(", open+1, close, max);
        }
        if(close < open) {
            backtrack(ans, cur+")", open, close+1, max);
        }
    }
}

// class Solution {
//     public List<String> generateParenthesis(int n) {
//         List<String> res = new ArrayList();
//         if(n == 0) {
//             res.add("");
//         } else {
//             for(int c=0; c<n; c++) {
//                 for(String left: generateParenthesis(c)) {
//                     for(String right: generateParenthesis(n-1-c)) {
//                         res.add("(" + left + ")" + right);
//                     }
//                 }
//             }
//         }
//         return res;
//     }
// }
