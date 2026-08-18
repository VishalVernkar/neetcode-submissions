class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] map = new int[26];

        int n = s.length();
        for(int i = 0; i < n; i++){
            map[s.charAt(i) - 'a']++;
            map[t.charAt(i) - 'a']--;
        }

        for(int num : map){
            if(num != 0) return  false;
        }

        return true;
    }
}

// using char array - add 1 for s and remove 1 for t
