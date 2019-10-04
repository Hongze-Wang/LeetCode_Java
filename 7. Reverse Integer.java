package LeetCode;
// 7. Reverse Integer
public class ReverseInteger {
    public int reverse(int x) {
        int result = 0;

        while(x != 0) {
            int digit = x%10;
            // If there will be overflow
            if (result < 0 && result < Integer.MIN_VALUE / 10
                    || result > 0 && result > Integer.MAX_VALUE / 10) {
                return 0;
            }

            result *= 10;
            result += digit;

            x /= 10;
        }
        return result;
    }
}
