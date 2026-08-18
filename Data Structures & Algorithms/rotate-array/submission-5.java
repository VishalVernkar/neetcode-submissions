class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        k %= n;
        for(int start = 0; count < n; start++){
            int current = start;
            int prev = nums[start];
            do{
                int idx = (current + k) % n;
                int temp = nums[idx];
                nums[idx] = prev;
                prev = temp;
                current = idx;
                count++;
            } while(start != current);
        }
    }
}

// 9:38

// cycle sort
// place each element to its kth position until I reach the start
// then coninue from next elements

// reversing -> reverse the array - reverse the first k - revers ele after k