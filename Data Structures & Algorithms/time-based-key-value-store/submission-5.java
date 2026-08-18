class TimeMap {

    class TimeValue {
        int timeStamp;
        String value;

        private TimeValue(int timeStamp,  String value){
            this.timeStamp = timeStamp;
            this.value = value;
        }
    }

    Map<String, List<TimeValue>> timeMap; 

    public TimeMap() {
        timeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
       List<TimeValue> list = timeMap.get(key);
       if(list == null){
            list =  new ArrayList<>();
            timeMap.put(key, list);
       }
       list.add(new TimeValue(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        List<TimeValue> list = timeMap.get(key);
        if(list == null) return "";
        int r = list.size() - 1;
        if(timestamp >= list.get(r).timeStamp){
            return list.get(r).value;
        }



        int l = 0;
        while(l<=r){
            int mid = l + (r - l)/2;
            int tS = list.get(mid).timeStamp;
            if(tS == timestamp){
               return list.get(mid).value;
            } else if(tS < timestamp){
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        System.out.println(l + " " + r);

        return (r > -1 )? list.get(r).value : "";
    }
}
// I'm stressed, I have slight headache
// I tried random approach, directly coding -> hoping it is going to work -> this took time
// I didn't understand question clearly
// I made up a perception about these question in my mind -> I dont like it, I'm lazy to put effort to understand it



// Rule: Must understand question in 5 mins 
// if it is hard to follow up - I should write to understand question - break it into simple steps

// Rule: I should write my approach before trying





