// 42. Trapping Rain Water

// 单调栈 递减栈
// 分析题意 不难看出我们需要找到当前元素的左上界 和 右上界 因而使用单调栈
// 这里使用递减栈 注意 一定要想清楚使用递增栈还是递减栈

class Solution {
    public int trap(int[] height) {
        int res = 0, idx = 0;
        Stack<Integer> stack = new Stack<>();
        
        while(idx < height.length) {
            while(!stack.isEmpty() && height[idx] > height[stack.peek()]) {
                int top = stack.pop();
                if(stack.isEmpty()) {
                    break;
                } else{
                    int dis = idx-stack.peek()-1;
                    int h = Math.min(height[idx], height[stack.peek()]) - height[top];
                    res += dis * h;
                }
            }
            stack.push(idx++);
        }
        return res;
    }
}

// for循环和单调栈模板代码更接近
class Solution {
    public int trap(int[] height) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        
        for(int idx = 0; idx < height.length; idx++) {
            while(!stack.isEmpty() && height[idx] > height[stack.peek()]) { // 模板代码 维护一个递减栈 注意不是大于等于
                int top = stack.pop(); // 模板代码 维护一个递减栈
                if(stack.isEmpty()) {
                    break;
                } else{
                    int dis = idx-stack.peek()-1; // 上界本身不能存贮雨水
                    int h = Math.min(height[idx], height[stack.peek()]) - height[top];
                    res += dis * h;
                }
            }
            stack.push(idx); // 模板代码 维护一个递减栈
        }
        return res;
    }
}