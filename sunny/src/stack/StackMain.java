package stack;

public class StackMain {
    public static void main(String[] args) {

        SunnyStack<Integer> madeStack = new SunnyStack<>();
        madeStack.push(1);
        madeStack.push(2);
        madeStack.push(3);
        madeStack.push(4);

        System.out.println(madeStack.pop());
        System.out.println(madeStack.pop());
        System.out.println(madeStack.peek());
        System.out.println(madeStack.pop());
        System.out.println(madeStack.isEmpty());
        System.out.println(madeStack.pop());
        System.out.println(madeStack.isEmpty());
        System.out.println(madeStack.pop());


    }
}
