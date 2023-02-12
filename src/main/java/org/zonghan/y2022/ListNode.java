package org.zonghan.y2022;

public class ListNode {
    int value;
    ListNode next;

    ListNode() {
    }

    ListNode(int value) {
        this.value = value;
    }

    ListNode(int value, ListNode next) {
        this.value = value;
        this.next = next;
    }

    public void printList() {
        ListNode p = this;
        System.out.print(p.value);
        while (p.next != null) {
            p = p.next;
            System.out.print("," + p.value);
        }
        System.out.println();
    }

    public static void staticPrintList(ListNode listNode) {
        if (listNode != null) {
            listNode.printList();
        } else {
            System.out.println("empty list");
        }
    }
}
