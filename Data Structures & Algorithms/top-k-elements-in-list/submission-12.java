class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] freq = new List[nums.length + 1];
        for(int num : map.keySet()){
            int f = map.get(num);
            if(freq[f] == null){
                freq[f] = new ArrayList<>();
            }
            freq[f].add(num);
        }
        int idx = 0;
        int[] res = new int[k];
        for(int i = nums.length; i >= 0; i--){
            if(freq[i] != null){
                for(int num : freq[i]){
                    res[idx++] = num;
                    if(idx == k) return res;
                }
            }

        }
        return res;
    }
    // map to count freqency
    // 
    // using freq array - to num
    //
}
