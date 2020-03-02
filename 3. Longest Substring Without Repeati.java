// 3. Longest Substring Without Repeating Characters
// Brute Force time limit exceeded O(n^3)
// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         int n=s.length();
//         int ans=0;
//         for(int i=0; i<n; i++) {
//             for(int j=0; j <=n; j++) {
//                 if(allUnique(s, i, j)) {
//                     ans = Math.max(ans, j-i);
//                 }
//             }
//         }
//         return ans;
//     }
//     public boolean allUnique(String s, int start, int end) {
//         Set<Character> set = new HashSet<>();
//         for(int i=start; i<end; i++) {
//             Character c= s.charAt(i);
//             if(set.contains(c)) return false;
//             else set.add(c);
//         }
//         return true;
//     }
// }

// Sliding Window / Two pointers
// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         int len = s.length();
//         Set<Character> set = new HashSet<>();
//         int ans=0, i=0, j=0;
//         while(i<len && j<len) {
//             if(!set.contains(s.charAt(j))) {
//                 set.add(s.charAt(j++));
//                 ans = Math.max(ans, j-i);
//             } else {
//                 set.remove(s.charAt(i++));
//             }
//         }
//         return ans;
//     }
// }

// Optimized Sliding Window / Two pointers
// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         int len=s.length(), ans=0;
//         Map<Character, Integer> map = new HashMap<>();
//         for(int i=0, j=0; j<len; j++) {
//             if(map.containsKey(s.charAt(j))) {
//                 i = Math.max(map.get(s.charAt(j)), i);
//             }
//             ans = Math.max(ans, j-i+1);
//             map.put(s.charAt(j), j+1);
//         }
//         return ans;
//     }
// }

// Using Ascii
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }
        int len = s.length(); ans=0;
        int[] index = new int[128]; //Ascii has 128 character
        for(int i=0, j=0; j < n; j++) {
            i = Math.max(index[s.charAt(j), i);
            ans = Math.max(ans, j-i+1);
            index[s.charAt(j)] = j+1;
        }
        return ans;
    }
}