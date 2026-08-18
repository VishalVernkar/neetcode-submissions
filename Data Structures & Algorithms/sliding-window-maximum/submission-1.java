class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> queue = new ArrayDeque<>();

        int l = 0;
        for(int r = 0; r < n; r++){
            while(!queue.isEmpty() && nums[queue.getLast()] < nums[r]){
                queue.removeLast();
            }
            queue.addLast(r);

            if(l > queue.getFirst()) queue.removeFirst();

            if(r+1 >= k){
                res[r+1-k] = nums[queue.getFirst()];
                l++;
            }
        }
        return res;
    }
}
