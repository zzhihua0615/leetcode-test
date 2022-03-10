package z.z.h.rotate_right_61;

/**
 * @author zzhihua
 * @date 2022/3/10
 */
public class RotateRight {

    /**
     * 思路只需要找到旋转的位置，旋转位置前的ListNode节点的next改为null，尾节点指向原来的head节点，然后将要旋转位置作为开始位置返回即可
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }
        int n = 1;
        ListNode iter = head;
        while (iter.next != null) {
            iter = iter.next;
            n++;
        }
        int add = n - k % n;
        if (add == n) {
            return head;
        }
        iter.next = head;
        while (add-- > 0) {
            iter = iter.next;
        }
        ListNode ret = iter.next;
        iter.next = null;
        return ret;
    }
}
