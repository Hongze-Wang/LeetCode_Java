class Solution:
    def minAddToMakeValid(self, S: str) -> int:
        left, right = 0, 0
        for s in S:
            if s == '(':
                left += 1
            else:
                left -= 1
            if left == -1:
                left = 0    # left += 1
                right += 1
        return left + right