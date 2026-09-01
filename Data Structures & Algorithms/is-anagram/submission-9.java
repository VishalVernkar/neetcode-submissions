class Solution {
    public boolean isAnagram(String s, String t) {
        int n = s.length();
        if(n != t.length()) return false;
        int[] chf = new int[26];

        for(int i = 0; i < n; i++){
            chf[s.charAt(i) - 'a']++;
            chf[t.charAt(i) - 'a']--;
        } 

        for(int fq : chf){
            if(fq != 0) return false;
        }

        return true;

    }
}

// using char array
// if the same two array has same chars the array is empty
