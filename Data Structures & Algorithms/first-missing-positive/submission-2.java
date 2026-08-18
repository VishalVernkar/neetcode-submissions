class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int i = 0;

        while(i < n){
            if(nums[i] < 0) nums[i] = 0;
            i++;
        }

        i = 0;
        while (i < n) {
            if (nums[i] == 0 || nums[i] > n) {
                i++;
                continue;
            }
            int idx = nums[i] - 1;
            if(nums[i] != nums[idx]){
                int temp = nums[idx];
                nums[idx] = nums[i];
                nums[i] = temp;
            } else {
                i++;
            }
        }

        i = 0;
        while (i < n) {
            if (nums[i] != i + 1) return i + 1;
            i++;
        }

        return n + 1;
    }
}

// 15:18

//
// cycle sort
// or
// negative marking

// place each number in a right place
// move if it is a negative or zero
// get nums[i] = x
// place x in nums[x]
// and nums[x] in

// 0 - 1
// 1 - 2