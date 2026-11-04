class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length; 
        int j = 0;
        Deque<Integer> dq = new ArrayDeque<>();
        List<Integer> lst = new ArrayList<>();

        for(int i=0; i<n; i++){

            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]){
                dq.pollLast();
            }

            dq.addLast(i);
            
            if((i-j+1)==k){
                lst.add(nums[dq.peekFirst()]);
                j++;
                if(dq.peekFirst() < j)
                    dq.pollFirst();
            }
        }

        int[] ans = new int[lst.size()];
        for(int i=0; i<lst.size(); i++){
            ans[i] = lst.get(i);
        }

        return ans;
    }
}
