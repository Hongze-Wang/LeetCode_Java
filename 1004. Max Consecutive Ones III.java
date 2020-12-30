// 1004. Max Consecutive Ones III
// 双百解法 双指针法 注意左指针的移动
// 右指针右移 遇到0 K--
// K小于0的时候不能再补零 计算一次长度
// 同时移动左指针 首先为1的直接移动 因为1的位置没有补零
// 左指针移动一格 K++ 表示右指针能再补一个零
// 循环 循环结束条件 left>right 后者right=A.length

// 补零最长有三种情况
// 左边补k个1 右边补k个1 左右都补加起来补k个
// 左右补1 已经实现 通过K的值实现左右补1

class Solution {
    public int longestOnes(int[] A, int K) {
        int left=0, right=0, res=0;
        while(left <= right && right < A.length) {
            if(A[right] == 0) {
                K--;
            }
            if(K < 0) {
                res = Math.max(right-left, res);
                while(A[left] == 1) {
                    left++;
                }
                left++;
                K++;
            }
            right++;
        }
        return Math.max(right-left, res);
    }
}