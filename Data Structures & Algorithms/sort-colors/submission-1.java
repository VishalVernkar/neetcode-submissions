class Solution {
    public void sortColors(int[] nums) {
        int[] freq = new int[3];
        for(int num: nums){
            freq[num]++;
        }
        int index = 0;
        int n = nums.length;
        for(int i=0; i<n; i++){
            if(freq[index] == 0){
                if(freq[++index] == 0){
                    index++;
                }
            }
            nums[i] = index;
            freq[index]--;
        }
    }
}