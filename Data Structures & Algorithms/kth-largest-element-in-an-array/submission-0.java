class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int num : nums){
            minHeap.offer(num);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }
}

// 12:47 - 13:07
// kth largest element in the array - without sorting

// Hint heap
// we can use priority queue - min heap
// n log k
// log k - for evey insertion
// insert all 
// at the end return kth max elelement

// alternate approaches
// can I simulate heap?
// create an array of size k
// 

// what other ways I can solve this


// I'm sleepy my urge to solve with direct solution is there - but I want to do it in right form