package sorting;

import org.junit.Test;

public class ListSortByQuicksort {
    @Test
    public void test(){

        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(5);
        ListNode l3 = new ListNode(7);
        ListNode l4 = new ListNode(6);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(11);
        ListNode l7 = new ListNode(26);
        l1.next = l2 ; l2.next = l3 ; l3.next = l4;
        l4.next = l5 ; l5.next = l6 ; l6.next = l7;
        ListNode res = sortListopt(l1);
        while (res != null){
            System.out.print(res.val + "   ");
            res = res.next;
        }
    }
    //这里采用的是 ，将一整条链表 拆分成 小于，等于，大于 pivot  的三段链表 ，进行递归，然后进行拼接
    //我还见过另一种写法 ，通过传入 链表的 首尾 单元，最好的方式是 以 当前链表尾为 pivot ，然后从链表头部向后扫描
    //将 大于 pivot 的单元 放置在 链表尾部的后面，这样就将 原始链表尾部的节点位置固定了，递归 分别大于和小于 pivot
    //的两段链表，直至  递归结束，  递归的终止条件为  如果传入的链表只有 0 个或者 1 个节点，这时是不需要排序的额，直接返回即可

    public ListNode sortListopt(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode pivot = head;
        ListNode left = new ListNode(-1);
        ListNode right = new ListNode(-1);
        ListNode leftHead = left;
        ListNode rightHead = right;
        ListNode pivotHead = pivot;
        ListNode crt = head.next;
        if (crt == null)
            return pivot;

        while(crt != null) {
            if (crt.val < pivot.val) {
                left.next = crt;
                left = left.next;
            } else if (crt.val > pivot.val){
                right.next = crt;
                right = right.next;
            } else {
                pivot.next = crt;
                pivot = pivot.next;
            }
            crt = crt.next;
        }

        pivot.next = null;
        left.next = null;
        right.next = null;
        left = sortListopt(leftHead.next);
        right = sortListopt(rightHead.next);
        pivot.next = right;
        ListNode re = left;

        while (left != null && left.next != null) {
            left = left.next;
        }

        if (left == null)
            re = pivotHead;
        else
            left.next = pivotHead;
        return re;
    }

}
