class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder(strs[0]);
        
        for(String s: strs){
            int count = 0;
            int i = 0;
            int n = Math.min(sb.length(), s.length());
            while(i < n && sb.charAt(i) == s.charAt(i)){
                count++;
                i++;
            }
            if(sb.length()>count){
                sb.setLength(count);
            }
        }
        return sb.toString();
    }
}

// common prefix
// 
