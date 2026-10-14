class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (p1, p2) -> Integer.compare(p1[1], p2[1])
        );
        
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i=0; i<n; i++){
            mp.put(nums[i], mp.getOrDefault(nums[i], 0)+1);
        }

        for(Map.Entry<Integer, Integer> entry: mp.entrySet()){            
            pq.add(new int[]{entry.getKey(), entry.getValue()});

            if(pq.size() > k)
                pq.poll();
        }

        int[] result = new int[k];
        while(k != 0){
            int[] val = pq.poll();
            result[k-1] = val[0];
            k--;
        }

        return result;
    }
}

// take a bucket of 10^4 size 
// iterate nums and increase the frequency of elements in the bucket 
// I need top k frequencies 
// maybe i can take a priority queue in which top element will be having max
// freq and it will be a pair