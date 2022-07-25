class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap();
        for(int i=0;i<nums.length; i++) {
            if(map.containsKey(nums[i])) map.get(nums[i]).add(i);
            else{
                ArrayList<Integer> x = new ArrayList();
                x.add(i);
                map.put(nums[i],x);
            }
        }
        for(int i=0; i<nums.length; i++) {
            ArrayList<Integer> t = map.get(nums[i]);
            if(t.size()>1) {
                for(int z=0; z<t.size()-1; z++) {
                    for(int j=z+1; j<t.size(); j++){
                        if(Math.abs(t.get(z)-t.get(j))<=k) return true;
                    }
                }
            }
        }
        return false;
    }
}