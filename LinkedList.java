package list;

class Node{
    public int data;//数据
    public Node next=null;//下一个节点的位置

    public Node(int data) {
        this.data = data;
    }
}

public class LinkedList {
    //管理所有的连败哦节点，只需要记录头结点的位置
    //初始情况下head为null。表示为空链表
    private Node head=null;
    public void addFirst(int data){
        //根据data构建一个链表节点
        Node node=new Node(data);
        //如果链表为空链表
        if (head==null){
            head=node;
            return;
        }
        //如果链表不是空链表
        node.next=head;
        head=node;
    }
    public void addlaet(int data){
        //根据data后遭一个Node对象
        Node node=new Node(data);
        //如果链表为空链表
        if (head==null){
            head=node;
            return;
        }
        //如果链表非空，需要先找到这个链表末尾的最后一个节点
        Node tail=head;
        while (tail.next!=null){
            tail=tail.next;
        }
        //循环结束之后，tail捷对应到最后一个节点
        tail.next=node;
    }
    public void display(){
        //吧链表中的每个元素都打印出来
        for (Node cur=head;cur!=null;cur=cur.next){
            System.out.print(cur.data+" ");
        }
        System.out.println();
    }
    public int getSize(){
        int size=0;
        for (Node cur=head;cur!=null;cur=cur.next){
            size++;
        }
        return size;
    }
    //插入成功，返回true，否则返回false
    public boolean addIndex(int index,int data){
        int size=getSize();
        //判定index是否有效
        if (index<0||index>size){
            return false;
        }
            // 如果index为0；相当于头插
            if (index==0){
                addFirst(data);
                return true;
            }
            //如果index为size，相当于尾插
            if(index==size){
                addlaet(data);
                return true;
            }
            Node node=new Node(data);
            //如果index是一个中间的位置
           Node prev=getPos(index-1);
            node.next=prev.next;
            prev.next=node;
            return true;
        }
        //给定index下标，找到对应的节点
        private Node getPos(int index){
            Node cur=head;
            for (int i = 0; i <index ; i++) {
                cur=cur.next;
            }
            return cur;
        }
        public boolean contains(int tofind){
            for (Node cur= head; cur !=null; cur=cur.next) {
                if (cur.data==tofind){
                    return true;
                }
            }
            return false;
        }
        public void remove(int toRemove){
            //如果要删除元素是头结点，特殊处理
            if (head.data==toRemove){
                head=head.next;
                return;
            }
            //如果要删除的元素不是头结点，找到要删除节点的前一个位置
            Node prev=searchPrev(toRemove);
                //修改引用的指向，完成删除
                prev.next=prev.next.next;
                Node toDelete=prev.next;
                prev.next=toDelete.next;
            }
            private Node searchPrev(int toRemove){
                //找到toRmove的前一个节点
                for (Node cur=head;cur!=null&&cur.next!=null;cur=cur.next){
                    if (cur.next.data==toRemove){
                        return cur;
                    }
                }
                return null;
            }
}
