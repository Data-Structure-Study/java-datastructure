import java.util.EmptyStackException;

public class StackOfLinkedList<T> {

    private Node<T> top; //top 노드를 가리키는 변수

    private class Node<T> {
        private T data;
        private Node<T> next; //다음 노드를 가리킴

        public Node(T data) {
            this.data = data;
        }
    }

    //가장 위에 있는 노드를 가져오고 삭제
    public T pop() {
        T item = peek(); //반환할 데이터
        top = top.next; //기존 top의 다음 노드를 가리키도록 함
        return item;
    }

    //새로운 노드 추가
    public void push(T item) {
        Node<T> newNode = new Node<T>(item); //새 노드 생성
        newNode.next = top; //새 노드가 기존 노드 위에 쌓이니까 새노드.next는 top
        top = newNode; //top이 최신 노드를 가리키도록 함
    }

    //데이터 가져오기
    public T peek() {
        //top == null일 때 예외처리
        if(top == null) {
            throw new EmptyStackException();
        }
        return top.data;
    }

    //스택이 비었는지 확인
    public boolean isEmpty() {
        return top == null;
    }

    public int search(T item) {
        Node<T> searchNode = top; //검색용 노드
        int index = 0; //index는 top부터 시작

        while(true) {
            if(searchNode.data == item) { //동일한 data가 있으면 index 반환
                return index;
            } else { //동일하지 않으면 다음 노드로 넘어감
                searchNode = searchNode.next;
                index++;
                if(searchNode == null) { //searchNode가 null이면 동일한 data가 존재하지 않음
                    break;
                }
            }
        }

        //동일한 데이터가 없으면 -1 반환
        return -1;
    }
}

class Test {
    public static void main(String[] args) {
        StackOfLinkedList<Integer> stack = new StackOfLinkedList<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println(stack.search(2));
        System.out.println(stack.search(5));
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
    }
}
