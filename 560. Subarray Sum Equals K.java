// 560. Subarray Sum Equals K

// brute force: Time Limit Exceeded
// class Solution {
//     public int subarraySum(int[] nums, int k) {
//         int cnt = 0;
//         for(int i=0; i<nums.length; i++) {
//             for(int j=i+1; j<=nums.length; j++) {
//                 int sum = 0;
//                 for(int idx=i; idx<j; idx++) {
//                     sum += nums[idx];
//                 }
//                 if(sum == k) {
//                     cnt++;
//                 }
//             }
//         }
//         return cnt;
//     }
// }

// cumulative sum 前缀和
// optimized from brute force
// store the cumulative sum to avoid duplicate computationn
// sum(j, i) = sum(0, j) - sum(0, i)
// count the number of sum(j,i) == k
// class Solution {
//     public int subarraySum(int[] nums, int k) {
//         int cnt = 0;
//         int[] sum = new int[nums.length+1];
//         sum[0] = 0;
//         for(int i=1; i<=nums.length; i++) { // <= index 0 does not used
//             sum[i] = sum[i-1] + nums[i-1]; 
//         }
//         for(int i=0; i<nums.length; i++) {
//             for(int j=i+1; j<=nums.length; j++) { // <= index 0 does not used
//                 if(sum[j] - sum[i] == k) {
//                     cnt++;
//                 }
//             }
//         }
//         return cnt;
//     }
// }

// every interval i,j, use a separete sum variable to store the sum
// this can save the space to O(1) but time complexity is still O(n)
// class Solution {
//     public int subarraySum(int[] nums, int k) {
//         int cnt = 0;
//         for(int i=0; i<nums.length; i++) {
//             int sum = 0;
//             for(int j=i; j<nums.length; j++) {
//                 sum += nums[j];
//                 if(sum == k) {
//                     cnt++;
//                 }
//             }
//         }
//         return cnt;
//     }
// }

// leverage the fact that sum(i, j) = sum(0, j) - sum(0, i)
// use hashmap to store the previous sum
// if we detect sum - k, we actually find sum(i, j), which denote the existence of sum(0, j) and sum(0, i) = k
// this means that the number of sum(i, j) equals to sum(0, i) = k
// add the number of sum(i, j) to the result

class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0, cnt = 0;
        
        map.put(0, 1); // initialization cannot be saved
        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
            if(map.containsKey(sum - k)) {
                cnt += map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return cnt;
    }
}