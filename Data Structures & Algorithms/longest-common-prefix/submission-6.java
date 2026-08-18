class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        String s = strs[0];

        for(int i = 1; i < n; i++){
            String t = strs[i];
            int m = Math.min(s.length(), t.length());
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < m; j++){
                if(s.charAt(j) == t.charAt(j)) {
                    sb.append(s.charAt(j));
                } else {
                    break;
                }
            }
            s = sb.toString();
        }

        return s;
    }
}