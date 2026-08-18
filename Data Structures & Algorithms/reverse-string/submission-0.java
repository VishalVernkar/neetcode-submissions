class Solution {
    public void reverseString(char[] s) {
        int n = s.length/2;
        int lastIndex = s.length - 1;
        for(int i=0; i<n; i++){
            char temp = s[i];
            s[i] = s[lastIndex-i];
            s[lastIndex-i] = temp;
        }        
    }
}