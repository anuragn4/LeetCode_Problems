// Problem Statement
// https://leetcode.com/problems/average-of-levels-in-binary-tree/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<Double> result = new ArrayList<Double>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            int count = queue.size();
            double sum = 0.0;
            for(int i=0; i<count; i++){
                TreeNode node = queue.poll();
                sum = sum + node.val;
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
            }
            result.add(sum/count);
        }   
        return result;
    }
}
