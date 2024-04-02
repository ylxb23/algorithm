package org.zero.algorithm;

/**
 * 链表和反转
 * @author ylxb2
 * @date 2023/07/05
 */
public class Link {
    private String _name;

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
     * @param arr
     * @return
     */
    static Node buildLink(int[] arr) {
        if(arr == null) {
            return new Node();
        }
        Node head = new Node(arr[0], null);
        Node next = head;
        for(int i=1; i<arr.length; i++) {
            next.next = new Node(arr[i], null);
            next = next.next;
        }
        return head;
    }


    // 链表隔k个元素反转
    static Node reverseByStep(Node link, int step) {
        if(link == null || link.next == null) {
            return link;
        }
        Node newLink = null;
        Node seg = null;
        Node tail = null;

        int i=0;
        while(link != null) {
            Node temp = link.next;
            link.next = newLink;

            newLink = link;
            link = temp;
            if(step > 1) {
                i++;
                if(i == 1) {
                    tail = newLink;
                }
                if(i % step == 1) {
                    seg = newLink;
                } else if(i / step > 1 && i % step == 0) {
                    tail.next = newLink;
                    tail = seg;
                    newLink = seg.next;
                    seg = null;
                    tail.next = null;
                }
            }
        }
        if(step > 1) {
            int k = i % step;
            if(k != 0) {
                tail.next = newLink;
                tail = seg;
                newLink = seg.next;
                tail.next = null;
            }
        }
        return newLink;
    }

    // 链表反转
    static Node reverse(Node link) {
        if(link == null || link.next == null) {
            return link;
        }
        Node newLink = null;
        while(link != null) {
            Node temp = link.next;
            link.next = newLink;

            newLink = link;
            link = temp;
        }
        return newLink;
    }

    // 重建链表方式
    static Node reverse4NewBuild(Node link) {
        if(link == null || link.next == null) {
            return link;
        }
        Node newLink = null;
        while(link != null) {
            Node prev = new Node(link.val, newLink);
            newLink = prev;
            link = link.next;
        }
        return newLink;
    }

    public static void main(String[] args) {
        long bigValue = 99999L;
        Node link = buildLink(new int[]{1,2,3,4,5,6,7,8,9});
        link.print();
        Node rlink = reverse(link);
        System.out.print("After reverse, ");
        rlink.print();
        Node rrlink = reverse4NewBuild(rlink);
        System.out.print("After reverse twice, ");
        rrlink.print();

        int step = 2;
        Node linkM = buildLink(new int[]{1,2,3});
        Node rM = reverseByStep(linkM, step);
        System.out.print("After reverse by step(" + step + "), ");
        rM.print();

        linkM = buildLink(new int[]{1,2,3,4});
        rM = reverseByStep(linkM, step);
        System.out.print("After reverse by step(" + step + "), ");
        rM.print();

        linkM = buildLink(new int[]{1,2,3,4,5});
        rM = reverseByStep(linkM, step);
        System.out.print("After reverse by step(" + step + "), ");
        rM.print();

        linkM = buildLink(new int[]{1,2,3,4,5,6});
        rM = reverseByStep(linkM, step);
        System.out.print("After reverse by step(" + step + "), ");
        rM.print();

        linkM = buildLink(new int[]{1,2,3,4,5,6,7});
        rM = reverseByStep(linkM, step);
        System.out.print("After reverse by step(" + step + "), ");
        rM.print();

        linkM = buildLink(new int[]{1,2,3,4,5,6,7,8});
        rM = reverseByStep(linkM, step);
        System.out.print("After reverse by step(" + step + "), ");
        rM.print();
    }
}
