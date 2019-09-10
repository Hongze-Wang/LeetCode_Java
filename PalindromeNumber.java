package LeetCode;
// 9. Palindrome Number
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        String num = x + "";

        for(int i=0, j=num.length()-1; i<j; i++) {
            if(num.charAt(i) == num.charAt(j))
                j--;
            else {
                return false;
            }
        }
        return true;
    }
}
