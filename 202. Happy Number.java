// 202. Happy Number

// Using HashSet
// Using a boolean array to hash the sum already calculated

class Solution {
    public boolean isHappy(int n) {
        HashSet set = new HashSet<>();
        while(n != 1) {
            n = calSquareSum(n);
            if(n == 1) return true;
            if(set.contains(n)) return false;
            else {
                set.add(n);
            }
        }
        return true;
    }

    private int calSquareSum(int n) {
        int sum = 0;
        while(n != 0) {
            sum += (n%10) * (n%10);
            n /= 10;
        }
        return sum;
    }
}