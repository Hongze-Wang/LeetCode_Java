// 50. Pow(x, n)

// Time Limit Exceeded
// class Solution {
//     public double myPow(double x, int n) {
//         double res=1.0;
//         if(n == 0) return 1;
//         for(int i=0; i<Math.abs(n); i++) {
//             res *= x;
//         }
//         return n > 0 ? res : 1/res;
//     }
// }

class Solution {
    private double findPow(double x, int n) {
        if(n == 1) return x;
        double res = findPow(x, n/2);
        if((n&1) != 0) {
            return x * res * res;
        } else {
            return res * res;
        }
    }
    public double myPow(double x, int n) {
        if(x == 0) return 0.0;
        if(x == 1 || n == 0) return 1.0;
        if(n == Integer.MIN_VALUE) {
            return 1 / (x * findPow(x, -(n+1)));
        }
        return n>0 ? findPow(x, n) : 1 / findPow(x, -n);
    }
}
