class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        int count = 0;
        for(int i = 0; count < n; i++){
            int start = i;
            int cur = i;
            int prev = nums[start];
            do {
                int next = (cur + k)%n;
                int temp = nums[next];
                nums[next] = prev;
                cur = next;
                prev = temp;
                count++;
            } while(start != cur);
        }
    }
}