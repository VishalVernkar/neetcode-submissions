class MyHashMap {
    private class ListNode{
        ListNode next;
        int key, val;
        private ListNode(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    ListNode[] map;
    int size;
    public MyHashMap() {
        size = 1000;
        map = new ListNode[size];
        for(int i = 0; i < size; i++){
            map[i] = new ListNode(-1, -1);
        }
    }
    
    public void put(int key, int value) {
        // put
        // get the bucket
        ListNode cur = map[key%size];
        // linear search the existing node
        while(cur.next != null){
            if(cur.next.key == key){
                cur.next.val = value;
                return;
            }
            cur = cur.next;
        }
        cur.next = new ListNode(key, value);
        // place it if found 
        // or place it at the end
    }
    
    public int get(int key) {
        // get
        ListNode cur = map[key%size];
        // get the bucket
        // linear search the existing node
        while(cur.next != null){
            if(cur.next.key == key){
                return cur.next.val;
            }
            cur = cur.next;
        }
        return -1;
        // return it if found 
        // or return -1 at the end
    }
    
    public void remove(int key) {
        // get
        // get the bucket
        ListNode cur = map[key%size];
        while(cur.next != null){
            if(cur.next.key == key){
                cur.next = cur.next.next;
                return;
            }
            cur = cur.next;
        }
        // linear search the existing node
        // remove it if found - by referncing next node
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */

 // DS: linked list
 // put