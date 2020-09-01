// 239. Sliding Window Maximum

// Double Queue
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList();
        int[] res = new int[nums.length-k+1];
        for(int i=0; i<nums.length; i++) {
            while(!deque.isEmpty() && deque.peekFirst() <= (i-k)) {
                deque.pollFirst();
            }
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.add(i);
            if(i+1 >= k) {
                res[i+1-k] = nums[deque.peekFirst()];
            }
        }
        return res;
    }
}
