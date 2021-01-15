// 503. Next Greater Element II

// brute force - accepted
// class Solution {
//     public int[] nextGreaterElements(int[] nums) {
//         int[] res = new int[nums.length];
//         int[] copy = new int[nums.length * 2];
//         System.arraycopy(nums, 0, copy, 0, nums.length);
//         System.arraycopy(nums, 0, copy, nums.length, nums.length);
        
//         for(int i=0; i<nums.length; i++) {
//             res[i] = -1; // 初始化为-1 防止找不到
//             for(int j=i+1; j<copy.length; j++) {
//                 if(copy[j] > nums[i]) {
//                     res[i] = copy[j];
//                     break;
//                 }
//             }
//         }
//         return res;
//     }
// }

// optimized bf
// use % to avoid extra space

// class Solution {
//     public int[] nextGreaterElements(int[] nums) {
//         int[] res = new int[nums.length];
//         for(int i=0; i<nums.length; i++) {
//             res[i] = -1;
//             for(int j=i+1; j<2*nums.length; j++) {
//                 if(nums[j % nums.length] > nums[i]) {
//                     res[i] = nums[j % nums.length];
//                     break;
//                 }
//             }
//         }
//         return res;
//     }
// }

// 分析题目不难看出解法要使用单调栈
// 找下一个更大元素可以通过从右向左构造递减栈来实现 递减栈保存了比当前元素更大的元素 如果当前元素最大 则递减栈为空
// 从右向左构造递减栈相当于从左向右找下一个最大的数 如果这个方向找不到可能要尝试从右向左找
// 但循环数组是一个痛点
// 联系到循环队列的数组实现是使用模运算来实现循环的 可以参考借鉴一下
// 例：nums.lenght = 5 for(int i=2*nums.length-1; i>=0; i--)
// 得到的索引序列是9 8 7 6 5 4 3 2 1
// i % nums.length的结果是 4 3 2 1 0 1 2 3 4 即为我们所需要的查找顺序
// 可以应用到这一题

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        
        for(int i=2*nums.length-1; i>=0; i--) {
            while(!stack.isEmpty() && nums[stack.peek()] <= nums[i % nums.length]) { // 递减栈模板代码 维护一个递减栈
                stack.pop();                                                        // 递减栈模板代码 维护一个递减栈
            }
            res[i % nums.length] = stack.isEmpty() ? -1 : nums[stack.peek()];
            stack.push(i % nums.length);                                           // 递减栈模板代码 维护一个递减栈
        }
        return res;
    }
}
