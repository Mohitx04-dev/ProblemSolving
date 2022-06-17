class Solution {
    List<List<Integer>> ans;
    void subs(ArrayList<Integer> arr, ArrayList<Integer> output) {
        if(arr.size()==0) {
            ans.add(output);
            return;
        }
        int x = arr.get(0);
        ArrayList<Integer> arr1 = new ArrayList();
        for(int z : arr) {
            arr1.add(z);
        }
        arr1.remove(0);
        ArrayList<Integer> op2 = new ArrayList();
        ArrayList<Integer> op1 = new ArrayList();
        for(int m : output){
            op2.add(m);
            op1.add(m);
        }
        op2.add(x);
        subs(arr1,op1);
        subs(arr1,op2);
    }
    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList();
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(int x : nums) {
            arr.add(x);
        }
        ArrayList<Integer> temp = new ArrayList();
        subs(arr,temp);
        return ans;
    }
}