class Solution {
    public boolean isAnagram(String s, String t) {
        int len = s.length();
        if(len != t.length()) return false;
        int[] s1 = new int[26];
        int[] s2 = new int[26];
        for(int i = 0; i < len; i++){
            s1[s.charAt(i) - 'a']++;
            s2[t.charAt(i) - 'a']++;
        }

        for(int i = 0; i < 26; i++){
            if(s1[i] != s2[i]) return false;
        }

        return true;
    }
}

// using char array
