class Solution {
    public String mergeAlternately(String word1, String word2) {
        int w1 = 0;
        int w2 = 0;

        int n = Math.min(word1.length(), word2.length());
        StringBuilder sb = new StringBuilder();
        while(w1 < n){
            sb.append(word1.charAt(w1++)).append(word2.charAt(w2++));
        }

        n = word2.length();
        while(w2 < n){
            sb.append(word2.charAt(w2++));
        }

        n = word1.length();
        while(w1 < n){
            sb.append(word1.charAt(w1++));
        }

        return sb.toString();
    }
}