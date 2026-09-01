class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 1) return strs[0];
        StringBuilder prefix = new StringBuilder();
        StringBuilder s1 = new StringBuilder(strs[0]);
        String s2;
        int n = strs.length;
        for(int i = 1; i < n; i++){
            s2 = strs[i];
            int m = Math.min(s1.length(), s2.length());
            int j = 0;
            prefix = new StringBuilder();
            while(j < m && s1.charAt(j) == s2.charAt(j)){
                prefix.append(s1.charAt(j++));
            }
            s1 = prefix;
        }

        return new String(prefix);
    }
}

// compare two strings
// take min length
// compare eah char 
// build the prefix
// compare with each next string