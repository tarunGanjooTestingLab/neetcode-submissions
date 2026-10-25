class Solution {

    private long maximumHours(int[] piles, int k, int n){
        long hours = 0;
        for(int i=0; i<n; i++){
            hours += ((piles[i] + k - 1)/k);
        }
        return hours;
    }

    private int maximumElement(int[] piles, int n){
        int maxi = 0;
        for(int i=0; i<n; i++){
            maxi = Math.max(maxi, piles[i]);
        }
        return maxi;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        if(n == 0)
            return h;

        int l = 1;
        int r = maximumElement(piles, n);
        int rate = r;
        
        while(l<=r){
            int mid = l + (r-l)/2;

            long maxH = maximumHours(piles, mid, n);

            if(maxH <= h){
                rate = Math.min(rate, mid);
                r = mid - 1;
            }
            else l = mid + 1;
        }

        return rate;
    }
}
