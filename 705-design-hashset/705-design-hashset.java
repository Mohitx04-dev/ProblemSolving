class MyHashSet {
    LinkedList ll;
    public MyHashSet() {
        ll  = new LinkedList();
    }
    public void add(int key) {
        if(ll.contains(Integer.toString(key))==false) {
            ll.addLast(Integer.toString(key));
        }
    }
    public void remove(int key) {
        if(ll.contains(Integer.toString(key))) ll.remove(Integer.toString(key));
    }
    
    public boolean contains(int key) {
        return ll.contains(Integer.toString(key));
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */