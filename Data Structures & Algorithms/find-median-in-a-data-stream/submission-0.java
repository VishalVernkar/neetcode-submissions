class MedianFinder {
    List<Integer> list;

    public MedianFinder() {
        list = new ArrayList<>();
    }
    
    public void addNum(int num) {
        int l = 0;
        int r = list.size();
        int n = r;

        while(l < r){
            int mid = l + (r - l) / 2;
            if(list.get(mid) <= num){
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        
        if(l == n){
            list.add(num);
        } else {
            list.add(l, num);
        }
        
    }
    
    public double findMedian() {
        int n = list.size();

        if(n%2 == 0){
            int pos = n/2;
            // double res =  (double) ((list.get(pos-1) + list.get(pos)) / 2);
            return (list.get(pos-1) + list.get(pos)) / 2.0;
        } else {
            return (double) list.get(n/2);
        }
    }
}

// 20 mins to try this 
// observe myself
// focus on breath

// Not focusing clearly on understanding the question
// Desperate to get the solution 

// 14:56 - 15:16

// Question
// A data stream  of numbers
// give the mdian of list

// add
// add in sorted order
// binary search the position and add the value

// median 
// get the median based on mid point of array


// Alternate approaches
// Hint: Heap
// 
