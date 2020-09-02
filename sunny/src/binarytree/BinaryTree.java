package binarytree;
/*
        (1)
       /    \
    (2)     (3)
   /   \
(4)    (5)
*/

public class BinaryTree {
    public static void main(String[] args) {
        Tree t = new Tree();
        Node n4 = t.makeNode(null, 4, null);
        Node n5 = t.makeNode(null, 5, null);
        Node n2 = t.makeNode(n4, 2, n5);
        Node n3 = t.makeNode(null, 3, null);
        Node n1 = t.makeNode(n2, 1, n3);

        t.setRoot(n1);
        t.inOrder(t.getRoot());

        System.out.println();
        t.preOrder(t.getRoot());

        System.out.println();
        t.postOrder(t.getRoot());
    }
}
