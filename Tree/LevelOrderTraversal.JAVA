// Problem Statement
// https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root==null) return result;
        helper(root,1,result);
        return result;
    }
    
    public void helper(TreeNode root, int level, List<List<Integer>> result){
        if(root==null) return;
        if(result.size()<level){
            List<Integer> temp = new ArrayList();
            temp.add(new Integer(root.val));
            result.add(0,temp);
        } 
        else{
            result.get(result.size()-level).add(new Integer(root.val));
        } 
        helper(root.left, level+1,result);
        helper(root.right, level+1,result);
    }
}
