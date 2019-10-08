// 191. Number of 1 Bits

// 最直观解法 100% faster(0 ms) 不稳定 有时候跑 55%(1 ms)
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        for(int i = 0; i < 32; i++) {
            if((n & 1) == 1) {
                count++;
            }
            n >>= 1;
        }
        return count;
    }
}

// 标准答案是对掩码移位 这样会多使用一个变量mask
public int hammingWeight(int n) {
    int bits = 0;
    int mask = 1;
    for (int i = 0; i < 32; i++) {
        if ((n & mask) != 0) {
            bits++;
        }
        mask <<= 1;
    }
    return bits;
}

// Approach #2 (Bit Manipulation Trick)
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while(n != 0) {
            count++;
            n &= (n - 1); // 能执行一次该语句 代表有一个1 详见https://leetcode.com/problems/number-of-1-bits/solution/
        }
        return count;
    }
}

// 递归形式 效率与上面·相差不大
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        if(n == 0) return 0;
        return hammingWeight(n & (n - 1)) + 1;
    }
}

// 依然不快
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        return Integer.bitCount(n ^ 0);
    }
}