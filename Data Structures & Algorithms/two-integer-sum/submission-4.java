class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        HashMap<Integer, Integer> mp = new HashMap<>();

        for(int i=0; i<n; i++){
            int requiredValue = target - nums[i];
            Integer containsIndex = mp.get(requiredValue);

            if(containsIndex != null){
                return new int[]{containsIndex, i};
            }
            mp.put(nums[i], i);
        }

        return new int[]{-1, -1};
    }
}
