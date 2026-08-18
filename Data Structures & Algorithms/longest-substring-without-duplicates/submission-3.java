class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        if(n==0) return 0;
        String sub = "";
        int max=0;
        for(int r=0;r<n;r++){
            if(sub.indexOf(s.charAt(r)) != -1){
                sub=sub.substring(sub.indexOf(s.charAt(r))+1);
            }
            sub+=s.charAt(r);
            max=Math.max(max, sub.length());
        }
        return max;
    }
}
