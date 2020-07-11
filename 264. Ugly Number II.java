// 264. Ugly Number II

class Solution {
    public int nthUglyNumber(int n) {
        int res[] = new int[n];
        res[0] = 1;
        int l2=0, l3=0, l5=0, min;
        for(int i=1; i<n; i++) {
            min = Math.min(res[l2]*2, Math.min(res[l3]*3, res[l5]*5));
            res[i] = min;
            if(min == res[l2]*2) {
                l2++;
            }
            if(min == res[l3]*3) {
                l3++;
            }
            if(min == res[l5]*5){
                l5++;
            }
        }
        return res[n-1];
    }
}
