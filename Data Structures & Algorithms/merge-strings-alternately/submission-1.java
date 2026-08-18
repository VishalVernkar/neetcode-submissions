class Solution {
    public String mergeAlternately(String word1, String word2) {
        int len = word1.length(); // small word
        String word = word2;
        if(word1.length() >= word2.length()){
            word = word1;
            len = word2.length();
        }

       

        int l = 0, r = 0;
        StringBuilder sb = new StringBuilder();
        while(l < len){
            sb.append(word1.charAt(l++)).append(word2.charAt(r++));
        }
        
        //int len = word.length();
        sb.append(word.substring(l));
        return sb.toString();
    }
}

// I'll use string builder
// two pointers
// one at start of each string
// how to move them
// I'll take smaller string length create string
// then add remaining ones