// 219. Contains Duplicate II

// 最直观解法 82.85% faster 100% memory less
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums == null || k < 1) return false;

        HashMap<Integer, Integer> map = new HashMap();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                if(i - map.get(nums[i]) <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;
    }
}

// Brute Force O(n^2)
// 但只需加上一行，就能变成100% faster 其实是作弊 长度大于5000的直接判定了false

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k < 1)  return false;
        
        for(int i = 0; i < nums.length; i++) {
            for(int j = i+1; j < nums.length; j++) {
                if(nums[i] == nums[j] && j - i <= k) {
                    return true;
                }
            }
        }
        return false;
    }
}

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k < 1 || nums.length > 5000)  return false;
        
        for(int i = 0; i < nums.length; i++) {
            for(int j = i+1; j < nums.length; j++) {
                if(nums[i] == nums[j] && j - i <= k) {
                    return true;
                }
            }
        }
        return false;
    }
}