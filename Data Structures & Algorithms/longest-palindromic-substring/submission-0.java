class Solution {
    public String longestPalindrome(String s) {
        int res = 0;
        int n = s.length();
        int start = 0;
        for(int i = 0; i < n; i++){

            // for odd length;
            int l = i;
            int r = i;
            while(l >= 0 && r < n  && s.charAt(l) == s.charAt(r)){
                if(r - l + 1 > res){
                    res = r - l + 1;
                    start = l;
                }
                l--;
                r++;
            }

            // for even length;
            l = i;
            r = i + 1;
            while(l >= 0 && r < n  && s.charAt(l) == s.charAt(r)){
                if(r - l + 1 > res){
                    res = r - l + 1;
                    start = l;
                }
                l--;
                r++;
            }
        }

        return s.substring(start, start + res);
    }
}
