class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // a-1 (n logn)
        // taking diff of each element
        // use binary search to find diff

        // best
        // add first and last elements and compare to target
        // if it is more reduce the last
        // else if less increase the first
        // else you found the result

        int l=0; int r=numbers.length-1;
        while(l<r){
            int curSum=numbers[l]+numbers[r];
            if(curSum > target){
                r--;
            } else if(curSum < target){
                l++;
            }else{
                return new int[]{l+1,r+1};
            }
        }
        return new int[2];
    }
}
