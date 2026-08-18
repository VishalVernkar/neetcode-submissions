class MyHashSet {

    private static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val){
            this.val = val;
        }
    }
    
    private final ListNode[] set;

    public MyHashSet() {
       this.set = new ListNode[10001];
       for(int i=0;i<10001;i++){
            set[i] = new ListNode(0);
       }
    }
    
    public void add(int key) {
        ListNode cur = set[key%10000];
        while(cur.next != null){
            if(cur.next.val == key) return;
            cur = cur.next;
        }
        cur.next = new ListNode(key);
    }
    
    public void remove(int key) {
        ListNode cur = set[key%10000];
        while(cur.next != null){
            if(cur.next.val == key) {
                cur.next = cur.next.next;
                return;
            }
            cur = cur.next;
        }
        
    }
    
    public boolean contains(int key) {
        ListNode cur = set[key%10000];
        while(cur.next != null){
            if(cur.next.val == key) return true;
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