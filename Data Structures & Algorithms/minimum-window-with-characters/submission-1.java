class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();

        if(m>n)
            return "";

        int[] freq1 = new int[128];
        int[] freq2 = new int[128];

        for(int i=0; i<m; i++){
            freq1[t.charAt(i)]++;
        }

        int count = 0;
        int have = 0;
        for(int i=0; i<128; i++){
            if(freq1[i] > 0) count++;
        }   

        String ans = "";
        int minLength = Integer.MAX_VALUE;

        int l = 0;
        for(int r=0; r<n; r++){
            freq2[s.charAt(r)]++;

            if(freq1[s.charAt(r)] != 0 && freq1[s.charAt(r)] == freq2[s.charAt(r)]) 
                have++;
            
            while(have == count){
                if((r-l+1) < minLength){
                    ans = s.substring(l, r+1);
                    minLength = ans.length();
                }

                freq2[s.charAt(l)]--;
                if(freq2[s.charAt(l)] < freq1[s.charAt(l)])
                    have--;
                l++;
            }
        }

        return ans;
    }
}
