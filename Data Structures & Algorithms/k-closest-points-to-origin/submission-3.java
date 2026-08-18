class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int left = 0;
        int right = points.length - 1;

        while(true){
            int pivotIdx = partition(points, left, right);

            if(pivotIdx == k - 1) return Arrays.copyOf(points, k);
            else if(pivotIdx < k) left = pivotIdx + 1;
            else right = pivotIdx - 1;
        }
    }

    private int partition(int[][] points, int left, int right){
        int[] pivot = points[right];
        int pivotDist = getDistance(pivot);
        int i = left;

        for(int j = left; j < right; j++){
            if(getDistance(points[j]) <= pivotDist){
                swap(points, i, j);
                i++;
            }
        }
        swap(points, i, right);
        return i;
    }

    private void swap(int[][] points, int i, int j){
        int[] temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }

    private int getDistance(int[] point){
        return point[0] * point[0] + point[1] * point[1];
    }
}

// 5:34 - 5:54

// Question
// return k points that is closer to 0,0

// Approach
// Quick select
// I need k elements from left part of array
// If I get the kth position element right and all the elements smaller than that to left I have the ans

// steps
// slect a pivot -> right most -> becasue traversing the whole array helps us to move most elements in the right part everytime
// find it's correct position
// if its pos is equal to k. we have the element we need -> and all its elements less than that to left
// we return copy of that part

// algo
// while, till we find the correct kth pivot point 
// we take the array -> 
// we find the pivot of right most element
// based where it lies, if it is after k -> we update right boundary -> pivot - 1;
// else -> lrft boundary -> pivot + 1

// partition -> get all the element less than pivot to its left
// if each num form left to right < pivot -> swap -> update swap pos to next
// else, move to next element -> without updating swap pos
// at the end we have the right pos of pivot element -> which is swap pos
// we swap at the end 
// return pivot point;


