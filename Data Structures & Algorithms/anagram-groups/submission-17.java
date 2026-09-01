class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String s : strs){
            int[] ch = new int[26];
            for(char c : s.toCharArray()){
                ch[c - 'a']++;
            }
            map.computeIfAbsent(Arrays.toString(ch), k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(map.values());

    }
}

// using hash map
// with key = the char map - reperesneted as string
// values being list of mtaches chars
