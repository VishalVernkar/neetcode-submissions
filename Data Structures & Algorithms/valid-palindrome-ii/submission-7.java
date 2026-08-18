class Solution {
    public boolean validPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while(l < r) {
            if(s.charAt(l) != s.charAt(r)) {
                return isPalindrome(s, l + 1, r) || isPalindrome(s, l, r - 1);
            }
            l++; r--;
        }
        return true;
    }

    private boolean isPalindrome(String s, int l, int r){
        while(l < r) {
            if(s.charAt(l) != s.charAt(r)) return false;
            l++; r--;
        }
        return true;
    }
}

// 4:36

// we can remove one char
// if we remvove one char
// while comparing, we can remove left or right -> the possibility
// 

// compare from left and right
// if it is not same
// try two possiblilty by moving left and continue comparisions
// or
// by moving right and continue comparision
// if any of these possiblilyt is true return true\

// create another function to check if palindrome