// 11. Container With Most Water

// Brute Force
// class Solution {
//     public int maxArea(int[] height) {
//         int max = 0;
//         for(int i=0; i<height.length; i++) {
//             for(int j=i+1; j<height.length; j++) {
//                 max = Math.max(max, Math.min(height[i], height[j])*(j-i));
//             }
//         }
//         return max;
//     }
// }

// Two pointers
class Solution {
    public int maxArea(int[] height) {
        int low = 0, high = height.length-1, maxarea = 0;
        while(low < high) {
            maxarea = Math.max(maxarea, Math.min(height[low], height[high])*(high-low));
            if(height[low] < height[high]) {
                low++;
            } else {
                high--;
            }
        }
        return maxarea;
    }
}