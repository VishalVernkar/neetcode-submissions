class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String str : strs){
            int[] freq = new int[26];
            for(char c : str.toCharArray()){
                freq[c - 'a']++;
            }
            String key = Arrays.toString(freq);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }

        List<List<String>> res = new ArrayList<>(map.values());
        return res;
    }
}


// using hash map
// key - array of char frequency
// values - list matching the key