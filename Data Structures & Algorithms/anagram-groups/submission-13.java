class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String, List<String>> map = new HashMap<>();
        for(String str: strs){
            int[] charsFreq = new int[26];
            for(char ch:str.toCharArray()){
                charsFreq[ch-'a']++;
            }
            String key = Arrays.toString(charsFreq);
            System.out.println(key);
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        List<List<String>> res = new ArrayList<>();
        for(List val:map.values()){
            res.add(val);
        }
        return res;

    }
}

// convert each string to freqmap -> 
// put it in hashmap
// if any matches comes just add them to the map