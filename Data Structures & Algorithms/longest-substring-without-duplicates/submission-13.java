class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int maxLen = 0;
        int l = 0, r = 0, n = s.length();
        while(r < n){
            char c = s.charAt(r);
            if(set.contains(c)){
                while(set.contains(c)){
                    set.remove(s.charAt(l));
                    l++;
                }
            }
            maxLen = Math.max(maxLen, r - l + 1);
            set.add(c);
            r++;
        }
        return maxLen;
    }
}


// uisng char array - boolean
// update each char in set
// expand the window if the new char already exists
// move l till we reach that char
// then coninue expanding window