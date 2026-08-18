class Solution {
    public void rotate(int[] nums, int k) {
        // using reverse
        // using cyclic replacement
        int count =0;
        k = k%nums.length;
        for(int start=0; count<nums.length; start++){
            int current = start;
            int prev = nums[current];
            int nextIdx;

            do{
                nextIdx = (current+k)%nums.length;
                int temp = nums[nextIdx];
                nums[nextIdx] = prev;
                prev = temp;
                current = nextIdx;
                count++;
            }while(start != current);
        }
        
    }
}