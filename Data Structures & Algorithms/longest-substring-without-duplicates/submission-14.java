class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int l = 0;
        int r = 0;

        int res = 0;    
        int n = s.length();
        while(r < n){
            if(set.contains(s.charAt(r))){
                while(set.contains(s.charAt(r))){
                    set.remove(s.charAt(l++));
                }
            }
            set.add(s.charAt(r));
            res = Math.max(res, r - l + 1);
            r++;
        }

        return res;

    }
}

// we can use set
// start expanding the window
// by adding char 1 by 1
// if we get a duplicate remove the from left till the duplicate gets removed
// 
