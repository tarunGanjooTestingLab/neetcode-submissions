class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        char[] charFrequency = new char[26];
        HashMap<String, List<String>> mp = new HashMap<>();

        for(String str: strs){
            
            for(int i=0; i<str.length(); i++){
                charFrequency[str.charAt(i)-'a']++;
            }

            String key = new String(charFrequency);
            mp.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
            Arrays.fill(charFrequency, (char)0);
        }

        return new ArrayList<>(mp.values());
    }
}
