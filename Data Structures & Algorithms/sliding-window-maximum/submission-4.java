class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q = new LinkedList<>();

        int l = 0, r = 0, n = nums.length, idx = 0;
        int[] res = new int[n - k + 1]; 

        while( r < n){
            while(!q.isEmpty() && nums[q.peekLast()] < nums[r]){
                q.removeLast();
            }

            q.offerLast(r);

            if(l > q.peekFirst()){
                q.removeFirst();
            }

            if(r + 1 >= k){
                res[idx++] = nums[q.getFirst()];
                l++;
            }
            r++;
        }

        return res;

    }
}

// 15:47

// we can use deque
// we keep the index of the elements
// we always keep big elements first then small in increasing order
// if we cross the window we rmove the element from left

// we insert each element from end
// before inserting we remove all the small elements
// then the current one

// if the element at first is before the left pointer we remove the first elemetn
// if r is at window size k 
// we get the result form front of the queue
