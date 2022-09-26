class Solution {
    static int[] parent;
    static int[] rank;
    void MakeSet(int n) {
        for(int i=0; i<n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }
    int findParent(int node) {
        if(node==parent[node]) return node;
        return parent[node] = findParent(parent[node]);
    }
    void union(int i, int j) {
        int u = findParent(i);
        int v = findParent(j);
        if(rank[u]>rank[v]) parent[v] = u;
        else if(rank[v]>rank[u]) parent[u] = v;
        else {
            parent[v] = u;
            rank[u]++;
        }
    }
    public boolean equationsPossible(String[] equations) {
       int n = 26;
       parent = new int[n];
       rank = new int[n];
       MakeSet(n);
       for(String x : equations) {
           int el1 = (int) x.charAt(0) - 97;
           int el2 = (int) x.charAt(3) - 97;
           char opr = x.charAt(1);
           if(opr=='=') {
               union(el1,el2);
           }
         }  
        for(String x : equations) {
           int el1 = (int) x.charAt(0) - 97;
           int el2 = (int) x.charAt(3) - 97;
           char opr = x.charAt(1);
              if(opr=='!') {
               if(findParent(el1)==findParent(el2)) return false;
           }
         }
        return true;
    }
}