import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class CollectionsExploration {


    public static void main(String[] args) {
        /*List<String> list = new List<>();
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new LinkedList<>();
        ArrayList<String> list3 = new List<>();
        ArrayList<String> list4 = new ArrayList<>();
        LinkedList<String> list5 = new List<>();
        LinkedList<String> list6 = new ArrayList<>();
        LinkedList<Object> list7 = new LinkedList<>();*/
        Stack<Integer> stack = new Stack<>();
        stack.push(-6);
        stack.push(4);
        stack.push(-2);
        stack.push(7);
        stack.push(3);
        stack.push(-1);
        System.out.println(stack);
        Stack<Integer> stackPos = new Stack<>();
        Stack<Integer> stackNeg = new Stack<>();

        while(!stack.isEmpty()) {
            Integer obj = stack.pop();
            if(obj.intValue() >= 0)
                stackPos.push(obj);
            else
                stackNeg.push(obj);
        }

        while(!stackPos.isEmpty())
            stack.push(stackPos.pop());
        while(!stackNeg.isEmpty())
            stack.push(stackNeg.pop());

        System.out.println(stack);
    }
}
