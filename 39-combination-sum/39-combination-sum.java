class Solution {
    List<List<Integer>> ans; 
    int target;
    int[] candidates;
    void fun(int n,int sum, List<Integer> arr) {
        if(n>=candidates.length || sum>target) return;
        if(sum==target) {
            ans.add(arr);
            return;
        }
          ArrayList<Integer> x= new ArrayList(arr);
          x.add(candidates[n]);
          fun(n,sum+candidates[n],x);
        fun(n+1,sum, arr);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList();
        this.target = target;
        this.candidates=candidates;
        ArrayList<Integer> arr = new ArrayList();
        fun(0,0,arr);
        return ans;
    }
}