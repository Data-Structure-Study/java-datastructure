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

    //이중 연결 리스트의 장점
    private Node node(int index) {
        // 노드의 인덱스가 전체 노드 수의 반보다 큰지 작은지 계산
        if (index < size / 2) {
            // head부터 next를 이용해서 인덱스에 해당하는 노드를 찾습니다.
            Node x = head;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            // tail부터 prev를 이용해서 인덱스에 해당하는 노드를 찾습니다.
            Node x = tail;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }

    public void addFirst(Object input) {
        /*
        1. input값을 사용하여 새로운 노드를 생성
        2. 새 노드 next -> 기존 헤드 노드 연결
        3. 만약 기존의 헤드가 null이 아니라면 기존 헤드 노드 prev -> 새 노드 연결
        4. 새 노드를 새로운 헤드로 지정
        5. 리스트에 노드의 개수가 1이면 head와 tail이 모두 같은 노드를 가리킴
         */
        Node newNode = new Node(input);

        newNode.next = head;
        if (head != null) {
            head.prev = newNode;
        }

        head = newNode;
        size++;

        if (head.next == null) {
            tail = head;
        }
    }

    public void addLast(Object input) {
        /*
        1. input으로 새로운 노드 생성
        2. 리스트의 노드가 없다면 첫번째 노드를 추가하는 메소드를 사용
        3. 기존 테일 next -> 새 노드 연결
        4. 새 노드 prev -> 기존 테일 연결
        5. 테일이 새 노드를 가리킴
         */
        Node newNode = new Node(input);

        if (size == 0) {
            addFirst(input);
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            size++;
        }
    }

    public void add(int k, Object input) {
        /*
        1. 만약 k가 0이라면 첫번째 노드에 추가하는 것이기 때문에 addFirst()를 사용
        2. k번째에 추가해야 하므로 k-1(새 노드의 이전 노드)와 k(새 노드의 다음 노드)번째 노드들을 임시 변수에 담음
        3. input으로 새 노드 생성
        4. k-1 next -> 새 노드 연결
        5. 새 노드 next -> k 연결
        6. k prev -> 새 노드 연결
        7. 새 노드 prev -> k-1 연결
        8. 새로운 노드의 다음 노드가 없다면 새로운 노드가 마지막 노드이기 때문에 tail로 지정
         */
        if (k == 0) {
            addFirst(input);
        } else {
            Node temp1 = node(k - 1);
            Node temp2 = temp1.next;
            Node newNode = new Node(input);

            temp1.next = newNode;
            newNode.next = temp2;

            if (temp2 != null){
                temp2.prev = newNode;
            }
            newNode.prev = temp1;

            size++;

            if (newNode.next == null) {
                tail = newNode;
            }
        }
    }

    public Object removeFirst() {
        /*
        1. 삭제할 첫번째 노드를 임시 노드에 담는다 (노드.data 반환해주려고)
        2. 헤드가 임시 노드(기존의 헤드)의 다음 노드를 가리킨다
        3. 데이터를 삭제하기 전에 리턴할 값을 임시 변수에 담는다
        4. 임시 노드를 null로 바꿔준다.
            GC가 삭제할 노드를 처리하도록?
        5. 리스트 내에 노드가 있다면 head의 이전 노드를 null로 지정
            조건문을 쓰는 이유는 널포인트 예외처리?
        6. 데이터가 담긴 임시변수 반환
         */
        Node temp = head;
        head = temp.next;

        Object returnData = temp.data;

        temp = null;

        if(head != null) {
            head.prev = null;
        }

        size--;
        return returnData;
    }

    public Object remove(int k) {
        /*
        1. k=0이면 removeFirst()사용한다
        2. k-1과 k번째 노드는 임시 노드에 담는다
            k-1 -> 다른 노드와 연결해주기위해
            k -> 삭제한 데이터를 반환해 주려고
        3. k-1 next -> 삭제할 노드의 다음 노드 연결
        4. k-1.next가 null이 아니면 3번의 다음 노드 prev -> k-1 연결
            null이면 테일이라는 뜻이니까 연결하지 않음
        5. 삭제된 노드의 데이터를 리턴하기 위해서 returnData에 데이터를 저장
        6. 삭제된 노드가 tail이었다면 k-1을 tail로 지정
        7. 임시 노드에 담은 삭제할 노드는 null로 지정
         */
        if(k==0) {
            removeFirst();
        }

        Node temp = node(k-1);
        Node todoDeleted = temp.next;

        temp.next = temp.next.next;
        if(temp.next != null) {
            temp.next.prev = temp;
        }

        Object returnData = todoDeleted.data;

        if(todoDeleted == tail) {
            tail = temp;
        }

        todoDeleted = null;

        size--;
        return returnData;
    }

    public  Object removeLast() {
        return remove(size - 1);
    }

    public Object get(int k) {
        Node temp = node(k);
        return temp.data;
    }

    //특정 데이터가 저장된 인덱스를 알아내는 방법
    public int indexOf(Object data) {
        /*
        1. 반복문을 이용해서 헤드부터 node.data를 비교한다
         */
        Node temp = head;
        int index = 0;

        while (temp.data != data) {
            temp = temp.next;
            index++;

            // temp의 값이 null이라는 것은 더 이상 탐색 대상이 없다는 것을 의미합니다.이 때 -1을 리턴합니다.
            if(temp == null) {
                return -1;
            }
        }

        return index;
    }

}
