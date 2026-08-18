class Solution {
    public boolean validPalindrome(String s) {
        int l=0; int r = s.length()-1;
        if(r==1) return true;
        boolean isRemoved = false;
        while(l<r){
            if(s.charAt(l)!=s.charAt(r)){

                return isPalindrome(s, l, r-1) || isPalindrome(s, l+1, r);

                // if(!isRemoved && l<r-1 && s.charAt(l) == s.charAt(r-1)){
                //     r--;
                //     isRemoved = true;
                // } else if(!isRemoved && l+1 < r && s.charAt(l+1) == s.charAt(r)){
                //     l++;
                //     isRemoved =  true;
                // } else if(!isRemoved && r-l == 1){
                //     return true;
                // } else {
                //     return false;
                // }
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