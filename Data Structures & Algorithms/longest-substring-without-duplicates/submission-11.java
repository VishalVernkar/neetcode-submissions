class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n==1) return 1;
        Set<Character> set = new HashSet<>();
        int maxLen = 0;
        int l = 0;
        for(int r = 0; r<n; r++){
            while(set.contains(s.charAt(r))){
                set.remove(s.charAt(l));
                l++;
            }
            set.add(s.charAt(r));
            maxLen = Math.max(maxLen, r-l+1);
            // System.out.println(s.substring(l, r+1));
        }
        return maxLen;
    }
}

// I can use the hashset to keep valid window

// or 
// just the pointers is enough -> this won't work for abcbb - we need hashset

// l = 0, r = 1
// if l == r -> l++, r++
// r++
// record max length

