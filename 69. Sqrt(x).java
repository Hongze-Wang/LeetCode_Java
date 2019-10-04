package LeetCode;
// 69. Sqrt(x)
public class Sqrt {
    public int mySqrt(int x) {
        if (x < 2) {
            return x;
        }
        int low = 0, high = x;
        int mid = 0;
        while (low < high) {
            mid = low + (high - low) / 2;
            if (mid > x / mid) {
                high = mid - 1;
            } else { //mid <= x/mid
                low = mid + 1;
                if (low > x / low) {
                    return mid;
                }
            }
        }
        return low;
    }
}
