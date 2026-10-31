class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        if(n == 0)
            return 0;

        int[] freq = new int[26];
        int maxFreq = 0;
        int maxLength = 1;
        int l=0;

        for(int r=0; r<n; r++){
            char ch = s.charAt(r);

            freq[ch-'A']++;
            maxFreq = Math.max(maxFreq, freq[ch-'A']);
        
            if ((r - l + 1 - maxFreq) > k){
                freq[s.charAt(l)-'A']--;
                l++;
            }

            maxLength = Math.max(maxLength, r-l+1);
        }

        return maxLength;
    }
}
