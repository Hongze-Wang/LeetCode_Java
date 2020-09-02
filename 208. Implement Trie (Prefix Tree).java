// 208. Implement Trie (Prefix Tree)

// https://leetcode.com/problems/implement-trie-prefix-tree/solution/

/*
Applications
Trie (we pronounce "try") or prefix tree is a tree data structure, which is used for retrieval of a key in a dataset of strings. There are various applications of this very efficient data structure such as :

1. Autocomplete
Google Suggest

Figure 1. Google Suggest in action.

2. Spell checker
Spell Checker

Figure 2. A spell checker used in word processor.

3. IP routing (Longest prefix matching)
IP Routing

Figure 3. Longest prefix matching algorithm uses Tries in Internet Protocol (IP) routing to select an entry from a forwarding table.

4. T9 predictive text
T9 Predictive Text

Figure 4. T9 which stands for Text on 9 keys, was used on phones to input texts during the late 1990s.

5. Solving word games
Boggle

Figure 5. Tries is used to solve Boggle efficiently by pruning the search space.

There are several other data structures, like balanced trees and hash tables, which give us the possibility to search for a word in a dataset of strings. Then why do we need trie? Although hash table has O(1)O(1) time complexity for looking for a key, it is not efficient in the following operations :

Finding all keys with a common prefix.
Enumerating a dataset of strings in lexicographical order.
Another reason why trie outperforms hash table, is that as hash table increases in size, there are lots of hash collisions and the search time complexity could deteriorate to O(n)O(n), where nn is the number of keys inserted. Trie could use less space compared to Hash Table when storing many keys with the same prefix. In this case using trie has only O(m)O(m) time complexity, where mm is the key length. Searching for a key in a balanced tree costs O(m \log n)O(mlogn) time complexity.

Trie node structure
Trie is a rooted tree. Its nodes have the following fields:

Maximum of RR links to its children, where each link corresponds to one of RR character values from dataset alphabet. In this article we assume that RR is 26, the number of lowercase latin letters.
Boolean field which specifies whether the node corresponds to the end of the key, or is just a key prefix.
*/


class TrieNode {
    private TrieNode[] links;
    private final int R = 26;
    private boolean isEnd;

    public TrieNode() {
        links = new TrieNode[R];
    }

    public boolean containsKey(char c) {
        return links[c-'a'] != null;
    }
    public TrieNode get(char c) {
        return links[c-'a'];
    }
    public void put(char c, TrieNode node) {
        links[c-'a'] = node;
    }
    public void setEnd() {
        isEnd = true;
    }
    public boolean isEnd() {
        return isEnd;
    }
}

class Trie {
    private TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for(int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            if(!node.containsKey(c)) {
                node.put(c, new TrieNode());
            }
            node = node.get(c);
        }
        node.setEnd();
    }
    /** Returns if the word is in the trie. */
    // public boolean search(String word) {
    //     TrieNode node = root;
    //     for(int i=0; i<word.length(); i++) {
    //         char c = word.charAt(i);
    //         if(!node.containsKey(c)) {
    //             return false;
    //         }
    //         node = node.get(c);
    //     }
    //     return node.isEnd;
    // }
    private TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for(int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            if(node.containsKey(c)) {
                node = node.get(c);
            } else {
                return null;
            }
        }
        return node;
    }
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
