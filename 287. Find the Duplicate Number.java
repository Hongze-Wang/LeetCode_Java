// 287. Find the Duplicate Number

// class Solution {
//     public int findDuplicate(int[] nums) {
//         Arrays.sort(nums);
//         for(int i=1; i<nums.length; i++) {
//             if(nums[i-1] == nums[i]) {
//                 return nums[i];
//             }
//         }
//         return -1;
//     }
// }

// class Solution {
//     public int findDuplicate(int[] nums) {
//         Set<Integer> set = new HashSet();
//         for(int num: nums) {
//             if(set.contains(num)) return num;
//             set.add(num);
//         }
//         return -1;
//     }
// }

// Approach 3: Floyd's Tortoise and Hare (Cycle Detection)
// The idea is to reduce the problem to 142. Linked List Cycle II
class Solution {
    public int findDuplicate(int[] nums) {
        int tortoise = nums[0], hare = nums[0];
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while(tortoise != hare);
        // tortoise = nums[0];
        hare = nums[0];
        while(tortoise != hare) {
            tortoise = nums[tortoise];
            hare = nums[hare];
        }
        return hare;
    }
}
