class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length-1);
        return nums;
    }

    private static void mergeSort(int[] nums, int left, int right){
        if(left >= right) return;

        int mid = left + ((right - left) / 2 );
        mergeSort(nums, left, mid);
        mergeSort(nums, mid+1, right);

        merge(nums, left, mid, right);
    }

    private static void merge(int[] nums, int left, int mid, int right){
        List<Integer> res = new ArrayList<>();
        int i = left;
        int j = mid + 1;
        
        while(i <= mid && j <= right){
            if(nums[i] < nums[j]){
                res.add(nums[i]);
                i++;
            }else{
                res.add(nums[j]);
                j++;
            }
        }

        while(i<=mid){
            res.add(nums[i]);
            i++; 
        }

        while(j<=right){
            res.add(nums[j]);
            j++; 
        }
        
        int a=0;
        for(int k = left; k<=right;k++){
            nums[k] = res.get(a++);
        }
    }
}