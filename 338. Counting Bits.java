// 338. Counting Bits


// 偶数变奇数时 count + 1
// 奇数变2的次方偶数时 count = 1
class Solution {
    public int[] countBits(int num) {
        int[] res = new int[num+1];
        if(num == 0) return res;
        res[0] = 0;
        res[1] = 1;
        int twoPow = 2;
        for(int i=2; i<=num; i++) {
            if(i == 2*twoPow) twoPow *= 2;
            res[i] = 1 + res[i - twoPow];
        }
        return res;
    }
}
