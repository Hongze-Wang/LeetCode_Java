// 190. Reverse Bits

// 这种一行搞定的Solution 往往是调了很多库函数 所以效率很低
// 但可以认识一下有哪些库函数可以调
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        return Integer.parseUnsignedInt(new StringBuilder(String.format("%32s", Integer.toBinaryString(n)).replace(' ', '0')).reverse().toString(),2);
    }
}

// String.format("%32s", Integer.toBinaryString(n))
// new StringBuilder(str).reverse().toString()
// Integer.parseUnsignedInt(String str, int radix)

// Bitswise Operation
// 100% faster but cost much more memory
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        for(int i = 0; i < 32; i++) {
            int bit = (n & 1) << (31-i); // 得到一位 并右移到翻转之后的位置
            res |= bit;
            n >>>= 1; // >>> 右移，左边补零
        }
        return res;
    }
}