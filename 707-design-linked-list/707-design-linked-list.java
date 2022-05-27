class Node { 
    public int val;
    public Node next;
    Node() {
        val = 0;
        next = null;
    }
    Node(int val) {
        this.val = val;
        this.next = null;
    }
    Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
}
class MyLinkedList {
    Node head;
    public MyLinkedList() {
        head = null;   
    }
    
    public int get(int index) {
        Node temp = head;
        if(index==0){
            if(head!=null) return head.val;
            else return -1;
        }
        else{
        while(index>0) {
            if(temp.next==null){
                return -1;
            }
            temp = temp.next;
            index--;
        }
        if(temp!=null) return temp.val;
        else return -1;
        }
    }
    
    public void addAtHead(int val) {
        Node x = new Node(val,head);
        head = x;
    }
    
    public void addAtTail(int val) {
        if(head==null){
            head = new Node(val);
        }
        else{
        Node temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        Node x = new Node(val);
        temp.next = x;
        }
    }
    
    public void addAtIndex(int index, int val) {
        Node temp = head;
        if(index==0) {
            addAtHead(val);
        }
        else{
        while(index>1) {
            System.out.println(temp.val + " " + index);
            if(temp.next==null){
                break;
            }
            temp = temp.next;
            index--;
        }        
        if(temp==null){
        Node x = new Node(val);
        temp = x;
        }
            else{
        Node x = new Node(val,temp.next);
        temp.next = x;
            }
        }
    }
    
    public void deleteAtIndex(int index) {
        Node temp = head;
        if(index==0) {
            head = head.next;
            
        }
        else{
        while(index>1 && temp.next!=null) {
            temp = temp.next;
            index--;
        }
            if(temp.next!=null){
             temp.next = temp.next.next;
            }
            else{
                temp.next = null;
            }
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */