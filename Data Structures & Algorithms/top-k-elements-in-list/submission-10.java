class Solution {
    public int[] topKFrequent(int[] nums, int k) {
       Map<Integer, Integer> map = new HashMap<>();
       for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
       } 
       List<Integer>[] freqMap = new List[nums.length + 1];
       for(int num : map.keySet()){
            if(freqMap[map.get(num)] == null) freqMap[map.get(num)] = new ArrayList<>();
            freqMap[map.get(num)].add(num);
       }

       int[] res = new int[k];
       int idx = 0;
       for(int i = nums.length; i > 0; i--){
            if(freqMap[i] != null){
                for(int num : freqMap[i]){
                    res[idx++] = num;
                    if(idx == k) return res;
                }
            }
       }
       return res;
    }
}

// 9:57

// hashmap of key -> freq +  using freq map - freq -> list of nums
// traverse from the end of freq map to get the top 2