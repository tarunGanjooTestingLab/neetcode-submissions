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
        if(head == null)
            return null;

        Node temp = head;
        while(temp != null){
            Node newNode = new Node(temp.val);
            Node next = temp.next;
            temp.next = newNode;
            newNode.next = next;
            temp = temp.next.next;
        }

        temp = head;
        while(temp != null){
            temp.next.random = temp.random != null ? temp.random.next : null;
            temp = temp.next.next;
        }
        
        Node newHead = head.next;
        Node dummy = newHead;
        temp = head;

        while(temp.next.next != null){
            temp.next = dummy.next;
            temp = temp.next;

            dummy.next = temp.next;
            dummy = dummy.next;
        }

        temp.next = null;
        return newHead;
    }
}
