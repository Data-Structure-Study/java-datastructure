package com.codesquad.datastructurestudy.queue.priorityqueue;

public class SimpleHeapImpl implements SimpleHeap {

  private static final int HEAP_LEN = 100;
  private HeapElement[] heapArr;
  private int count;

  public SimpleHeapImpl() {
    heapArr = new HeapElement[HEAP_LEN];
    this.count = 0;
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
    if (getLeftChildIndex(index) > count) {
      return 0;
    } else if (getLeftChildIndex(index) == count) {
      return getLeftChildIndex(index);
    } else {
      if (heapArr[getLeftChildIndex(index)].priority > heapArr[getRightChildIndex(index)].priority) {
        return getRightChildIndex(index);
      } else {
        return getLeftChildIndex(index);
      }
    }
  }

  public void insert(int data, int priority) {
    int index = count + 1;
    HeapElement he = new HeapElement(data, priority);

    while (index != 1) {
      if (priority < heapArr[getParentIndex(index)].priority) {
        heapArr[index] = heapArr[getParentIndex(index)];
        index = getParentIndex(index);
      } else {
        break;
      }
    }

    heapArr[index] = he;
    count++;
  }

  public int delete() {
    int data = heapArr[1].data;
    HeapElement lastHeapElement = heapArr[count];
    int parentIndex = 1;
    int childIndex = getHighPriorityChildIndex(parentIndex);
//    heapArr[parentIndex] = lastHeapElement;

    while (childIndex != 0) {
      if (lastHeapElement.priority <= heapArr[childIndex].priority) {
        break;
      }
      heapArr[parentIndex] = heapArr[childIndex];
      parentIndex = childIndex;
      childIndex = getHighPriorityChildIndex(parentIndex);
    }

    heapArr[parentIndex] = lastHeapElement;
    count--;
    return data;
  }

  private class HeapElement {
    private int data;
    private int priority;

    public HeapElement() {
      this.data = 0;
      this.priority = 0;
    }

    public HeapElement(int data, int priority) {
      this.data = data;
      this.priority = priority;
    }
  }
}
