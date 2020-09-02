package queue;

public class QueueMain {
    public static void main(String[] args) {

        QueueSunny<Integer> queue = new QueueSunny<>();

        System.out.println(queue.isEmpty());

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        System.out.println(queue.isEmpty());

        System.out.println("큐의 사이즈: " + queue.size());
        System.out.println(queue.peek());

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());    // 에러
        System.out.println(queue.peek());       // 에러
    }
}
