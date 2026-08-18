class Solution {
    public int removeElement(int[] nums, int val) {
        int size = 0;
        int n = nums.length;
        int[] res = new int[n];
        for(int num: nums){
            if(num != val) {
                res[size++] = num;
            }
        }

        for(int i=0; i<size; i++){
            nums[i] = res [i];
        }

        return size;
    }
}