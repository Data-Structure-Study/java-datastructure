## 스택(Stack)

한 쪽 끝에서만 항목을 삭제하거나 새로운 Item을 저장하는 자료 구조

LIFO(Last-In, First-Out)

- 만일 스택을 단순 연결 리스트로 구현하면, top은 스택의 가장 위에 있는 item을 참조하는 레퍼런스이고, 스택이 Empty일 때 top = null 이다

## 기능

- push() : 삽입
- pop() : 삭제
- peek() : 가장 위의 저장되어 있는 Item(Top) 을 읽는다
- isEmpty() : size == 0

### 예시

- 인터넷 브라우저에서 이전 웹 페이지로 돌아가는 버튼
- 문서를 수정하기 위한 CTRL - Z 버튼
- 컴파일러의 괄호 짝 맞추기
- 회문(Palindrome, 거꾸로 읽어도 제대로 읽는 것과 같은 문장이나 낱말. ex. rotator) 검사
- 후위 표기법(Postfix Notation) 수식 계산하기
- 미로 찾기
- 트리의 방문
- 그래프의 깊이 우선탐색
- 함수(메소드) 호출 및 재귀호출

### 수행시간

배열로 스택 구현

- push와 pop 연산은 각각 O(1) 시간
- 배열 크기를 확대 또는 축소시크는 경우에 스택의 모든 item들을 새 배열로 복사해야 하므로 O(N) 시간이 소요

Singly Linked List  로 구현한 스택

- push와 pop 연산은 각각 O(1) 시간. 앞 부분에서 노드를 삽입하거나 삭제하기 때문

배열과 리스트로 구현한 스택의 장단점은 리스트를 배열과 단순연결리스트로 구현하였을 때의 장단점과 같다

### Array Stack 과 List Stack의 차이점

`Array` 기반 스택은 접근 속도가 빠르지만 변경이 용이하지 않습니다. 배열은 생성할 때, 메모리의 연속된 공간에 데이터를 저장합니다. 그렇기 때문에 검색할 때는 데이터를 빠르게 찾을 수 있지만, 변경이 일어났을 때는 새로운 배열을 생성하고, 생성된 배열에 데이터를 복사해야하기 때문에 느려집니다. 복사해야할 데이터가 많지 않다면, 크게 상관 없지만 데이터가 많아질수록 점점 더 느려질 것입니다.

반면에 `Linked List` 기반 스택은 메모리 주소를 통해 노드가 연결되어 있어, 가르키는 메모리 주소만 변경하면 되므로, 등록, 수정과 같은 변경에는 빠르게 반응할 수 있습니다. 하지만, 메모리에 연속된 공간에 존재하지 않기 때문에 검색 데이터를 찾기 위해 노드를 순회해야하므로 검색 속도는 좋지 않습니다.

```java
// Item 들이 저장되는 위치가 다르다
// 배열은 오른쪽부터, 리스트는 왼쪽부터

apple  < top
apple orange  < top
apple orange cherry  < top
apple orange cherry pear  < top
apple orange cherry  < top
apple orange  < top
apple  < top

 ============= List Stack =============

 top > apple 
 top > orange apple 
 top > cherry orange apple 
 top > pear cherry orange apple 
 top > cherry orange apple 
 top > orange apple 
 top > apple 

```