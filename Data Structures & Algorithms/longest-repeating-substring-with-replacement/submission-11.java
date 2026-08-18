class Solution {
    public int characterReplacement(String s, int k) {
        int res = 0;
        int[] map = new int[26];
        int n = s.length();
        int l = 0,  r = 0, maxf = 0;
        while(r < n){
            map[s.charAt(r) - 'A']++;
            maxf = Math.max(maxf, map[s.charAt(r) - 'A']);
            if(r - l + 1 > maxf + k){
                map[s.charAt(l) - 'A']--;
                l++;
            }
            res = Math.max(res, r - l + 1);
            r++;
        }
        return res;
    }
}

//9:36

// longest repeating character
// I can replace k chars


// brute force
// starting from each char expand till count of char + k different char
// record length
// O(n^2)

// optimal
// sliding window
// track the max char in the current window - using map
// expand to right till -> max char + k
// reduce the window from the left till -> max char + k is valid
//   
