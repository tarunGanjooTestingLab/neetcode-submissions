/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> mp = new HashMap<>();
        Node temp = head;
        while(temp != null){
            mp.put(temp, new Node(temp.val));
            temp = temp.next;
        }

        temp = head;
        while(temp != null){
            Node current = temp;
            Node mappedNode = mp.get(current);
            Node nextPointerNode = mp.get(current.next);
            Node randomPointerNode = mp.get(current.random);

            mappedNode.next = nextPointerNode;
            mappedNode.random = randomPointerNode;
            temp = temp.next;
        }

        return mp.get(head);
    }
}
