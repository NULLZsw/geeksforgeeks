package sorting;

import org.junit.Test;

public class ListSortByMerge {
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
        ListNode res = mergesort(l1);
        while (res != null){
            System.out.print(res.val + "   ");
            res = res.next;
        }
    }

    public ListNode mergesort(ListNode head){
        // 刚开始没有加入这个 判断条件 ，导致进入了死循环，写递归的时候，
        //必须要注意  递归的结束条件， 避免进入死循环
        if(head == null || head.next == null) return head;
        ListNode left ,right ,part ;
        part = partition(head);

        left = mergesort(head);
        right = mergesort(part);

        return merge(left,right);
    }
    //将传入的 一个链表 分成 长度尽可能相等的两个链表,将后半段链表的起始段返回
    public ListNode partition(ListNode head){
        ListNode fast = head , slow = head , prev = head;
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        return slow;
    }

    //将 两个 链表归并后并将 归并后的 头节点返回
    public ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else{
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if(l1 != null) cur.next = l1;
        if(l2 != null) cur.next = l2;
        return dummy.next;
    }
}
