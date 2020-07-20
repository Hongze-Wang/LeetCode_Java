// 46. Permutations

class Solution {
    List<Integer> temp;
    
    public List<List<Integer>> arr = new ArrayList();

    public List<List<Integer>> permute(int[] nums) {
        permute(nums, 0, nums.length-1);
        return arr;
    }

    private void permute(int nums[], int left, int right) {
        if(left == right) {
            temp = new ArrayList<Integer>();
            for(int k: nums) {
                temp.add(k);
            }
            arr.add(temp);
        } else {
            for(int i=left; i<=right; i++) {
                swap(nums, i, left);
                permute(nums, left+1, right);
                swap(nums, i, left);
            }
        }
    }

    private void swap(int[] nums, int i, int left) {
        int temp = nums[i];
        nums[i] = nums[left];
        nums[left] = temp;
    }
}
