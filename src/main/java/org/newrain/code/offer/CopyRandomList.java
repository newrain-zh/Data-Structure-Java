package org.newrain.code.offer;


import java.util.HashMap;
import java.util.Map;

public class CopyRandomList {

    public Node copyRandomList(Node head) {
        Map<Node, Node> all = new HashMap<>();
        Node curr = head;
        while (curr != null) {
            all.put(curr, new Node(curr.val));
            curr = curr.next;
        }
        curr = head;
        while (curr != null) {
            all.get(curr).next = all.get(curr.next);
            all.get(curr).random = all.get(curr.random);
            curr = curr.next;
        }
        return all.get(head);

    }


    class Node {
        public int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
