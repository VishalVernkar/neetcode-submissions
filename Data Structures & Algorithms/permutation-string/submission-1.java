class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()) return false;
        int[] f1 = new int[26];
        int[] f2 = new int[26];

        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();

        // to use it to check for first window
        for(int i=0;i<str1.length;i++){
            f1[str1[i]-'a']++;
            f2[str2[i]-'a']++;
        }

        // i'm using matches variable to track the match in the window size of str1.length
        // first calculate the number of matches
        int matches = 0;
        for(int i=0;i<26;i++){
            if(f1[i] == f2[i]){
                matches++;
            }
        }

        int n = str2.length;
        int l=0;
        for(int r=str1.length;r<n;r++){
            // i want to add one char in a window and see if it matches
            // i want to remove the left char to keep the window in fixed size
            if(matches == 26) return true;
            int index = str2[r]-'a';
            // add next char to window
            f2[index]++;
            if(f2[index] == f1[index]){
                matches++;
            } else if(f2[index] - 1 == f1[index]){
                matches--;
            }

            // reduce the window - l++
            index = str2[l] - 'a';
            f2[index]--;
            if(f2[index] == f1[index]){
                matches++;
            } else if(f2[index] + 1 == f1[index]){
                matches--;
            }
            l++;
        }
        return matches == 26;
    }
}


