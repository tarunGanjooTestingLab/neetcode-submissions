class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length(); // we need to maintain a window of this size
        int m = s2.length();

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        for(int i=0; i<n; i++){
            freq1[s1.charAt(i)-'a']++;
        }
        
        int l=0;
        for(int r=0; r<m; r++){
            freq2[s2.charAt(r)-'a']++;

            if((r-l+1) == n){
                if(Arrays.equals(freq1, freq2))
                    return true;
                freq2[s2.charAt(l)-'a']--;
                l++;
            }
        }

        return false;
    }
}
