class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;
        while(l<r){
            int sum = numbers[l] + numbers[r];
            if(sum == target){
                return new int[]{l+1,r+1};
            } else if(sum < target){
                l++;
            } else {
                r--;
            }
        }
        return null;
    }
}

// I'll try binary search to find the target
// this doesn't work as the indexes are not consecutive


// it has to be O(n)
// two pointers;
// add first and last number
// if it is greater than number I have to reduce so r--
// if it is smaller I have to increase so l++


//  int mid = l + (r - l) / 2;
//             int sum = numbers[mid] + numbers[mid + 1];
//             if(sum == target){
//                 res[0] = mid + 1;
//                 res[1] = mid + 1 + 1;
//                 return res;
//             } else if(sum < target){
//                 l = mid + 1;
//             } else {
//                 r = mid - 1;
//             }

