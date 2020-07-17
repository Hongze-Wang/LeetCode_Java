# 10. Regular Expression Matching

# if there is no star

# class Solution:
#     def isMatch(self, s: str, p: str) -> bool:
#         if not p: return not s
#         first = bool(s) and p[0] in {s[0], '.'}
#         return first and match(s[1:], p[1:])

# Recursion
# class Solution:
#     def isMatch(self, s, p):
#         if not p:
#             return not s
#         first = bool(s) and p[0] in {s[0], '.'}
#         if len(p) >= 2 and p[1] == '*':
#             return (self.isMatch(s, p[2:]) or first and self.isMatch(s[1:], p))
#         else:
#             return first and self.isMatch(s[1:], p[1:])

# DP bottom-up
# class Solution:
#     def isMatch(self, s, p):
#         dp = [[False] *(len(p)+1) for _ in range(len(s)+1)]
#         dp[-1][-1] = True
#         for i in range(len(s), -1, -1):
#             for j in range(len(p)-1, -1, -1):
#                 first = i < len(s) and p[j] in {s[i], '.'}
#                 if j+1 < len(p) and p[j+1] == '*':
#                     dp[i][j] = dp[i][j+2] or first and dp[i+1][j]
#                 else:
#                     dp[i][j] = first and dp[i+1][j+1]
#         return dp[0][0]

# DP top-down
class Solution:
    def isMatch(self, s, p):
        memo = {}
        def dp(i, j):
            if(i, j) not in memo:
                if j == len(p):
                    res = i == len(s)
                else:
                    first = i<len(s) and p[j] in {s[i], '.'}
                    if j+1 < len(p) and p[j+1] == '*':
                        res = dp(i, j+2) or first and dp(i+1, j)
                    else:
                        res = first and dp(i+1, j+1)
                memo[i, j] = res
            return memo[i, j]
        return dp(0, 0)
