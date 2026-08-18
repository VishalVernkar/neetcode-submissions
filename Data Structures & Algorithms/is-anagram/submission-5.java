class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        int len = s.length();
        int[] chArr = new int[26];
        for(int i=0;i<len;i++){
            chArr[s.charAt(i)-'a']++;
            chArr[t.charAt(i)-'a']--;
        }

        for(int num:chArr){
            if(num!=0) return false;
        }
        return true;
    }
}
