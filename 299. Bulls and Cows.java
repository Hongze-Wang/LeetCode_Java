// 299. Bulls and Cows

class Solution {
    public String getHint(String secret, String guess) {
        int a=0, b=0;
        int[] countSecret = new int[10];
        int[] countGuess = new int[10];
        for(int i=0; i<secret.length(); i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if(s == g) {
                a++;
            } else {
                countSecret[s-'0']++;
                countGuess[g-'0']++;
            }
        }
        for(int i=0; i<10; i++) {
            b += Math.min(countSecret[i], countGuess[i]);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(a).append("A").append(b).append("B");
        return sb.toString();
        // return String.valueOf(a) + "A" + String.valueOf(b) + "B"; // sb is faster
    }
}
