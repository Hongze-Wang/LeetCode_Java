# 同TargetOffer 28 
# 删掉一些非法输入的判断 能加快运行速度到beat 99%

class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        if nums is None:
            return None
        length = len(nums)
        if length == 0:
            return 0
        if length == 1:
            return nums[0]
        con = length // 2
        
        dic = {}
        for i in range(length):
            if nums[i] in dic:
                dic[nums[i]] += 1
                if dic[nums[i]] > con:
                    return nums[i]
            else:
                dic[nums[i]] = 1

class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 0
        if len(nums) == 1:
            return nums[0]
        
        nums.sort()
        return nums[len(nums) // 2]