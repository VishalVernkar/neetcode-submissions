class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        if(n == 1) return List.of(nums[0]);
        int num1 = nums[0];
        int num2 = nums[1];
        int count1 = 0, count2 = 0;
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

        List<Integer> res = new ArrayList<>();
        if(count1 > n/3) res.add(num1);
        if(count2 > n/3) res.add(num2);
        return res;
    }
}