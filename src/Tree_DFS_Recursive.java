
/**
 * Class holds logic to traverse tree with Depth First Search logic with three types of traversals
 * In order, Pre order and Post order
 *
 * @author Unmesh Chougule
 */
public class Tree_DFS_Recursive {

    public static void main(String[] args) {
/*

This is the input tree->

                  root
                   6
        2                    2
    5       9           7         4
                8
            11

 */

        Node root = createTree();

        System.out.println("in order");
        inOrderTraverse(root);
        System.out.println();
        System.out.println("----------------------------------");

        System.out.println("pre order");
        preOrderTraverse(root);
        System.out.println();
        System.out.println("----------------------------------");

        System.out.println("post order");
        postOrderTraverse(root);
    }

    //left root right
    public static void inOrderTraverse(Node node) {
        if (node == null) {
            return;
        }

        //check for left nodes
        inOrderTraverse(node.left);

        //print node
        System.out.print(node.data);
        System.out.print(" ");

        //check for right nodes
        inOrderTraverse(node.right);
    }

    //root left right
    public static void preOrderTraverse(Node node) {
        if (node == null) {
            return;
        }

        //print node
        System.out.print(node.data);
        System.out.print(" ");

        //left
        preOrderTraverse(node.left);

        //right
        preOrderTraverse(node.right);
    }

    //left right root
    public static void postOrderTraverse(Node node) {
        if (node == null) {
            return;
        }

        //left
        postOrderTraverse(node.left);

        //right
        postOrderTraverse(node.right);

        //print node
        System.out.print(node.data);
        System.out.print(" ");
    }

    public static Node createTree() {
        Node root = new Node(6);
        Node n1 = new Node(5);
        Node n2 = new Node(2);
        Node n3 = new Node(9);
        Node n4 = new Node(7);
        Node n5 = new Node(2);
        Node n6 = new Node(4);
        Node n7 = new Node(8);
        Node n8 = new Node(11);

        root.left = n2;
        n2.left = n1;
        n2.right = n3;
        n3.right = n7;
        n7.left = n8;

        root.right = n5;
        n5.left = n4;
        n5.right = n6;
/*

This is the input tree->

                  root
                   6
        2                    2
    5       9           7         4
                8
            11

 */
        return root;
    }
}

class Node {
    int data;
    Node right;
    Node left;

    Node(int data) {
        this.data = data;
    }
}
