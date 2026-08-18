class KthLargest {
    private PriorityQueue<Integer> minHeap;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>();
        for(int num : nums){
            add(num);
        }
    }
    
    public int add(int val) {
        minHeap.offer(val);
        if(minHeap.size() > k) minHeap.poll();

        return minHeap.peek();
    }
}

// I want to learn how heap is created
// in tree 
// in array form of tree
// how insertion 
// how deletion is done
// its main purpose is for getting min or max in O(1)

 // 18:25 - 18:45

 // Question
 // For every value insert I should return kth largest element at that point

 // steps 
 // use a min heap -> of size k
 // min heap -> min at the top -> max below it -> for every new value added -> if size exceeds k -> we remove min value


























// $0d geive kth largest from end?

// k = 3
 // 0 1 2 3
 // 1 2 3 3

 // 1 2 3 3 3 -> 3
 // 1 2 3 3 3 5 -> 3
 // 1 2 3 3 3 5 6-> 3
 // 1 2 3 3 3 5 6 7-> 3
 // 1 2 3 3 3 5 6 7 8-> 3


  // Question
 // For every value insertd geive kth largest 

 // 4, 5, 8, 2

// k = 3

 // 2 4 5 8
 // 2 3 4 5 8
 // 2 3 4 5 5 8
 // 2 3 4 5 5 8 10
 // 2 3 4 5 5 8  9 10
 // 2 3 4 4 5 5  8  9 10

// Hint - heap
// bute force 
// sort the array once
// binary search the positon to insert and insert it
// 