// 76. Minimum Window Substring

class Solution {
    public String minWindow(String s, String t) {
        int[] charCount = new int[128];

        int left = 0, start = -1, minLen = Integer.MAX_VALUE, cnt=0;
        int len1 = s.length(), len2 = t.length();

        for(int i=0; i<len2; i++) {
            charCount[t.charAt(i)]++;
        }

        for(int i=0; i<len1; i++) {
            if(--charCount[s.charAt(i)] >= 0) {
                cnt++;
            }

            while(cnt == len2) {
                if(minLen > i-left+1) {
                    minLen = i-left+1;
                    start = left;
                }
                if(++charCount[s.charAt(left)] > 0) {
                    cnt--;
                }
                left++;
            }
        }
        return start == -1 ? "" : s.substring(start, start+minLen);
    }
}