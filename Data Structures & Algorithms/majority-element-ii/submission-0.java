class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for(int num:nums){
            freq.put(num, freq.getOrDefault(num,0)+1);

            
        }

        freq.forEach((key,value) -> {
            if(value > nums.length/3) res.add(key);
        });
        return res;
    }
}