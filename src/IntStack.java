// "01001001"


public class IntStack {
    private int[] stack;
    private int sp;
    private final int DEFAULT_CAPACITY = 10;

    public IntStack()   {
        stack = new int[DEFAULT_CAPACITY];
        sp = 0;
    }

    public IntStack(int capacity)   {
        stack = new int[capacity];
        sp = 0;
    }

    public void push(int i) {
        if(sp >= stack.length) {
            int[] newStack = new int[stack.length * 2];
            System.arraycopy(stack, 0, newStack, 0, stack.length);
            stack = newStack;
        }
        stack[sp++] = i;
    }

    public int peek()   {
        return stack[sp-1];
    }

    public int pop()    {
        return stack[--sp];
    }

    public String toString()    {
        String str = "";
        for(int i = sp-1; i >= 0; i--)
            str += stack[i]+"\n";
        return str;
    }

    public static int binToInt(String binNum)   {
        int toNum = 0;
        for(int i = binNum.length() - 1; i >= 0; i--)
            toNum += (binNum.charAt(i) - 48) * Math.pow(2, binNum.length()-(i+1));
        return toNum;
    }

    public static void main(String[] args) {
        /*IntStack stack = new IntStack();
        for(int i = 1; i <= 20; i++)
            stack.push(i);
        System.out.println(stack);*/

        System.out.println("1001001 = " + IntStack.binToInt("1001001"));
    }
}
