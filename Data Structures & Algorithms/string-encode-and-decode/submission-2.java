class Solution {

    public String encode(List<String> strs) {
        int len = strs.size();
        StringBuilder str = new StringBuilder();

        for(String s : strs){
            str.append(s.length());
            str.append("#");
            str.append(s);
        }

        return str.toString();
    }

    public List<String> decode(String str) {

        List<String> ans = new ArrayList<>();
        
        int i = 0;
        int n = str.length();

        while(i<n){

            int j = i;

            while(str.charAt(j) != '#')
                j++;

            int len = Integer.parseInt(str.substring(i, j));

            String word = str.substring(j+1, j+1+len);
            ans.add(word);

            i = j+1+len;
        }

        return ans;
    }
}
