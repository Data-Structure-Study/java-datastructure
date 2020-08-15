## 큐(Queue)

삽입과 삭제가 양 끝에서 각각 수행되는 자료구조

FIFO(First-In First-Out)

- 은행에서 번호표를 받아 자신의 순서를 기다리는 경우

### 배열로 큐를 구현

큐를 배열로 구현하는 경우, 큐에서 삽입과 삭제를 거듭하게 되면 큐의 Item들이 배열의 오른쪽 부분으로 편중되는 문제가 발생한다. 왜냐하면 새 item들은 뒤에서 삽입되고 삭제는 앞에서 일어나기 때문에, 앞에 빈 공간이 생기기 때문이다.

이 문제를 해결하는 방법들 중 하나는 큐의 item들을 배열의 앞부분으로 이동시키는 것이다. 그러나 이는 수행시간이 큐에 들어있는 item 수에 비례한다는 단점을 갖는다.

다른 방법으로, 배열을 원형으로, 즉 배열의 마지막 원소가 첫 원소와 맞닿아 있는 형태로 만드는 방법이 있다

배열의 앞뒤가 맞닿아 있다고 생각하기 위해 배열의 rear 다음의 비어 있는 원소의 인덱스는 `rear = (rear + 1)%N` 으로 계산한다. 여기서 N은 배열의 크기이다. 

큐가 연속적으로 삭제를 수행하여 큐가 Empty가 되는 상황을 가정해보자. 큐의 마지막 item을 삭제한 후에 큐가 Emptry임에도 rear는 item이 있었던 곳을 아직도 가리키고 있다. 

이를 해결하는 방법은 item을 삭제할 때마다 큐가 Empty가 되는지 검사하고, 만일 Empty가 되면, front = 0, rear = 0이 되도록 하는 것이다. 그러나 삭제할 때마다 Empty 조건을 검사하는 것은 프로그램의 수행의 효율성을 떨어뜨린다. 

삭제할 때마다 큐가 Empty인지 검사하지 않도록 하는 방법은 Front를 실제의 가장 앞에 있는 Item의 바로 앞의 비어있는 원소를 가리키게 하는 것이다. 즉 0번째 인덱스가 Front가 아닌 1번째 인덱스가 Front이다.

 따라서 배열의 크기가 N이라면 실제로 N-1개의 공간만 item들을 저장하는데 사용한다. 즉, 배열의 한 개 원소, 0번째 인덱스는 사용하지 않는다.

이렇게 되면 front = rear가 되며 큐의 초기상태와 같아진다.

### 수행시간

배열

- 배열로 구현한 add와 remove 연산은 각각 O(1)시간이 소요된다
- 배열 크기를 확대 또는 축소시키는 경우에 큐의 모든 item들을 새 배열로 복사해야하므로 O(N) 시간이 소요된다

단순 연결 리스트

- 단순 연결 리스트로 구현한 add와 remove 연산은 각각 O(1) 시간이 소요. 삽입 또는 삭제 연산이 rear와 front로 인해 연결리스트의 다른 노드들을 일일이 방문할 필요없이 각 연산이 수행되기 때문이다

### 예시

- CPU의 태스크 스케줄링(Task Scheduling)
- 다양한 이벤트 구동방식(Event-driven) 컴퓨터 시뮬레이션
- 콜 센터의 전화 서비스 처리

### 데크(Deque)

데크(Double-ended Queue, Deque)는 양쪽 끝에서 삽입과 삭제를 허용하는 자료구조이다. 스택과 큐 자료구조를 혼합한 자료구조라고 할 수 있다.

따라서 데크는 스택과 큐를 동시에 구현하는데 사용된다.

데크를 구현하는 경우에는 단순 연결리스트보다는 이중연결리스트가 더 적합한데, rear가 가리키는 노드의 이전 노드의 레퍼런스를 알아야 삭제가 가능하기 때문이다.

### 예시

- 스크롤(Scroll)
- 문서 편집기의 undo 연산
- 최근 방문된 웹 피이지 주소는 앞에 삽입하고, 일정 수의 새 주소들이 앞쪽에서 삽입되면 뒤에서 삭제가 수행된다