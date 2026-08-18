class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        int[] sMap = new int[26];
        int[] winMap = new int[26];

        int n = s1.length();
        for(int i = 0; i < n; i++){
            sMap[s1.charAt(i) - 'a']++;
            winMap[s2.charAt(i) - 'a']++;
        }

        int matches = 0;
        for(int i = 0; i < 26; i++){
            if(sMap[i] == winMap[i]) matches++;
        }

        int l = 0;
        for(int r = n; r < s2.length(); r++){
            if(matches == 26){
                return true;
            }

            // add char from right
            int c = s2.charAt(r) - 'a';
            winMap[c]++;
            if(sMap[c] == winMap[c]){
                matches++;
            } else if(sMap[c] == winMap[c] - 1) {
                matches--;
            }

            // reomve char from left
            c = s2.charAt(l) - 'a';
            winMap[c]--;
            if(sMap[c] == winMap[c]){
                matches++;
            } else if(sMap[c] == winMap[c] + 1) {
                matches--;
            }
            //System.out.println(matches);
            l++;
        }

        if(matches == 26){
            return true;
        }
        return false;
    }
}

// 16:18

// using char map of 26 
// for window
// for s1

// we get freq map for s1
// we get freq of fist window in s2

// then move along the widow
// update the chars in the window map
// if matches return true
// shrink the window
// if the 

// let's reach solution based on the idea
// move along the window
// 