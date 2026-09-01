class MyHashMap {
    private class ListNode{
        ListNode next;
        int key;
        int val;

        private ListNode(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    int size;
    ListNode[] map;
    public MyHashMap() {
        size = 1001;
        map = new ListNode[size];
        for(int i = 0; i < size; i++){
            map[i] = new ListNode(-1, -1);
        }
    }
    
    public void put(int key, int value) {
       ListNode cur = map[key%size];
       while(cur.next != null){
            if(cur.next.key == key){
                cur.next.val = value;
                return;
            }
            cur = cur.next;
       } 
       cur.next = new ListNode(key, value);
    }
    
    public int get(int key) {
       ListNode cur = map[key%size];
       while(cur.next != null){
            if(cur.next.key == key){
                return cur.next.val;
            }
            cur = cur.next;
       } 
       return -1;
    }
    
    public void remove(int key) {
       ListNode cur = map[key%size];
       while(cur.next != null){
            if(cur.next.key == key){
                cur.next = cur.next.next;
                return;
            }
            cur = cur.next;
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