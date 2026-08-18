class Solution {
    public void rotate(int[] nums, int k) {

        int n = nums.length;
        k = k % n;

        int count = 0;
        for(int start = 0; count < n; start++){
            int currentIdx = start;
            int prevVal = nums[start]; 
            do{
                int nextIdx = (k + currentIdx) % n;
                int temp = nums[nextIdx];
                nums[nextIdx] = prevVal;
                prevVal = temp;
                currentIdx = nextIdx;
                count++;
            } while(start != currentIdx);
        }
    }
}
 
// by swapping    0 1 2 3 4 5 6 7
// Input: nums = [1,2,3,4,5,6,7,8], k = 7

// 
             //   0 1 2 3 4 5 6 7
// Input: nums = [1,2,3,4,5,6,7,8], k = 4

// Output: [5,6,7,8,1,2,3,4]
// using cyvlic traversal
// till I reach start position 
// keep swapping numbers to its right position
// once start is reached
// start from next index