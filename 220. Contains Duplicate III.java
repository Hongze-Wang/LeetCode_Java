// 220. Contains Duplicate III


// Simple Java O(n^2) 11.96% faster
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums.length < 2 || k < 0 || t < 0) return false;
        for(int i = 0; i < nums.length; i++) {
            for(int j = i+1; j <= i+k && j < nums.length; j++) {
                if(Math.abs((long) nums[j] - nums[i]) <= t) {
                    return true;
                }
            }
        }
        return false;
    }
}

// Simple Java based on TreeSet O(n) 35% faster 

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(t < 0) return false;
        TreeSet<Integer> set = new TreeSet<>();
        
        for(int i = 0; i < nums.length; i++) {
            if(i > k) {
                set.remove(nums[i-k-1]);
            }
            if(set.contains(nums[i])) {
                return true;
            }
            Integer lowerKey = set.lower(nums[i]);
            Integer higherKey = set.higher(nums[i]);

            if(lowerKey != null && Math.abs((long)lowerKey - nums[i]) <= t ||
               higherKey != null && Math.abs((long)higherKey - nums[i]) <= t) {
                   return true;
            }
            set.add(nums[i]);
        }
        return false;
    }
}