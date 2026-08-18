class Solution {
    public boolean validPalindrome(String s) {
        int l=0; int r = s.length()-1;
        // if(r==1) return true;
        while(l<r){
            if(s.charAt(l)!=s.charAt(r)){

                return isPalindrome(s, l, r-1) || isPalindrome(s, l+1, r);

            }
            l++;
            r--;
        }
        return true;
    }

    public boolean isPalindrome(String s, int l, int r){
        while(l<r){
            if(s.charAt(l)!=s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;

    }
}