class Solution {
    public void reverseString(char[] s) {
        int l = 0;
        int r = s.length - 1;
        while(l<r){
            // swap
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;
            l++;
            r--;
        } 
    }
}

// reverse a string - two pointers
// we can cuse left and right pointer
// left = 0 and right = n - 1
// while(l<r)
// we swap values from left to right