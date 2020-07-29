// 140. Word Break II

// Simplest solution 56% faster

class Solution {
    Map<String, List<String>> map = new HashMap();
    public List<String> wordBreak(String s, List<String> wordDict) {
        if(map.containsKey(s)) {
            return map.get(s);
        }
        List<String> temp = new ArrayList();
        int end = s.length();

        for(int i=end-1; i >= 0; i--) {
            String curString = s.substring(i, end);
            if(wordDict.contains(curString)) {
                if(i == 0) {
                    temp.add(curString);
                }
                for(String str : wordBreak(s.substring(0, i), wordDict)) {
                    String res = str + " " + curString;
                    temp.add(new String(res));
                }
            }
        }
        map.put(s, temp);
        return temp;
    }
}

// Simplest solution 78% faster

// Using HashMap to avoid duplicate operation
// Using HashSet to accelerate search process

class Solution {
    Map<String, List<String>> map = new HashMap();
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<String>(wordDict);
        return wordBreak(s, wordSet);
    }
    
    public List<String> wordBreak(String s, Set<String> wordSet) {
        if(map.containsKey(s)) {
            return map.get(s);
        }
        List<String> temp = new ArrayList();
        int end = s.length();

        for(int i=end-1; i >= 0; i--) {
            String curString = s.substring(i, end);
            if(wordSet.contains(curString)) {
                if(i == 0) {
                    temp.add(curString);
                }
                for(String str : wordBreak(s.substring(0, i), wordSet)) {
                    String res = str + " " + curString;
                    temp.add(new String(res));
                }
            }
        }
        map.put(s, temp);
        return temp;
    }
}

// Simplest solution 85.89% faster

// Using HashMap to avoid duplicate operation
// Using HashSet to accelerate search process

class Solution {
    HashMap<String, List<String>> map = new HashMap();
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        if(s == null) return new ArrayList<String>();
        
        HashSet<String> wordSet = new HashSet(wordDict);
        return wordBreak(s, wordSet);
    }
    
    public List<String> wordBreak(String s, HashSet<String> wordSet) {
        if(map.containsKey(s)) {
            return map.get(s);
        }
        int end = s.length();
        List<String> temp = new ArrayList();
        for(int i=end-1; i>=0; i--) {
            String curString = s.substring(i, end);
            if(wordSet.contains(curString)) {
                if(i == 0) {
                    temp.add(curString);
                }
                for(String str : wordBreak(s.substring(0, i), wordSet)) {
                    String res = str + " " + curString;
                    temp.add(res);
                }
            }
        }
        map.put(s, temp);
        return temp;
    }
}
