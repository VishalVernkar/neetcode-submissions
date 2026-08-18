class Solution {
    public void rotate(int[] nums, int k) {
        k = (k>=nums.length)?k%nums.length:k; 
        if(k==0) return;
        int idx = nums.length-k;
        int[] ele = new int[k];
        for(int i=idx;i<nums.length; i++){
            ele[i-idx] = nums[i];
        }
        idx--;
        for(int i=nums.length-1;i>=k;i--){
            nums[i]=nums[idx--];
        }

        idx = 0;
        for(int num:ele){
            nums[idx++] =  num;
        }
        // a-1
        // store the last k elements
        // and in those last places move the previous elemnets till biginning 4 places left
    }
}