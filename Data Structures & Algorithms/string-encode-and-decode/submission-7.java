class Solution {

    public String encode(List<String> strs) {

        StringBuilder result = new StringBuilder();

        for(String str: strs){
            result.append(str.length());
            result.append("#");
            result.append(str);
        }

        return result.toString();
    }   

    public List<String> decode(String str) {

        List<String> result = new ArrayList<>();
        int i = 0;
        int n = str.length();

        while(i<n){

            int j = i;
            while(str.charAt(j) != '#'){j++;}
            int len = Integer.parseInt(str.substring(i, j));

            String word = str.substring(j+1, len+j+1);
            result.add(word);

            i = len+j+1;
        }
        
        return result;
    }
}
