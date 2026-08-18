class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0, r = 0, res = 0;
        int n = s.length();
        Set<Character> set = new HashSet<>();
        while(r < n){
            while(set.contains(s.charAt(r))){
                set.remove(s.charAt(l));
                l++;
            }
            set.add(s.charAt(r));
            res = Math.max(res, r - l + 1);
            r++;
        }
        return res;
    }
}

// 11:32

// hashset
// expand the window - till no duplicate chars are there
// reduce the window till the duplicate is no more there

// start from left
// add once by one 
//  update the res
// if it already exists
// keep reomving from left till it is not there anymore