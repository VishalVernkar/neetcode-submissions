class MedianFinder {
    PriorityQueue<Integer> minHeap; // right part
    PriorityQueue<Integer> maxHeap; // left part

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());

        if(minHeap.size() > maxHeap.size()){
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if(minHeap.size() ==  maxHeap.size()) return (minHeap.peek() + maxHeap.peek()) / 2.0;
        return maxHeap.peek();
    }
}

// 10:30 - 10:45

// Question
// Find meadian in the list

// we store the list in the order
// weher we divide the data into two parts
// left half and right half
// left half has smaller elements
// right half has bigger elements

// we can use min heap for right hlf
// max heap for right half

// if size is equal = even
// else unequal 
