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
            
            String temp = "";
            for(int i=0; i<data.size(); i++){
                Data current = data.get(i);
                if(current.time <= timestamp){
                    temp = current.value;
                    if(current.time == timestamp)
                        return current.value;
                }
            }
            return temp;
        }
        return "";
    }
}