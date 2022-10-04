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
    static boolean ans;
    void function(TreeNode root, int target) {
        if(root==null) return;
        if((target-root.val==0) && root.right==null && root.left==null){
            ans=true;
            return;
        }
        function(root.left, target-root.val);
        function(root.right,target-root.val);
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        ans=false;
        function(root,targetSum);
        return ans;
    }
}