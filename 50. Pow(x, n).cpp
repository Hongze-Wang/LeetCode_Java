// 50. Pow(x, n)

class Solution {
public:
    double findPow(double x, int n) {
        if(n == 1) return x;
        double res = findPow(x, n/2);
        if((n&1) != 0) { // (n%2 == 0))
            return x * res * res;
        } else {
           return res * res;
        }
    }
    double myPow(double x, int n) {
        if(x == 0) return 0.0;
        if(x == 1 || n==0) return 1;
        if(n == INT_MIN) {
            return 1 / (x * findPow(x, -(n+1)));
        }
        return n<0 ? 1/findPow(x, -n) : findPow(x, n);
    }
};
