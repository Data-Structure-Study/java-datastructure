package com.codesquad.datastructurestudy.queue.priorityqueue;

public class HeapImpl {

  private static final int HEAP_LEN = 100;
  private int[] heapArr;
  private int count;

  public HeapImpl() {
    this.heapArr = new int[HEAP_LEN];
    this.count = 0;
  }

  private int comparePriority(int data1, int data2) {
    if ((data2 - data1) > 0) {
      return 1;
    } else if ((data2 - data1) < 0) {
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

  public void insert(int data) {
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

  public int delete() {
    int data = heapArr[1];
    int lastElement = heapArr[this.count];

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
