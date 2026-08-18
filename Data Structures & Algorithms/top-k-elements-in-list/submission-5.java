class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer>[] freqMap = new List[n+1];

        for(int i=0;i<n;i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            freqMap[i] =  new ArrayList<>();
        }
        freqMap[n] =  new ArrayList<>();

        for(int key:map.keySet()){
            freqMap[map.get(key)].add(key);
        }

        int[] res = new int[k];
        for(int i = n; i > 0; i--){
            for(int num:freqMap[i]){
                 res[--k] = num;
                 if(k==0) return res;
            }
        }
        return res;
    }
    // k most frequent elements
    // using hash map
    // I can frequeny 
    // how to return top k elements
    // put it in array -> sort the array

    
}
