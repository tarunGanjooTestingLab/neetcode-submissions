class Solution {
    public int longestConsecutive(int[] nums) {

        int n = nums.length;
        if(n == 0)
            return 0;
        
        HashSet<Integer> st = new HashSet<>();
        int maxLen = 1;

        for(int i=0; i<n; i++){
            st.add(nums[i]);
        }

        for(int num: st){
            int ele = num;
            int len = 0;

            // can start of the sequence 
            if(!st.contains(ele-1)){
                while(st.contains(ele++))
                    len++;
            }

            maxLen = Math.max(maxLen, len);
        }
        
        return maxLen;
    }
}
