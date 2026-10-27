class TimeMap {

    class Data{
        int time;
        String value;

        public Data(int time, String value){
            this.time = time;
            this.value = value;
        }
    }

    HashMap<String, List<Data>> mp;

    public TimeMap() {
        mp = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        mp.computeIfAbsent(key, k -> new ArrayList<>()).add(new Data(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if(mp.containsKey(key)){
            List<Data> data = mp.get(key);

            if(data == null)
                return "";
            
            int l=0;
            int r=data.size()-1;
            String ans = "";

            while(l<=r){
                int mid = l + (r-l)/2;
                if(data.get(mid).time == timestamp)
                    return data.get(mid).value;
                else if(data.get(mid).time < timestamp){
                    ans = data.get(mid).value;
                    l = mid+1;
                }
                else r = mid-1;
            }
            
            return ans;
        }
        return "";
    }
}