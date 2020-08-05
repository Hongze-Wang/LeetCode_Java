// 1201. Ugly Number III

// Time Limit Exceeded
// class Solution {
//     public int nthUglyNumber(int n, int a, int b, int c) {
//         int count = 0;
//         int an = 1, bn = 1, cn = 1;
//         int res = 0;
//         while(count < n) {
//             res = Math.min(Math.min(an*a, bn*b), cn*c);
//             if(res == an*a) an++;
//             if(res == bn*b) bn++;
//             if(res == cn*c) cn++;
//             count++;
//         }
//         return res;
//     }
// }

// 二分法
// gcd gratest common divisor 最大公约数
// lcm least common mutiple   最小公倍数

class Solution {
    public int nthUglyNumber(int n, int a, int b, int c) {
        long low = 1;
        long high = 2000000000;
        while(low <= high) {
            long mid = low + (high - low) / 2;
            long count = countSmallerOrEqual(mid, a, b, c);
            if(count < n) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return (int) low;
    }

    private long countSmallerOrEqual(long guess, long a, long b, long c) {
        return guess / a + guess / b + guess / c - 
               guess / lcm(a, b) - guess / lcm(a, c) - guess / lcm(b, c) +
               guess / lcm(lcm(a, b), c);
    }

    private long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }

    private long gcd(long a, long b) {
        if(a < b) return gcd(b, a);
        while(b > 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
