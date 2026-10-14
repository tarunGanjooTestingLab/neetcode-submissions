class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> st = new HashSet<>();
        int n = nums.length;

        for(int i=0; i<n; i++){
            if(st.contains(nums[i])) return true;
            st.add(nums[i]);
        }

        return false;
    }
}