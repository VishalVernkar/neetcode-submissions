class Solution {
    public String longestCommonPrefix(String[] strs) {

        String smallestWord = strs[0];
        for(String s : strs)
        {
            if(s.length() < smallestWord.length())
            {
                smallestWord = s;
            }
        }

        StringBuilder result = new StringBuilder();
        int i = 0;
        boolean didBreak = false;
        for( i =0 ; i < smallestWord.length();i++)
        {
            char ch = smallestWord.charAt(i);
            for(String s : strs)
            {
                if(s.charAt(i) != ch)
                {
                    didBreak = true;
                    break;
                }
                
                
            }
            if(didBreak) break;
        }
        if(i == 0)
        {
            return "";
        }
        return smallestWord.substring(0, i);
        
    }
}