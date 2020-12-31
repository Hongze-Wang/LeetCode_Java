// 76. Minimum Window Substring
// 使用vector/array memset()/fill() 填充方法 效率没有太大差别

// 核心思想：双指针法
// 维持从left到i的一个窗口，当该窗口内包含所有的t的字符时 尝试缩小窗口 并保存最小长度和起始索引
// 判断窗口是否包含所有t内字符采用计数的方式 因为字符的顺序可以是任意的 这种情况下只有通过计数 才能处理所有的情况
// 首先统计t中所有字符出现的次数 以次数作为依据可也以处理t中包含重复字符这种情况
// 遍历字符串s 如果发现对应t中的字符 则字符计数减一 数量计数加一
// 数量计数加到t长度时 表示窗口内的字串已经包含所有t中的字符
// 以该数量等于t长度作为循环条件 判断能够满足条件的情况下缩小窗口长度 每次循环left右移一位
// 如果left位置上的字符计数在加一后大于零而不是等于零 表示该位置上存的是t中的一个字符 数量计数减1 退出循环

class Solution {
public:
    string minWindow(string s, string t) {
        vector<int> charCount(128, 0);
        int left = 0, start = -1, minLen = INT_MAX, cnt=0;
        int len1 = s.size(), len2 = t.size();
        
        for(char c: t) {
            charCount[c]++;
        }

        for(int i=0; i<len1; i++) {
            if(--charCount[s[i]] >= 0) { // 先减是为了排除s中未在t中出现的重复字符 这些字符的计数会变成-1
                cnt++;
            }

            while(cnt == len2) {
                if(minLen > i-left+1) {
                    minLen = i-left+1;
                    start = left;
                }
                if(++charCount[s[left]] > 0) { // 如果加一大于零 则是在t中出现的字符 计数减一 如果加一等于零 则是未在t中出现的字符
                    cnt--;
                }
                left++;
            }
        }
        return start == -1 ? "" : s.substr(start, minLen);
    }
};

class Solution {
public:
    string minWindow(string s, string t) {
        int charCount[128];
        // memset(charCount, 0, sizeof(charCount)); 
        fill(charCount, charCount+128, 0);

        int left = 0, start = -1, minLen = INT_MAX, cnt=0;
        int len1 = s.size(), len2 = t.size();
        
        for(char c: t) {
            charCount[c]++;
        }

        for(int i=0; i<len1; i++) {
            if(--charCount[s[i]] >= 0) {
                cnt++;
            }

            while(cnt == len2) {
                if(minLen > i-left+1) {
                    minLen = i-left+1;
                    start = left;
                }
                if(++charCount[s[left]] > 0) {
                    cnt--;
                }
                left++;
            }
        }
        return start == -1 ? "" : s.substr(start, minLen);
    }
};
