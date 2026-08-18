class Solution {
    public boolean checkInclusion(String s1, String s2) {

        int m = s1.length();
        int n = s2.length();

        if(m>n) return false;

        int[] s1Freq = new int[26];
        int[] winFreq = new int[26];

        for(int i = 0; i < m; i++){
            s1Freq[s1.charAt(i) - 'a']++;
            winFreq[s2.charAt(i) - 'a']++;
        }

        System.out.println(Arrays.toString(s1Freq));
        System.out.println(Arrays.toString(winFreq));

        int matches = 0;
        for(int i = 0; i < 26; i++){
            if(s1Freq[i] == winFreq[i]) matches++;
        }

         System.out.println(matches);

        for(int i = m; i < n; i++){
            if(matches == 26) return true;

            // Add char to window
            int ch = s2.charAt(i) - 'a';
            winFreq[ch]++;
            // increment matches if adding this char to window is equal to s1Freq[c]
            if(s1Freq[ch] == winFreq[ch]){
                matches++;
            // check if previously it was match    
            } else if(s1Freq[ch] == winFreq[ch] - 1){
                matches--;
            }

            // Remove char from start window
            ch = s2.charAt(i - m) - 'a';
            winFreq[ch]--;
            // increment matches if adding this char to window is equal to s1Freq[c]
            if(s1Freq[ch] == winFreq[ch]){
                matches++;
            // check if previously it was match    
            } else if(s1Freq[ch] == winFreq[ch] + 1){
                matches--;
            }
        }

        return matches == 26;
    }
}

// we can track the through count the matches
// if the chars in window matches the s1 - then we have its permutation
// we can use 26 size char array
// one to get the freq in s1
// and another one to get the freq in current window of s2
// once we get the matches 26 == 26 we have the answer

