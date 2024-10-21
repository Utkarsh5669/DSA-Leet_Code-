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
    public int maxDepth(TreeNode root) {
        //base condition return 0 is null
        if(root==null){
            return 0;
        }
        //else return the 1+max(left, right)
        //recursion function
        //return 1+ Math.max(maxDepth(root.left),maxDepth(root.right));

        //more optimized
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return 1+Math.max(leftDepth,rightDepth);
    }
}