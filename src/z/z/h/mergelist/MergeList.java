package z.z.h.mergelist;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * @author zzhihua
 * @date 2021/7/5
 */
public class MergeList {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        ListNode listNode = mergeTwoLists(l1, l2);
        System.out.println(listNode);
    }

    /**
     * 方法一：采用迭代的方式
     *
     * @param node1
     * @param node2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode node1, ListNode node2) {
        ListNode result = new ListNode(-1);
        ListNode node = result;
        while (node1 != null && node2 != null) {
            if (node1.val <= node2.val) {
                node.next = new ListNode(node1.val);
                node1 = node1.next;
            } else {
                node.next = new ListNode(node2.val);
                node2 = node2.next;
            }
            node = node.next;
        }
        node.next = node1 == null ? node2 : node1;
        return result.next;
    }

    /**
     * 方法二：采用递归的方式
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists/solution/he-bing-liang-ge-you-xu-lian-biao-by-leetcode-solu/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

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

/*    @Override
    public String toString() {
        String node = "" + val;
        ListNode node2 = next;
        while (null != node2) {
            node += next.val;
            node2 = node2.next;
        }
        return node;
    }*/
}