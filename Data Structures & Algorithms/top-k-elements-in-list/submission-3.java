class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length + 1;
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer>[] freqMap = new List[n];

        for(int i=0;i< n;i++){
           freqMap[i] = new ArrayList<>();
        }    
    
        for(int num:nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(int key:map.keySet()){
            freqMap[map.get(key)].add(key);
        }

        // System.out.println(Arrays.toString(freqMap));

        int[] res = new int[k];
        for(int i = n-1; i > 0; i--){
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
