package com.codesquad.stack;

public class MainStack {

    public static void main(String[] args) {
        ArrayStack<String> stack = new ArrayStack<>();
        stack.push("apple");
        stack.push("orange");
        stack.push("cherry");
        stack.push("pear");

        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();

        System.out.println(" ============= List Stack =============");

        ListStack<String> listStack = new ListStack<>();
        listStack.push("apple");
        listStack.push("orange");
        listStack.push("cherry");
        listStack.push("pear");

        listStack.pop();
        listStack.pop();
        listStack.pop();
        listStack.pop();

        /* 실행 결과

        apple  < top
        apple orange  < top
        apple orange cherry  < top
        apple orange cherry pear  < top
        apple orange cherry  < top
        apple orange  < top
        apple  < top
        < top
        ============= List Stack =============
        top > apple
        top > orange apple
        top > cherry orange apple 
        top > pear cherry orange apple
        top > cherry orange apple
        top > orange apple
        top > apple
        top >

         */
    }
}
