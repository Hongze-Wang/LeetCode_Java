// 151. Reverse Words in a String

class Solution {
    public String reverseWords(String s) {
        String[] temp = s.split(" ");
        int i=0, j=temp.length-1;

        while(i < j) {
            while(i<temp.length-1 && temp[i].equals(" ")) {
                i++;
            }
            while(j>0 && temp[j].equals(" ")) {
                j--;
            }
            if(i >= j) break;

            String str = temp[i];
            temp[i] = temp[j];
            temp[j] = str;
            i++;
            j--;
        }
        StringBuilder sb = new StringBuilder("");

        for(String str: temp) {
            if(!str.equals("")) {
                sb.append(str).append(" ");
            }
        }
        if(sb.length() > 0) {
            sb.setLength(sb.length()-1);
        }
        return sb.toString();
    }
}
