// 3. Longest Substring Without Repeating Characters
// Brute Force O(n^3)
// Time Limit Exceeded
// public class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         if(s == null || s.length() == 0) return 0;
//         int n = s.length();
//         int res = 0;
//         for(int i=0; i<n; i++) {
//             for(int j=i+1; j<=n; j++) {
//                 if(isUnique(s, i, j)) {
//                     // res = Math.max(res, j-i);
//                     if(res < j-i) res = j-i;
//                 }
//             }
//         }
//         return res;
//     }
//     public boolean isUnique(String s, int low, int high) {
//         Set<Character> set = new HashSet();
//         char c;
//         for(int i=low; i<high; i++) {
//             c = s.charAt(i);
//             if(set.contains(c)) return false;
//             set.add(c);
//         }
//         return true;
//     }
// }

// //sliding window
// public class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         if(s == null || s.length() == 0) return 0;
        
//         int n = s.length();
//         Set<Character> set = new HashSet<>();
//         int res = 0, i = 0, j = 0;
//         while(i< n && j <n) {
//             if(!set.contains(s.charAt(j))) {
//                 set.add(s.charAt(j++));
//                 if(res < j-i) res = j-i;
//             } else {
//                 set.remove(s.charAt(i++));
//             }
//         }
//         return res;
//     }
// }

// optimized sliding window
// using HashMap
// public class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         if(s == null || s.length() == 0) return 0;
        
//         int n = s.length(), res = 0;
//         Map<Character, Integer> map = new HashMap<>();
//         for(int i=0, j=0; j<n; j++) {
//             if(map.containsKey(s.charAt(j))) {
//                 i = Math.max(map.get(s.charAt(j)), i);
//             }
//             res = Math.max(res, j-i+1);
//             map.put(s.charAt(j), j+1);
//         }
//         return res;
//     }
// }

// ASCII
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        
        int n = s.length(), res = 0;
        int[] index = new int[128];
        for(int i=0, j=0; j<n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            res = Math.max(res, j-i+1);
            index[s.charAt(j)] = j+1; 
        }
        return res;
    }
}
