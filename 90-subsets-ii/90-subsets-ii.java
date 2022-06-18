class Solution {
    List<List<Integer>> ans;
    HashMap<List<Integer>, Integer> map;
    void sub(List<Integer> op, List<Integer> ip){
        if(ip.size()==0) {
            if(map.get(op)==null) {
                ans.add(op); 
                map.put(op,1);
            } 
            return;
        }
        List<Integer> op1 = new ArrayList(op);
        List<Integer> op2 = new ArrayList(op);
        List<Integer> ip1 = new ArrayList(ip);
        op2.add(ip1.get(0));
        ip1.remove(0);
        sub(op1,ip1);
        sub(op2,ip1);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        ans = new ArrayList();
        map = new HashMap();
        List<Integer> arr = new ArrayList();
        for(int x:nums) arr.add(x);
        List<Integer> op = new ArrayList();
        sub(op,arr);
        return ans;
    }
}