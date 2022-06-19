class Solution {
    ArrayList<Integer> x;
    void fun(int k, int i){
        if(x.size()==1) return;
        i = (i+k-1)%x.size();
        x.remove(i);
        fun(k,i);
    }
    public int findTheWinner(int n, int k) {
        x = new ArrayList();
        for(int i=0; i<n; i++){
            x.add(i+1);
        }
        fun(k,0);
        return x.get(0);
    }
}