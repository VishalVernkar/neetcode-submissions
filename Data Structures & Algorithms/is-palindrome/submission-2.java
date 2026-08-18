class Solution {
    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        s = s.toLowerCase();
        while(l<r){
            while(l<r && !isAlphaNumeric(s.charAt(l))){
                l++;
            }
            while(l<r && !isAlphaNumeric(s.charAt(r))){
                r--;
            }
            if(s.charAt(l)!=s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public boolean isAlphaNumeric(char c){
        return (c >= 'A' && c <='Z') || (c >= 'a' && c <='z') || (c >= '0' && c <='9');
    }
}

// we can use two pointers to validate palidrome
// using left = 0 and right = n - 1
// if we encounter non alphanumeric char than we skip that index
// i have to conver it to lower case?
