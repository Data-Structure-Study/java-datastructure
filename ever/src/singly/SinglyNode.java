package singly;

class SinglyNode<E> {

    public SinglyNode<E> nextSinglyNode;

    public E item;

    public SinglyNode(SinglyNode<E> nextSinglyNode, E item) {
        this.nextSinglyNode = nextSinglyNode;
        this.item = item;
    }

    public SinglyNode<E> getNextSinglyNode() {
        return nextSinglyNode;
    }

    public void setNextSinglyNode(SinglyNode<E> nextSinglyNode) {
        this.nextSinglyNode = nextSinglyNode;
    }

    public E getItem() {
        return item;
    }

    public void setItem(E item) {
        this.item = item;
    }
}
