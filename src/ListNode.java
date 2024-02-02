public class ListNode {
    private Object value;
    private ListNode next;
    //private ListNode previous;

    public ListNode(Object val) {
        this.value = val;
        next = null;
    }
    public ListNode(ListNode other) {
        value = other.value;
        next = other.next;
    }
    public ListNode(Object value, ListNode next) {
        this.value = value;
        this.next = next;
    }
    public Object getValue() {
        return value;
    }

    public ListNode getNext() {
        return next;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
