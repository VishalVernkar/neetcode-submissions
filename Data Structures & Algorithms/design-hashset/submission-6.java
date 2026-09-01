class MyHashSet {
    private class ListNode{
        int val;
        ListNode next;

        private ListNode(int val){
            this.val = val;
        }
    }

    int size;
    ListNode[] set;
    public MyHashSet() {
        size = 1000;
        set = new ListNode[size];
        for(int i = 0; i < size; i++){
            set[i] = new ListNode(-1);
        }
    }
    
    public void add(int key) {
        ListNode cur = set[key%size];
        while(cur.next != null){
            if(cur.next.val == key){
                return;
            }
            cur = cur.next;
        }
        cur.next = new ListNode(key);
    }
    
    public void remove(int key) {
        ListNode cur = set[key%size];
        while(cur.next != null){
            if(cur.next.val == key){
                cur.next = cur.next.next;
                return;
            }
            cur = cur.next;
        }
    }
    
    public boolean contains(int key) {
        ListNode cur = set[key%size];
        while(cur.next != null){
            if(cur.next.val == key){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

 // using bucket to listNode 