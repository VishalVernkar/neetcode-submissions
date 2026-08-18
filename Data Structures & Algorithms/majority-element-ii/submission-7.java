class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        if(n == 1) return Arrays.asList(nums[0]);
        int count1 = 0;
        int num1 = nums[0];
        int count2 = 0;
        int num2 = nums[1];

        for(int num : nums){
            if(num == num1){
                count1++;
            } else if(num == num2){
                count2++;
            } else if(count1 == 0){
                num1 = num;
                count1++;
            } else if(count2 == 0){
                num2 = num;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = count2 = 0;
        for(int num : nums){
            if(num == num1) count1++;
            else if(num == num2) count2++;
        }     

        List<Integer> list = new ArrayList<>();
        if(count1 > nums.length/3) list.add(num1);
        if(count2 > nums.length/3) list.add(num2);

        return list;
    }
}

// 12:49

// Boyer - Moore algorithm
// two candidates with > n/3 votes - using 2 pass
// 
// 