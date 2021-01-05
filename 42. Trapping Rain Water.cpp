// 42. Trapping Rain Water

// 备忘法 从暴力法优化过来
// 暴力法中，我们在每一个位置都要求它到左端和右端的最大值，包含大量的重复计算 (其实从这点能看出可以使用单调栈来解)
// 备忘法用来记忆计算结果，避免重复计算

class Solution {
public:
    int trap(vector<int>& height) {
        int res = 0, len = height.size();
        if(height.size() < 3) return 0;
        
        vector<int> left_max(len), right_max(len);
        
        left_max[0] = height[0];
        for(int i=1; i<len; i++) {
            left_max[i] = max(height[i], left_max[i-1]);
        }
        right_max[len-1] = height[len-1];
        for(int i=len-2; i>=0; i--) {
            right_max[i] = max(height[i], right_max[i+1]);
        }
        
        for(int i=1; i<len-1; i++) { // 第一个和最后一个是无法承接雨水的
            res += min(left_max[i], right_max[i]) - height[i];
        }
        
        return res;
    }
};