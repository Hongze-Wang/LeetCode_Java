// 151. Reverse Words in a String

class Solution{
public:
    string reverseWords(string s) {
        string str1, str2;
        stringstream ss(s);
        for(ss>>str1; ss>>str2;) {
            str1 = move(str2 + " " + str1);
            // str1 = move(str2.append(" " + str1));
        }
        return str1;
    }
};
