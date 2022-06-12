package daily.text.month6.day12;

//扁平化多级双向链表
public class Solution1 {
    public Node1 flatten(Node1 head) {
        if(head == null)
            return null;
        Node1 cur = head;
        while(cur != null){
            Node1 next = new Node1();
            if(cur.child != null){
                next = cur.next;
                cur.next = cur.child;
                cur.child.prev = cur;
                Node1 tmp = cur.child;
                while(tmp.next != null){
                    tmp = tmp.next;
                }
                if(next != null){
                    next.prev = tmp;
                    tmp.next = next;
                }
                cur.child = null;
            }
            cur = cur.next;
        }
        return head;
    }
}
class Node1 {
    public int val;
    public Node1 prev;
    public Node1 next;
    public Node1 child;
};
