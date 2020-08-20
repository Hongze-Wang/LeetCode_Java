// 84. Largest Rectangle in Histogram
// 递增栈解法 参见python解法
// 建议复习 85. Maximal Rectangle 和 221. Maximal Square

// find the minimum element and compute the area
// update area if it's larger
// Greedy policy:only expand when element > current element

// 11% faster
// class Solution {
//     public int largestRectangleArea(int[] heights) {
//         int res = 0;
//         for(int i=0; i<heights.length; i++) {
//             int width = 1;
//             for(int j=i-1; j>=0; j--) {
//                 if(heights[j] >= heights[i]) {
//                     width++;
//                 } else {
//                     break;
//                 }
//             }
//             for(int j=i+1; j<heights.length; j++) {
//                 if(heights[j] >= heights[i]) {
//                     width++;
//                 } else {
//                     break;
//                 }
//             }
//             res = Math.max(res, heights[i]*width);
//         }
//         return res;
//     }
// }

// 100%
// use left right arr to implement the function of stack
// left store the elem that the left first smaller height index
// right store the elem that right first smaller height index
// right[i]-left[i]-1 = width height = heights[i]
// area = width * height

class Solution {
    public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0) {
            return 0;
        }
        int[] left = new int[heights.length];
        int[] right = new int[heights.length];
        left[0] = -1;
        right[heights.length-1] = heights.length;
        for(int i=1; i<heights.length; i++) {
            int index = i-1;
            while(index != -1 && heights[index] >= heights[i]) {
                index = left[index];
            }
            left[i] = index;
        }

        for(int i=heights.length-2; i>=0; i--) {
            int index = i+1;
            while(index != heights.length && heights[index] >= heights[i]) {
                index = right[index];
            }
            right[i] = index;
        }

        int max = 0;
        for(int i=0; i<heights.length; i++) {
            max = Math.max(max, (right[i]-left[i]-1) * heights[i]);
        }
        return max;
    }
}
