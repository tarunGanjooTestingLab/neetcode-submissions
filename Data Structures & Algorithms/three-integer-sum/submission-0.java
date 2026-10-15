class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for(int i=0; i<n-2; i++){
            // capturing first element
            int num1 = nums[i];
            if(i > 0 && num1 == nums[i-1])
                continue;

            int l = i+1;
            int r = n-1;

            while(l < r){
                int sum = num1 + nums[l] + nums[r];

                // capture the sum and make sure no duplicates are present
                if(sum == 0){
                    result.add(List.of(num1, nums[l], nums[r]));
                    l++;
                    r--;
                    
                    while(l<r && nums[l] == nums[l-1]) l++;
                    while(l<r && nums[r] == nums[r+1]) r--;
                }
                else if(sum > 0)
                    r--;
                else l++;
            }
        }

        return result;
    }
}
