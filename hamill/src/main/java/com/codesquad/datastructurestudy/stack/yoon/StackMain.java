package com.codesquad.datastructurestudy.stack.yoon;

public class StackMain {

  public static void main(String[] args) {
    StackCircularLinkedList stack = new StackCircularLinkedList();
//    Stack stack = new StackLinkedListImpl();
//    Stack stack = new StackArrayImpl();

    System.out.println("스택이 비었습니까?");
    System.out.println(stack.isEmpty());

    System.out.println("스택 삽입");
//    stack.push(1);
//    stack.push(2);
//    stack.push(3);
//    stack.push(4);
//    stack.push(5);
    stack.push("1");
    stack.push("2");
    stack.push("3");
    stack.push("4");
    stack.push("5");
    stack.push("6");

    System.out.println("스택 삽입 후");
    System.out.println("스택이 비었습니까?");
    System.out.println(stack.isEmpty());
    System.out.println("스택 제일 위의 값은?");
    System.out.println(stack.peek());

    stack.pop();
    System.out.println("스택 삭제 후");
    System.out.println("스택 제일 위의 값은?");
    System.out.println(stack.peek());

    stack.pop();
    System.out.println("스택 삭제 후");
    System.out.println("스택 제일 위의 값은?");
    System.out.println(stack.peek());

    stack.pop();
    System.out.println("스택 삭제 후");
    System.out.println("스택 제일 위의 값은?");
    System.out.println(stack.peek());

    stack.pop();
    System.out.println("스택 삭제 후4");
    System.out.println("스택 제일 위의 값은?");
    System.out.println(stack.peek());

    stack.pop();
    System.out.println("스택 삭제 후3");
    System.out.println("스택 제일 위의 값은?");
    System.out.println(stack.peek());

    stack.pop();
    System.out.println("스택 삭제 후2");
    System.out.println("스택 제일 위의 값은?");
    System.out.println(stack.peek());

    stack.pop();
    System.out.println("스택 삭제 후1");
    System.out.println("스택 제일 위의 값은?");
    System.out.println(stack.peek());

    char ch1 = '1';
    char ch2 = '2';
    int num1 = Character.getNumericValue(ch1);
    int num2 = Character.getNumericValue(ch2);
    System.out.println("char 연산");
    System.out.println(num1 + num2);
    System.out.println(num1 - num2);
    System.out.println(num1 * num2);
    System.out.println(num1 / num2);
  }
}
