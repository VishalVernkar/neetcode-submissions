class KthLargest {
    PriorityQueue<Integer> pq;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>();
        for(int num : nums){
            pq.offer(num);
            if(pq.size() > k){
                pq.poll();
            }
        }
    }
    
    public int add(int val) {
        pq.offer(val);
        if(pq.size() > k){
            pq.poll();
        }
        return pq.peek();
    }
}


// Priority queue - stores the elements in min or max order
// min is always at the top
// max is always at the top

// max heap
// 

// let's see this one problem to understand how priotiy queue works
// 

// we need min heap if the heap gets more than k - pop the min