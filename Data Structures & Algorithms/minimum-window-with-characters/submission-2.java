class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) return "";
        int minLen = Integer.MAX_VALUE;
        int start = 0;
        int[] map = new int[128];
        for(char c : t.toCharArray()){
            map[c]++;
        }
        
        int l = 0, r = 0, n = s.length();
        int need = t.length();
        while(r < n){
            char c = s.charAt(r);
            
            if(map[c] > 0) need--;
            map[c]--;

            while(need == 0){
                if(r - l + 1 < minLen){
                    minLen = r - l + 1;
                    start = l;
                }
                char lc = s.charAt(l);
                map[lc]++;
                if(map[lc] > 0) need++;
                l++;
            }
            r++;
        }

        return minLen == Integer.MAX_VALUE? "" : s.substring(start, start + minLen);


    }
}

// 15:30

// using sliding window - with map of chars
// expand the window to right till I have all the chars I need
// shrink the window from left till the window is valid
// record the min len

// we create a map for the t string
// as move through the s string - we decerement the chars in the map - means we have these chars in the window
// we use the count of chars in the t as variable to track the chars in the window 
// once we reduce the map of char - we decrement the chars in the "need"
// once the need becomes zero - we have all the chars
// we shrink the window from left // till the window is valid
// 
