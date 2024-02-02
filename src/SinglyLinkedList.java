import java.util.NoSuchElementException;

public class SinglyLinkedList {
    private ListNode head;
    private int nodeCount;

    public SinglyLinkedList(Object value)   {
        head = new ListNode(value);
        nodeCount++;
    }

    public ListNode getHead()   {   return head;    }

    public SinglyLinkedList(ListNode head)  {
        this.head = head;
    }

    public void addToFront(ListNode other) {
        other.setNext(head);
        head = other;
        nodeCount++;
    }

    public void addToFront(Object o)   {
        ListNode newNode = new ListNode(o, head);
        head = newNode;
        nodeCount++;
    }

    public void addToEnd(ListNode other)    {
        ListNode temp = head;
        while(temp.getNext() != null)   {
            temp = temp.getNext();
        }
        temp.setNext(other);
        //tail = other;
        //for(ListNode temp = head; temp.getNext() != null; temp = temp.getNext());
        //temp.setNext(other);
    }

    public int getLength() {
        return nodeCount;
    }

    public String toString() {
        String out = "[";
        for(ListNode temp = head; temp != null; temp = temp.getNext())
            out += temp.getValue()+((temp.getNext() == null)?"":", ");
        return out+"]";
    }

    public ListNode reverseList(ListNode head)  {
        ListNode newHead = null;
        for(ListNode current = head; current != null; current = current.getNext())  {
            newHead = new ListNode(current.getValue(), newHead);
        }
        return newHead;
    }

    public ListNode concatenateStrings(ListNode head)   {
        ListNode head2 = null, tail2 = null;
        String temp = new String();
        for(ListNode current = head; current != null; current = current.getNext())  {
            temp += current.getValue();
            ListNode newNode = new ListNode(temp, null);
            if(tail2 == null)
                head2 = newNode;
            else
                tail2.setNext(newNode);
            tail2 = newNode;
        }
        return head2;
    }

    public ListNode insertInOrder(ListNode head, String s)  {
        ListNode temp = head, prev = null;
        while(temp != null && s.compareTo((String)(temp.getValue())) > 0) {
            prev = temp;
            temp = temp.getNext();
        }
        // s already exists in the list
        if(temp != null && s.equals(temp.getValue()))
            return head;

        // s isn't already in the list
        ListNode newNode = new ListNode(s, temp);

        if(prev == null)
            head = newNode;
        else
            prev.setNext(newNode);

        return head;
    }

    public ListNode remove(ListNode head, String s) {
        ListNode temp = head, prev = null;
        // s is at the head of the list
        if(temp != null && s.equals((String)temp.getValue()))   {
            head = temp.getNext();
            return head;
        }
        // s is in the middle of the list, iterate
        while(temp != null && !s.equals((String)(temp.getValue()))) {
            prev = temp;
            temp = temp.getNext();
        }
        // if temp is not null, then we've iterated to the correct node in the list
        if(temp != null && s.equals(temp.getValue()))   {
            prev.setNext(temp.getNext());
            return head;
        }
        else    // if temp is null we're at the end of the list, throw NoSuchElement
            throw new NoSuchElementException(s + " not found in list");
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList("M");
        list.addToFront("G");
        list.addToFront("D");
        list.addToFront("A");
        System.out.println(list);


        SinglyLinkedList reversedList = new SinglyLinkedList(list.reverseList(list.getHead()));
        System.out.println(reversedList);

        SinglyLinkedList concatList = new SinglyLinkedList(list.concatenateStrings(list.getHead()));
        System.out.println(concatList);

        System.out.println(list);
        list.insertInOrder(list.getHead(),"F");
        System.out.println(list);

        try {
            list.remove(list.getHead(), "M");   // this will work and will remove M
            list.remove(list.getHead(), "J");   // this will throw an exception
        }
        catch(Exception e)  {
            e.printStackTrace();
        }
        // confirm M removed but J not found in list
        System.out.println(list);
    }
}
