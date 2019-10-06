// 171. Excel Sheet Column Number 
// opposite as question 168

// 99.98% faster 100% less memory
class Solution {
    public int titleToNumber(String s) {
        if(s == null) return 0;
        int res = 0, digit = 0;
        
        for(int i = s.length() - 1; i >= 0; i--) {
            int temp = (s.charAt(i) - 64) * (int)Math.pow(26, digit);
  
            res += temp;
            digit++;
        }
        return res;
    }
}

// The follows can't improve this above to 100% faster
// 99.98% faster 100% less memory

class Solution {
    public int titleToNumber(String s) {
        // if(s == null) return 0;
        int res = 0, digit = 1;
        
        for(int i = s.length() - 1; i >= 0; i--) {
            int temp = (s.charAt(i) - 64) * digit;
  
            res += temp;
            digit *= 26;
        }
        return res;
    }
}