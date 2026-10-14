class Solution {
    public boolean isAnagram(String s, String t) {
        int n = s.length();
        int m = t.length();

        if(n != m)
            return false;

        HashMap<Character, Integer> mp = new HashMap<>();
        
        // adding the frequency of s
        for(Character ch : s.toCharArray()){
            mp.put(ch, mp.getOrDefault(ch, 0)+1);
        }

        // removing the frequency of t
        for(Character ch : t.toCharArray()){
            mp.put(ch, mp.getOrDefault(ch, 0)-1);
        }

        // traversing over the map to check if the frequency is 0 or not
        for(Integer i: mp.values()){
            if(i != 0)
                return false;
        }

        return true;
    }
}
