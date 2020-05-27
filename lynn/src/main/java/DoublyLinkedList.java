public class DoublyLinkedList {

    private Node head;
    private Node tail;
    private int size = 0;

    private class Node {
        private Object data; //데이터를 저장할 필드
        private Node next; //다음 노드
        private Node prev; //이전 노드

        public Node(Object input) {
            this.data = input;
            this.next = null;
            this.prev = null;
        }

        // 노드의 내용을 쉽게 출력해서 확인해볼 수 있는 기능
        public String toString() {
            return String.valueOf(this.data);
        }
    }
}
