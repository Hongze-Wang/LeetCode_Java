// 190. Reverse Bits

// 借助取余运算 从后向前 一位一位加上去
// 再借助位运算能加速该解法 见Java解法

class Solution {
public:
    uint32_t reverseBits(uint32_t n) {
        unsigned int res = 0;
        for(int i = 0; i < 32; i++) {
            res = res * 2 + n % 2;
            n /= 2;
        }
        return res;
    }
};

