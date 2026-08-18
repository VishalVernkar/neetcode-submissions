class Solution {
    public List<Integer> majorityElement(int[] nums) {
        if(nums.length == 1) return List.of(nums[0]);
        int count1 = 0;
        int count2 = 0;
        int num1 = nums[0];
        int num2 = nums[1];

        for(int num:nums){
            if(num1 == num){
                count1++;
            } else if(num2 == num){
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


        count1 = 0;
        count2 = 0;
        for(int num:nums){
            if(num1 == num) count1++;
            else if(num2 == num) count2++; 
        }

        List<Integer> res = new ArrayList<>();
        if(count1 > nums.length/3) res.add(num1);
        if(count2 > nums.length/3) res.add(num2);

        return res;
    }
}