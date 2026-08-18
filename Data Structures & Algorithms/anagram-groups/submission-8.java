class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        int n = strs.length;

        List<String> emptyAnagrams = new ArrayList<>();
        for(String s: strs){
            if(s.isEmpty()) emptyAnagrams.add(s);
        }

        if(!emptyAnagrams.isEmpty()) res.add(emptyAnagrams);

        for(int i=0; i<n; i++){
            String s = strs[i];
            if(s.isEmpty()) continue;
            List<String> anagrams = new ArrayList<>();
            anagrams.add(s);
            for(int j = i + 1; j < n; j++){
                int len = strs[j].length();
                if(len!=0 && s.length()==len) {
                    int[] c = new int[26]; 
                    for(int k=0; k<len; k++){
                        c[s.charAt(k) - 97]++;
                        c[strs[j].charAt(k) - 97]--;
                    }
                    boolean isAnagram = true;
                    for(int val:c){
                        if(val != 0){
                            isAnagram = false;
                            break;
                        }
                    }

                    if(isAnagram){
                        anagrams.add(strs[j]);
                        strs[j] = "";
                    }
                    
                }
            }
            res.add(anagrams);
        }

        return res;
    }
}
