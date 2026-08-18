/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        int l = 0;
        int r = n - 1;

        //find peak
        while(l<r){
            int mid = l + (r - l)/2;
            if(mountainArr.get(mid) < mountainArr.get(mid+1)){
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        int peak = l;
        
        //search in left - ascending order
        l = 0;
        r = peak;
        while(l<=r){
            int mid = l + (r - l)/2;
            int midNum = mountainArr.get(mid);
            if(midNum == target) return mid;
            if(midNum < target){
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        //search in left - descending order
        l = peak + 1;
        r = n - 1;
        while(l<=r){
            int mid = l + (r - l)/2;
            int midNum = mountainArr.get(mid);
            if(midNum == target) return mid;
            if(midNum < target){
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return -1;
    }
}

// Question
//

// 2 4 5 2 1
// is it roataed arrray like 4 5 6 1 2
// low - high - low(pivot) - high

// ex
// 1 2 2 4 5

// ex
// 1 2 3 4 2 1

// consider peak - max number
// left part - low to high - ascending order
// right part - high to low - descending order
// Here both are sorted side but in opposite way


// condier ex - let's try rotated array search
// 1 2 3 4 5 3 2 1
// if mid > right, left part is sorted
//  - but also true at 2 from left - and it can exist on both side - I cannot say with gaurantee to go one side to find 
//  - other way,
//      find the peak point and search both sides
//
// Now, how to find peak point
// left -> mid -> right
// left to mid - left < mid
// this won't work why?

// I feel I have to converge from both  to highest point how
// left - high - right
// or
// can I some how record the highest point

// ex
// 1 5 4
// 
// left < mid < right - sorted position
// left < mid 


// left---------------------------------mid------------peak-----------------------------right
// left  < mid  and mid > right
// left sorted - 
// left---------------------------------------------peak------mid-----------------------right
// left < mid - mid > right

// 0---------------------------------------------peak-------left-----mid-----------------------right
// 0----------------------------------------left-----peak------------mid-----------------------right
// left > mid > right 

// left---------------mid-------------right-----------------peak-----------------------------n-1
// left < mid < right

// this not working, why?
// left- mid - right - true in multipleposition can't determinse with this where peak is

// brute force
// while left < left + 1 and while rigt - 1 > right
// l++ 
// r-- 
// can use this in binary way? - but mid can come on both sides - idk if mid is on left side of peak or right side of peak 



// Remember rotated array
// 4 5 6 1 2
// based on sorted side -> check element exisit there -> it yes move to sorted side -> else to other side