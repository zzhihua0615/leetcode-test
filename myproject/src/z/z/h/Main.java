package z.z.h;

public class Main {

    public static void main(String[] args) {
        // write your code here
        System.out.println("macbook 里面的第一行代码");
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode listNode = addTwoNumbers(l1, l2);
        System.out.println(listNode);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode tail = null;
        if (l1.val == 0 || l2.val == 0) {
            head = l1.val == 0 ? l2 : l1;
        }
        int carry = 0;
        boolean flag = true;
        while (flag) {
            int i = l1.val + l2.val + carry;
            if (i >= 10) {
                carry = i / 10;
                i = i % 10;
            } else {
                carry = 0;
            }
            ListNode listNode = new ListNode(i);
            if (head == null) {
                head = tail = listNode;
            } else {
                tail.next = new ListNode(i);
                tail = tail.next;
            }
            if (l1.next == null && l2.next == null) {
                flag = false;
            }
            if (l1.next != null) {
                l1 = l1.next;
            } else {
                l1 = new ListNode(0);
            }
            if (l2.next != null) {
                l2 = l2.next;
            } else {
                l2 = new ListNode(0);
            }
        }
        return head;
    }
}


class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
