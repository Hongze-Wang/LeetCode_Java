package LeetCode;
// 125. Valid Palindrome
/*
class Solution {
    public boolean isPalindrome(String s) {
        if(s == null || s.length() == 0 || s.length() == 1) return true;

        s = s.replaceAll("[^a-zA-Z0-9]", "");
        s = s.toLowerCase();

        int mid = s.length()/2;
        int low = 0;
        int high = s.length()-1;

        while(low <= mid && high >= mid) {
            if(s.charAt(low) != s.charAt(high)) return false;
            low++;
            high--;
        }

        return true;
    }
}
*/

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        // if(s == null || s.length() == 0 || s.length()==1) return true;

        int i=0, j=s.length()-1;
        char[] c = s.toCharArray();

        while(i < j) {
            if(c[i] >= 'A' && c[i] <= 'Z') c[i] += 'a'-'A';
            if(c[j] >= 'A' && c[j] <= 'Z') c[j] += 'a'-'A';
            if(!(c[i] >= 'a' && c[i] <= 'z' || c[i] >= '0' && c[i] <= '9')) {
                i++;
                continue;
            }
            if(!(c[j] >= 'a' && c[j] <= 'z' || c[j] >= '0' && c[j] <= '9')) {
                j--;
                continue;
            }
            if(c[i] != c[j]) return false;
            i++;
            j--;
        }
        return true;
    }
}
