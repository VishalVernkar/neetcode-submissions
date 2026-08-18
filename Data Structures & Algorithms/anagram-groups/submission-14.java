class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String str:strs){
            int[] chrs = new int[26];
            for(int i = 0; i < str.length(); i++){
                chrs[str.charAt(i) - 'a']++;
            }
            String key = Arrays.toString(chrs);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }
        List<List<String>> res = new ArrayList<>();
        for(List<String> list : map.values()){
            res.add(list);
        }
        return res;
    }
}

//9:53

// using char array
// convert each string to char array
// use hash map key to list of strings -> in hashmap -> add char array to string -> add the matches string to list
