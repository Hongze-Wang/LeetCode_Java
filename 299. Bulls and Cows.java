// 299. Bulls and Cows

class Solution {
public:
    string getHint(string secret, string guess) {
        int a=0, b=0;
        vector<int> map(10);
        for(int i=0; i<secret.length(); i++) {
            if(guess[i] == secret[i]) {
                a++;
            } else {
                map[secret[i]-'0']++;
            }
        }
        for(int i=0; i<guess.length(); i++) {
            if(!(secret[i] == guess[i]) && map[guess[i]-'0'] > 0) {
                map[guess[i]-'0']--;
                b++;
            }
        }
        return to_string(a) + "A" + to_string(b) + "B";
    } 
};
