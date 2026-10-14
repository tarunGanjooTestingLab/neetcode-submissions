class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        int n = nums.length;
        int[] ans = new int[k];

        for(int i=0; i<n; i++){
            mp.put(nums[i], mp.getOrDefault(nums[i], 0)+1);
        }

        List<Integer>[] bucket = new List[n+1];

        for(int key : mp.keySet()){
            int val = mp.get(key);
            
            if(bucket[val] == null){
                bucket[val] = new ArrayList<>();
            }

            bucket[val].add(key);
        }

        int ind = 0;
        for(int i=n; i>=0; i--){
            if(bucket[i] != null){
                for(int j: bucket[i]){
                    ans[ind++] = j;

                    if(ind == k) return ans;
                }
            }
        }

        return ans;
    }
}
