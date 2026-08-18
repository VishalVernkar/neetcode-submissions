class Solution {
    public String minWindow(String s, String t) {
        if(t.isEmpty()) return t;
        int minLen = Integer.MAX_VALUE;

        int[] count = new int[128];
        for(char c : t.toCharArray()){
            count[c]++;
        }

        int need = t.length();
        int l = 0;
        int start = 0;
        int n = s.length();
        for(int r = 0; r < n; r++){
            char right = s.charAt(r);

            if(count[right] > 0) need--;
            count[right]--;

            while(need == 0){
                if((r - l + 1) < minLen){
                    minLen = r - l + 1;
                    start = l;
                }
                char left = s.charAt(l);
                count[left]++;
                if(count[left] > 0) need++;
                l++;
            }
        }
        return (minLen ==  Integer.MAX_VALUE)? "" : s.substring(start, start+minLen);
    }
}


// increase the window till I find all tha chars from xyz
// reduce the window from left till its valid
// now how to track the chars found