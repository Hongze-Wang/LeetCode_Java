// 440. K-th Smallest in Lexicographical Order

// 100% faster solution

/*
method countSteps count the number of the integers whoes order small than k between the integer curr and curr + 1 generated in lexicographically order
i.e 
curr = 1 and curr + 1 = 2
the lexicographical order between 1 and 2 is [1, 10, 12, 13, 14, 15, 16, 17, 18, 19, 20], totall number 1 + right*10 - left*10
when n = 13 remove all the interger bigger than 13, we get [1, 10, 12, 13]  totall number 1 + min(n+1, right)-left = 4
so the the number of the integers whoes order small than k between 1 and 2 is 4, denote as steps
if 4 smaller than k, it tell that the integer bigger than all the interger in [1, 10, 12, 13]
k = k - 4
cur = cur + 1
repeat above process to get step between in the 2 and 3

if we k < steps, then the k-th smallest integer locate in the last steps between this steps
cur = cur * 10
k = k - 1
repeat until k = 0
then we find the the k-th smallest integer
*/

class Solution {
    
    private int countSteps(long left, long right, int n) {
        int res = 0;
        while(left <= n || right <= n) {
            res += Math.min(n+1, right) - left;
            left *= 10;
            right *= 10;
        }
        return res;
    }
    
    public int findKthNumber(int n, int k) {
        if(k == 0) return 0;
        int curr = 1;
        k--;
        while(k > 0) {
            int steps = countSteps(curr, curr+1, n);
            if(steps <= k) {
                curr++;
                k -= steps;
            } else {
                curr *= 10;
                k--;
            }
        }
        return curr;
    }
}
