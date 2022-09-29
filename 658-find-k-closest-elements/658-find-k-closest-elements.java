class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            if(Math.abs(o2-x)==Math.abs(o1-x)) {
               return o1-o2;
            }
            else return Math.abs(o1-x) - Math.abs(o2-x);
        });
        List<Integer> st = new ArrayList();
        for(int t : arr) {
            pq.add(t);
        }
        while(!pq.isEmpty()){
            if(st.size()==k) break;
            st.add(pq.poll());
        }
        Collections.sort(st);
        return st;
    }
}