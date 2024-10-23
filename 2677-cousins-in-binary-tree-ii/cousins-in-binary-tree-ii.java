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
    public TreeNode replaceValueInTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        root.val = 0;
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int levelSum = 0;
            List<TreeNode> currentLevel = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                currentLevel.add(node);
                if (node.left != null) levelSum += node.left.val;
                if (node.right != null) levelSum += node.right.val;
            }
            for (TreeNode node : currentLevel) {
                int siblingSum = 0;
                if (node.left != null) siblingSum += node.left.val;
                if (node.right != null) siblingSum += node.right.val;

                if (node.left != null) {
                    node.left.val = levelSum - siblingSum;
                    queue.add(node.left);
                }
                if (node.right != null) {
                    node.right.val = levelSum - siblingSum;
                    queue.add(node.right);
                }
            }
        }
        
        return root;
    }
}