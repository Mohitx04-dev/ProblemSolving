/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    static List<List<Integer>> ans;
    void fun(List<Integer> arr, TreeNode root, int targetSum) {
        if(root==null) {
            return;
        }
        arr.add(root.val);
        if(targetSum==root.val && root.right==null && root.left==null) {
                ans.add(new ArrayList<>(arr));     
            }
        else{
            fun(arr,root.right, targetSum-root.val);
            fun(arr,root.left,targetSum-root.val);
        }
        arr.remove(arr.size()-1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ans = new ArrayList();
        if(root==null) return ans;
        fun(new ArrayList<Integer>(), root,targetSum);
        return ans;
    }
}