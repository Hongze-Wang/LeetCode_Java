// 29. Divide Two Integers

// Brute Force: use substraction
// class Solution {
//     public int divide(int dividend, int divisor) {
//         if(dividend==Integer.MIN_VALUE && divisor==-1)return Integer.MAX_VALUE;
//         if(divisor==1)return dividend;
    
//         int count=0;
//         int divi=Math.abs(dividend);
//         int div=Math.abs(divisor);
//         while((divi-div)>=0){
//             if(count==Integer.MAX_VALUE) return Integer.MAX_VALUE;
//             else count++;
//             divi-=div;
//         }
//         if((divisor<0 && dividend>=0) || (divisor>=0 && dividend<0)) return count*(-1);
//         return count;
//     }
// }


// bit operation
// // judgu if the sigh of the two int number is equal
// // ((a >> 31) ^ (b >> 31)) == 0
class Solution {
    public int divide(int dividend, int divisor) {
        int sigh = ((dividend < 0) != (divisor < 0)) ? -1 : 1;
        // overflow
        if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        return sigh * dividePositiveNum(Math.abs((long) dividend), Math.abs((long) divisor));
    }
    public int dividePositiveNum(long dividend, long divisor) {
        int bit = 0, res = 0;
        while((dividend >> (bit+1)) >= divisor) {
            bit++;
        }
        while(bit >= 0) {
            if(dividend >= (divisor << bit)) {
                dividend -= divisor << bit;
                res |= (1 << bit);
            }
            bit--;
        }
        return res;
    }
}
