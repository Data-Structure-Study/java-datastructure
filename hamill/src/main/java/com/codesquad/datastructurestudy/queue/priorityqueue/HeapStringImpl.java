package com.codesquad.datastructurestudy.queue.priorityqueue;

public class HeapStringImpl {

  private static final int HEAP_LEN = 100;
  private String[] heapArr;
  private int count;

  public HeapStringImpl() {
    this.heapArr = new String[HEAP_LEN];
    this.count = 0;
  }

  private int comparePriority(String data1, String data2) {
    int num1 = data1.length();
    int num2 = data2.length();

    if ((num2 - num1) > 0) {
      return 1;
    } else if ((num2 - num1) < 0) {
      return -1;
    }
    return 0;
  }

  public boolean isEmpty() {
    if (this.count == 0) {
      return true;
    }
    return false;
  }

  public int getParentIndex(int index) {
    return index / 2;
  }

  public int getLeftChildIndex(int index) {
    return index * 2;
  }

  public int getRightChildIndex(int index) {
    return getLeftChildIndex(index) + 1;
  }

  public int getHighPriorityChildIndex(int index) {
    if (getLeftChildIndex(index) > this.count) {
      return 0;
    } else if (getLeftChildIndex(index) == this.count) {
      return getLeftChildIndex(index);
    } else {
      if (comparePriority(heapArr[getLeftChildIndex(index)], heapArr[getRightChildIndex(index)]) < 0) {
        return getRightChildIndex(index);
      } else {
        return getLeftChildIndex(index);
      }
    }
  }

  public void insert(String data) {
    int index = this.count + 1;

    while (index != 1) {
      if (comparePriority(data, heapArr[getParentIndex(index)]) > 0) {
        heapArr[index] = heapArr[getParentIndex(index)];
        index = getParentIndex(index);
      } else {
        break;
      }
    }

    heapArr[index] = data;
    this.count++;
  }

  public String delete() {
    String data = heapArr[1];
    String lastElement = heapArr[this.count];

    int parentIndex = 1;
    int childIndex = getHighPriorityChildIndex(parentIndex);

    while (childIndex != 0) {
      if (comparePriority(lastElement, heapArr[childIndex]) >= 0) {
        break;
      }
      heapArr[parentIndex] = heapArr[childIndex];
      parentIndex = childIndex;
      childIndex = getHighPriorityChildIndex(parentIndex);
    }

    heapArr[parentIndex] = lastElement;
    this.count--;
    return data;
  }
}
