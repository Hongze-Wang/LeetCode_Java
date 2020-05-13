// 5. Longest Palindromic Substring

// recursion
// remove from whole string to the target palindrome
// Time Limit Exceeded but idea that is worth learn
// class Solution {
//     public String longestPalindrome(String s) {
//         if(s == null || s.length() < 1) return "";
//         if(isPalindrome(s)) return s;
//         int n=s.length();
//         String left = longestPalindrome(s.substring(1, n));
//         String right = longestPalindrome(s.substring(0, n-1));

//         return left.length() > right.length() ? left : right; 
//     }
//     private boolean isPalindrome(String s) {
//         StringBuilder str = new StringBuilder(s); // StringBuffer is also ok but higher compution cost
//         str.reverse();
//         return s.equals(str.toString());
//     }
// }

// // stand soution
// expand from one or two char
// class Solution {
//     public String longestPalindrome(String s) {
//         if(s == null || s.length() < 1) return "";
//         int start = 0, end = 0;
//         for(int i=0; i<s.length(); i++) {
//             int len1 = expandAroundCenter(s, i, i);
//             int len2 = expandAroundCenter(s, i, i+1);
//             int len = Math.max(len1, len2);
//             if(len > end - start) {
//                 start = i - (len-1) / 2;
//                 end = i + len / 2;
//             }
//         }
//         return s.substring(start, end+1);
//     }
//     private int expandAroundCenter(String s, int left, int right) {
//         int l = left, r = right;
//         while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
//             l--;
//             r++;
//         }
//         return r-l-1;
//     }
// }

class Solution {
    public String longestPalindrome(String s) {
        int len;
        if(s == null || (len=s.length()) < 2) return s;

        int maxlen = 0;
        int start = 0;
        for(int i=0; i < len;) {
            int left = i, right = i;
            char c = s.charAt(i);

            while(right+1 < len && s.charAt(right+1) == c) {
                right++;
            }

            i = 1 + (left == right ? i : right); // core why it's fastest

            while(left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            
            if(maxlen < right-left-1) {
                maxlen = right-left-1;
                start = left+1;
            }
        }
        return s.substring(start, start+maxlen);
    }
}