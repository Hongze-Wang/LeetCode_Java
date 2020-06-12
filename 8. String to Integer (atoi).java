// 8. String to Integer (atoi)
// 100% fast solution
// ACSII '0': 48; 'A': 65; 'a': 97
class Solution {
    public int myAtoi(String str) {
        int len = str.length();
        if(str == null || len < 1) return 0;
        
        long res=0;
        int index=0, sign=1;
        while(str.charAt(index) == ' ' && index < len-1) index++;
        if(index == len) return 0;
        
        if(str.charAt(index) == '-') {
            sign=-1;
            index++;
        } else if(str.charAt(index) == '+') {
            index++;
        }
        for(int i=index; i<len; i++) {
            if(str.charAt(i)<'0' || str.charAt(i)>'9') break;
            res = str.charAt(i) -'0' + res * 10;
            if(res>Integer.MAX_VALUE) {
                return sign==1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
        }
        return (int) res * sign;
    }
}
