class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        int[] charFrequency = new int[26];
        HashMap<String, List<String>> mp = new HashMap<>();

        for(String str: strs){
            
            for(int i=0; i<str.length(); i++){
                charFrequency[str.charAt(i)-'a']++;
            }

            String key = Arrays.toString(charFrequency);
            mp.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
            Arrays.fill(charFrequency, 0);
        }

        List<List<String>> result = new ArrayList<>();
        for(List<String> lst: mp.values()){
            result.add(lst);
        }

        return result;
    }
}
