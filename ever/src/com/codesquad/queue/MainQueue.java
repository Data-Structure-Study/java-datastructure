package com.codesquad.queue;

public class MainQueue {

    public static void main(String[] args) {
        ArrayQueue<String> queue = new ArrayQueue<>();
        queue.add("apple");
        queue.add("orange");
        queue.add("cherry");
        queue.add("pear");

        queue.remove();

        queue.add("grape");
        queue.add("lemon");
        queue.add("mango");
        queue.add("lime");
        queue.add("kiwi");

        System.out.println("======================= List Queue Start ========================");

        ListQueue<String> listQueue = new ListQueue<>();
        listQueue.add("apple");
        listQueue.add("orange");
        listQueue.add("cherry");
        listQueue.add("pear");

        listQueue.remove();
        listQueue.remove();

        listQueue.add("grape");

        /* 실행 결과

        null apple

        Run Resize

        null apple orange null
        null apple orange cherry

        Run Resize

        null apple orange cherry pear null null null
        null null orange cherry pear null null null
        null null orange cherry pear grape null null
        null null orange cherry pear grape lemon null
        null null orange cherry pear grape lemon mango
        lime null orange cherry pear grape lemon mango

        Run Resize

        null orange cherry pear grape lemon mango lime kiwi null null null null null null null
        ======================= List Queue Start ========================
        apple
        apple orange
        apple orange cherry
        apple orange cherry pear
        orange cherry pear
        cherry pear
        cherry pear grape

         */
    }
}
