//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;

  public class LRUDesign {

    public static void main(String[] args) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {

            int capacity = Integer.parseInt(read.readLine());
            int queries = Integer.parseInt(read.readLine());
            LRUCache cache = new LRUCache(capacity);
            String str[] = read.readLine().trim().split(" ");
            int len = str.length;
            int itr = 0;

            for (int i = 0; (i < queries) && (itr < len); i++) {
                String queryType = str[itr++];
                if (queryType.equals("SET")) {
                    int key = Integer.parseInt(str[itr++]);
                    int value = Integer.parseInt(str[itr++]);
                    cache.set(key, value);
                }
                if (queryType.equals("GET")) {
                    int key = Integer.parseInt(str[itr++]);
                    System.out.print(cache.get(key) + " ");
                }
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// design the class in the most optimal way
class Node {
    Node prev;
    Node next;
    int d;
    int k;
     Node() {
        this.d = 0;
        prev = null;
        next = null;
    }
     Node(int d, int k) {
        this.d = d;
        this.k = k;
        this.prev = null;
        this.next = null;
    }
}
class LRUCache
{
    HashMap<Integer,Node> hm;
    Node head;
    Node tail;
    int cap;
    //Constructor for initializing the cache capacity with the given value.
    void insertFirst(int v, int k) {
        Node node = new Node(v,k);
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        hm.put(k,node);
    }
    LRUCache(int cap)
    {
        hm = new HashMap<Integer,Node>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        this.cap = cap;
        //code here
    }

    //Function to return value corresponding to the key.
    public  int get(int key)
    {
        if(hm.containsKey(key)) {
            Node idx = hm.get(key);
            idx.prev.next = idx.next;
            idx.next.prev = idx.prev;
            hm.remove(key);
            insertFirst(idx.d,key);
            return idx.d;
        }
        else return -1;
        // your code here
    }

    //Function for storing key-value pair.
    public  void set(int key, int value)
    {
        // your code here
        if(hm.containsKey(key)) {
            Node idx = hm.get(key);
            idx.prev.next = idx.next;
            idx.next.prev = idx.prev;
            hm.remove(key);
            insertFirst(value,key);
        }
        else {
            if(hm.size()==cap) {
                Node p = tail.prev;
                tail.prev = p.prev;
                p.prev.next = tail;
                hm.remove(p.k);
            }
            insertFirst(value,key);
        }
    }
}
