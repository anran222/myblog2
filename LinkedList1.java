package list;

class ListNode{
    public int val;
    public ListNode next;

    public ListNode(int x) {
        this.val = x;
    }
}

public class LinkedList1 {
    public ListNode reverseList(ListNode head){
        //判断是否为空链表
        if (head==null){
            return null;
        }
        //如果只有一个元素
        if (head.next==null){
            return head;
        }
        ListNode newHead=null;
        ListNode cur=head;
        ListNode prev=null;
        while (cur!=null){
            ListNode next=cur.next;
            if (next==null){
                newHead=cur;
            }
            cur.next=prev;
            prev=cur;
            cur=next;
        }
        return newHead;
    }

    public ListNode middleNode(ListNode head){
        if (head==null){
            return null;
        }
        if (head.next==null){
            return head;
        }
        int steps=getSize(head)/2;
        ListNode cur=head;
        for (int i = 0; i <steps ; i++) {
            cur=cur.next;
        }
        return cur;
    }

    private int getSize(ListNode head){
        int size=0;
        for (ListNode cur=head;cur!=null;cur=cur.next){
            size++;
        }
        return size;
    }

    public ListNode FindKthToTail(ListNode head,int k){
        if (head==null){
            return null;
        }
        int size=getSize(head);
        if(k<=0||k>size){
            return null;
        }
        int offset=size-k;
        ListNode cur=head;
        for (int i = 0; i <offset ; i++) {
            cur=cur.next;
        }
        return cur;
    }
}
