// 202. Happy Number

// Square Sum < 1000
// Because int 10 digits 10 * (9^2) = 810 
class Solution {
public:
    int calSquareSum(int n) {
        int sum = 0;
        while(n != 0) {
            sum += (n%10) * (n%10);
            n /= 10;
        }
        return sum;
    }
    bool isHappy(int n) {
        vector<bool> seen = vector<bool>(1000, false);
        n = calSquareSum(n);

        while(!seen[n]) {
            if(n == 1) return true;
            seen[n] = true;
            n = calSquareSum(n);
        }
        return false;
    }
};