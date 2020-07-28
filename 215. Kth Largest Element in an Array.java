// 215. Kth Largest Element in an Array

class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null) return -1;
        
        Arrays.sort(nums);
        int index = nums.length-k;
        return nums[index];
    }
}

// above is faster and space less

// class Solution {
//     public int findKthLargest(int[] nums, int k) {
//         if(nums == null) return -1;
        
//         PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> n2-n1);
//         for(int i=0; i<nums.length; i++) {vb
//             pq.offer(nums[i]);
//         }
//         for(int i=0; i<k-1; i++) {
//             pq.poll();
//         }
//         return pq.peek();
//     }
// }
