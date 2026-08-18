class MyHashMap {
    private static class ListNode{
        int key;
        int val;
        ListNode next;

        ListNode(int key, int val){
            this.key = key;
            this.val = val;
        }

        ListNode(){

        }

    }

    ListNode[] map;
    int bucketSize = 1000;

    public MyHashMap() {
        map = new ListNode[bucketSize+1];
        int n = bucketSize+1;
        for(int i=0;i<n;i++){
            map[i] = new ListNode();
        }
    }
    
    public void put(int key, int value) {
        ListNode curr = map[key % bucketSize];
        while(curr.next != null){
            if(curr.next.key == key){
                curr.next.val = value;
                return;
            }
            curr = curr.next;
        }
        curr.next = new ListNode(key, value);
    }
    
    public int get(int key) {
        ListNode curr = map[key % bucketSize];
        while(curr.next != null){
            if(curr.next.key == key){
                return curr.next.val;
            }
            curr = curr.next;
        }
        return -1;
    }
    
    public void remove(int key) {
        ListNode curr = map[key % bucketSize];
        while(curr.next != null){
            if(curr.next.key == key){
                curr.next = curr.next.next;
                return;
            }
            curr = curr.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */