class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> st = new HashSet<>();

        for(int i=0; i<nums.length; i++){
            if(!st.add(nums[i]))
                return true;
        }

        return false;
    }
}