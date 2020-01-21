// Problem Statement
//https://leetcode.com/problems/clone-graph/ 

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/
class Solution {
    Map<Node,Node> map;
    public Node cloneGraph(Node node) {
        map = new HashMap<Node,Node>();
        Node out = new Node(node.val,new ArrayList<Node>());
        //map.add(node,out);
        dfs(node,out);
        return out;
    }
    
    private void dfs(Node ref, Node out){
        map.put(ref,out);
        for(Node w : ref.neighbors){
            if(map.containsKey(w)) out.neighbors.add(map.get(w));
            else{
                Node out_neigh = new Node(w.val,new ArrayList<Node>());
                out.neighbors.add(out_neigh);
                dfs(w,out_neigh);
            }           
        }
    }
}
