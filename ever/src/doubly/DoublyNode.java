package doubly;

public class DoublyNode<E> {

    public DoublyNode<E> previousDoublyNode;

    public DoublyNode<E> nextDoublyNode;

    public E item;

    public DoublyNode(E item) {
        this(null, null, item);
    }

    public DoublyNode(DoublyNode<E> previousDoublyNode, DoublyNode<E> nextDoublyNode, E item) {
        this.previousDoublyNode = previousDoublyNode;
        this.nextDoublyNode = nextDoublyNode;
        this.item = item;
    }

    public void setPreviousDoublyNode(DoublyNode<E> previousDoublyNode) {
        this.previousDoublyNode = previousDoublyNode;
    }

    public void setNextDoublyNode(DoublyNode<E> nextDoublyNode) {
        this.nextDoublyNode = nextDoublyNode;
    }

    public void setItem(E item) {
        this.item = item;
    }
}
