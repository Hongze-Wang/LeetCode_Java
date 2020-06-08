// 763. Partition Labels

// two pointers + greedy
// greedy policy: partition include one char last appearance
// select as many as the same char in one paitition

class Solution {
    public List<Integer> partitionLabels(String S) {
        int[] last = new int[26];
        for(int i=0; i<S.length(); i++) {
            last[S.charAt(i)-'a'] = i;
        }
        int start = 0, end = 0;
        List<Integer> ans = new ArrayList();
        for(int i=0; i<S.length(); i++) {
            end = Math.max(end, last[S.charAt(i)-'a']);
            if(end == i) {
                ans.add(i-start+1);
                start = i+1;
            }
        }
        return ans;
    }
}
