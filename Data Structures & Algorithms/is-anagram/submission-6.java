class Solution {
    public boolean isAnagram(String s, String t) {
        int n = s.length();
        if(n != t.length()){
            return false;
        }
        int[] charsFreq = new int[26];
        for(int i=0; i<n; i++){
            charsFreq[s.charAt(i)-'a']++;
            charsFreq[t.charAt(i)-'a']--;
        }

        for(int count:charsFreq){
            if(count!=0){
                return false;
            }
        }
        return true;

    }
}

// using hash map
// 

// using 26 size array map
