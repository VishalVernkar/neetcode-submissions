class MyHashSet {

    private static class ListNode{
        int val;
        ListNode next;

        ListNode(int val){
            this.val = val;
        }
    }

    ListNode[] set;
    int buketSize = 10000;

    public MyHashSet() {
        set = new ListNode[buketSize + 1];
        for(int i=0;i<10001;i++){
            set[i] = new ListNode(0);
        }
    }
    
    public void add(int key) {
        ListNode curr = set[key % buketSize];
        System.out.println(curr.val);
        while(curr.next !=null){
            if(curr.next.val == key){
                return;
            }
            curr = curr.next;
        }
        curr.next = new ListNode(key);
    }
    
    public void remove(int key) {
        ListNode curr = set[key % buketSize];
        while(curr.next !=null){
            if(curr.next.val == key){
                curr.next = curr.next.next;
                return;
            }
            curr = curr.next;
        }
    }
    
    public boolean contains(int key) {
        ListNode curr = set[key % buketSize];
        while(curr.next !=null){
            if(curr.next.val == key){
                return true;
            }
            curr = curr.next;
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