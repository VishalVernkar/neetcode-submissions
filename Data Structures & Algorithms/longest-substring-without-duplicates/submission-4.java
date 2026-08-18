class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        if(n==0) return 0;
        // String sub = "";
        StringBuilder sub = new StringBuilder();
        int max=0;
        for(int r=0;r<n;r++){
            if(sub.indexOf(String.valueOf(s.charAt(r))) != -1){
                sub.delete(0, sub.indexOf(String.valueOf(s.charAt(r)))+1);
            }
            sub.append(s.charAt(r));
            max=Math.max(max, sub.length());
        }
        return max;
    }
}
