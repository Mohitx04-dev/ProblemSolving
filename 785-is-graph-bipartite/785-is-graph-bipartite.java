class Solution {
    boolean bfs(int[][] graph, int[] color, int node) {
        Queue<Integer> q = new LinkedList();
        q.add(node);
        color[node]=1;
        while(!q.isEmpty()) {
            int val = q.peek();
            q.remove();
            for(int x : graph[val]) {
                if(color[x]==-1) {
                    color[x] = (color[val]+1)%2;
                    q.add(x);
                }
                else if(color[x] == color[val]) return false;
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        Arrays.fill(color, -1);
        for(int i=0; i<graph.length; i++) {
            if(color[i]==-1) {
                if(!bfs(graph, color, i)) return false;
            }
        }
        return true;
    }
}