class Solution {
    public boolean isPalindrome(String s) {
        int l = 0; int r=s.length()-1;
        while(l<r){
            char left = s.charAt(l);
            while(l<r && !Character.isLetterOrDigit(left)){
                left = s.charAt(++l);
            }
            char right = s.charAt(r);
            while(l<r && !Character.isLetterOrDigit(right)){
                right = s.charAt(--r);
            }
            if(Character.toLowerCase(left) != Character.toLowerCase(right) ){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
