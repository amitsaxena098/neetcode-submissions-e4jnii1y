/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Map<Integer, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        return copyGraph(node);
    }
    public Node copyGraph(Node node) {
        if(node == null) { return null;}
        Node thisNode;
        if(map.containsKey(node.val)) {
            thisNode = map.get(node.val);
        } else {
            thisNode = new Node(node.val);
            map.put(node.val, thisNode);
        }
        List<Node> list = node.neighbors;
        for(Node n : list) {
            if(map.containsKey(n.val)) {
                thisNode.neighbors.add(map.get(n.val));
            } else {
                thisNode.neighbors.add(copyGraph(n));
            }
        }
        return thisNode;
    }
}