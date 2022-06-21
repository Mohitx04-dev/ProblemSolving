class Solution {
    List<List<Integer>> ans;
    ArrayList<Integer> swap(int i, int j, ArrayList<Integer> x){
        if(i>=x.size() || j>=x.size()) {
            i = i%x.size();
            j = j%x.size();
        }
        ArrayList<Integer> temp = new ArrayList(x);
        int t = x.get(i);
        temp.set(i,x.get(j));
        temp.set(j,t);
        return temp;
    }
    void fun(int index, ArrayList<Integer> x){
        if(index>=x.size()){
            ans.add(x);
            return;
        }
         for (int i = index; i < x.size(); i++) {
             fun(index + 1, swap(index,i, x) );
           }

    }
    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList();
        ArrayList<Integer> x = new ArrayList();
        for(int i : nums) x.add(i);
        fun(0,x);
        return ans;
    }
}