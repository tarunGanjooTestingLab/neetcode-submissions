class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i=0; i<n; i++){
            mp.put(nums[i], mp.getOrDefault(nums[i], 0)+1);
        }

        List<Integer>[] bucket = new List[n+1];

        for(Map.Entry<Integer, Integer> entry : mp.entrySet()){
            int key = entry.getKey();
            int val = entry.getValue();

            if(bucket[val] == null){
                bucket[val] = new ArrayList<>();
            }

            bucket[val].add(key);
        }

        int[] result = new int[k];
        int idx = 0;

        for(int i=n; i>=0; i--){
            if(bucket[i] != null){
                List<Integer> values = bucket[i];

                for(Integer j: values)
                    result[idx++] = j;

                    if(idx == k)
                        return result;
            }
        }

        return result;
    }
}