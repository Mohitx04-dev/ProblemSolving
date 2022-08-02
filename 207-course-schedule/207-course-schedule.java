class Solution {
    boolean checkforCycle(HashMap<Integer,ArrayList<Integer>> map, boolean[] vis,boolean[] dfsvis , int node) {
        vis[node]=true;
        dfsvis[node]=true;
        System.out.println(node);
        for(int x : map.get(node)) {
            if(!vis[x]) {
                if(checkforCycle(map,vis,dfsvis,x)) return true;
            }
            else if(dfsvis[x]) return true;
        }
        dfsvis[node]=false;
        return false;
    }
    public boolean canFinish(int numCourses, int[][] arr) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap();
        for(int i=0; i<numCourses; i++) {
            map.put(i,new ArrayList<Integer>());
        }
        for(int i=0; i<arr.length; i++) {
                map.get(arr[i][0]).add(arr[i][1]);
        }
        boolean[] vis = new boolean[numCourses];
        boolean[] dfsvis = new boolean[numCourses];
        for(int i=0; i<numCourses; i++) {
            if(!vis[i]) {
                if(checkforCycle(map,vis,dfsvis,i)) return false;
            }
        }
        return true;
    }
}