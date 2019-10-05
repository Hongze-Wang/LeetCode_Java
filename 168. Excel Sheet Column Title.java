// 168. Excel Sheet Column Title

// 本质上是进制转换问题 10进制转26进制
// 辗转相除的思想
// When rem != 26 "n -= rem; can be saved, but rem can be 26
// So it only handle when rem = 26
class Solution {
    public String convertToTitle(int n) {
        String column = "";
        char letter;
        int rem;
        while(n != 0) {
            rem = n % 26;
            if(rem == 0) {
                rem = 26;
            }
            letter = (char) (rem+64);
            column = letter + column;
            n -= rem;  // n - 26
            n /= 26;
        }
        return column;
    }
}