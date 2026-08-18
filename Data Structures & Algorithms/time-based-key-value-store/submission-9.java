class TimeMap {

    class TimeStamp{
        String val;
        int time;

        TimeStamp(String val, int time){
            this.val = val;
            this.time = time;
        }
    }

    Map<String, List<TimeStamp>> timeMap;

    public TimeMap() {
        timeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        TimeStamp ts = new TimeStamp(value, timestamp);
        List<TimeStamp> list = timeMap.getOrDefault(key, new ArrayList<>());
        list.add(ts);
        timeMap.putIfAbsent(key, list);
    }
    
    public String get(String key, int timestamp) {
        String res = "";
        if(!timeMap.containsKey(key)) return res;
        List<TimeStamp> list = timeMap.get(key);
        if(list.get(list.size() - 1).time <= timestamp){
            return list.get(list.size() - 1).val;
        }

        int l = 0;
        int r = list.size() - 1;

        while(l <= r){
            int m = l + (r - l) / 2;
            if(list.get(m).time <= timestamp){
                res = list.get(m).val;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return res;
    }
}
