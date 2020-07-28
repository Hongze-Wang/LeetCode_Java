// 139. Word Break

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == false) {
                continue;
            }
            for (int j = 0; j < wordDict.size(); j++) {
                String word = wordDict.get(j);
                if (i + word.length() <= s.length() && word.equals(s.substring(i, i + word.length()))) {
		    dp[i + word.length()] = true;
		}
            }
        }
        return dp[s.length()];
    }
}

// class Solution {
//     public boolean wordBreak(String s, List<String> wordDict) {
//         // if(s == null || wordDict == null) return false;
//         int wordlen, dictsize = wordDict.size(), strlen = s.length();
//         boolean[] dp = new boolean[strlen + 1];
//         dp[0] = true;
//         String word;

//         for(int i=0; i<dp.length; i++) {
//             if(dp[i] == false) continue;
//             for(int j=0; j<dictsize; j++) {
//                 word = wordDict.get(j);
//                 wordlen = word.length();
//                 if(i + wordlen <= strlen && word.equals(s.substring(i, i+wordlen))) {
//                     dp[i+wordlen] = true;
//                 }
//             }
//         }
//         return dp[strlen];
//     }
// }
