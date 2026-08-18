class Solution {
    public String mergeAlternately(String word1, String word2) {
        String small, big; 
        if(word1.length()>word2.length()){
            small = word2;
            big = word1;
        }else{
            small = word1;
            big = word2;
        }
        int n=small.length();
        String res = "";
        for(int i=0;i<n;i++){
            res+=word1.charAt(i)+""+word2.charAt(i);
        }
        res+=big.substring(small.length());
        return res;
    }
}