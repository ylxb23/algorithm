package org.zero.algorithm;

/**
 * 链表和反转
 */
public class Link {

    public static class Node {
        int val;
        Node next;

        public Node() {}
        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

        public void print() {
            System.out.print("Link is: ");
            Node node = this;
            while(node != null) {
                System.out.print(node.val + ", ");
                node = node.next;
            }
            System.out.println();
        }
    }

    /**
     * 构建链表
     * @param list
     * @return
     */
    static Node buildLink(int[] list) {
        if(list == null) {
            return new Node();
        }
        Node head = new Node(list[0], null);
        Node next = head;
        for(int i=1; i<list.length; i++) {
            next.next = new Node(list[i], null);
            next = next.next;
        }
        return head;
    }

    /**
     * 反转链表
     * @param link
     * @return
     */
    static Node reverse(Node link) {
        if(link == null) {
            return null;
        }
        if(link.next == null) {
            return link;
        }
        Node newLink = new Node();
        while(link != null) {
            Node temp = link.next;
            link.next = newLink.next;
            newLink.next = link;
            link = temp;
        }
        return newLink.next;
    }


    public static void main(String[] args) {
        Node link = buildLink(new int[]{1,2,3,4,5,6,7,8,9});
        link.print();
        Node rlink = reverse(link);
        System.out.print("After reverse, ");
        rlink.print();
    }
}
