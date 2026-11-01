class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length(); // we need to maintain a window of this size
        int m = s2.length();

        if(n > m)
            return false;

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        for(int i=0; i<n; i++){
            freq1[s1.charAt(i)-'a']++;
            freq2[s2.charAt(i)-'a']++;
        }

        int matches = 0;
        for(int i=0; i<26; i++){
            if(freq1[i] == freq2[i]) matches++;
        }
        
        int l=0;
        for(int r=n; r<m; r++){
            if(matches == 26)
                return true;

            int indexR = s2.charAt(r)-'a';
            freq2[indexR]++;
        
            if(freq2[indexR] == freq1[indexR]) matches++;
            else if(freq2[indexR] == (freq1[indexR] + 1)) matches--;

            int indexL = s2.charAt(l)-'a';
            freq2[indexL]--;
        
            if(freq2[indexL] == freq1[indexL]) matches++;
            else if(freq2[indexL] == (freq1[indexL] - 1)) matches--;

            l++;
        }

        return matches == 26;
    }
}
