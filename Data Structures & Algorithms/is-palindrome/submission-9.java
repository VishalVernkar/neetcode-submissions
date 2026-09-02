class Solution {
    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;

        while(l < r){
            while(l < r && !isAlphanumeric(s.charAt(l))){
                l++;
            }

            while(l < r && !isAlphanumeric(s.charAt(r))){
                r--;
            }

            if(!equalsIgnoreCase(s.charAt(l), s.charAt(r))){
                return false;
            }
            l++; 
            r--;
        }
        return true;
    }

    private boolean isAlphanumeric(char c){
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
    }

    private boolean equalsIgnoreCase(char a, char b){
        if(a == b){
            return true;
        } else if(a >= 'A' && a <= 'Z'){
            return a == (b - 32);
        } else {
            return a == (b + 32);
        }
        // A = 65
        // a = 97
        // 97 - 65 = 32

    }

}
