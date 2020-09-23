import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Binary Search Tree starter code
 *
 * @author Nathan Lin
 * @version Sept 21, 2019
 */


public class BST {
    private Node root;

    public BST() {
        this.root = null;
    }

    // Recursively searches the tree for val
    private static boolean searchRec(int val, Node current) {
        if (current == null)
            return false;
        if (val == current.data)
            return true;
        if (val < current.data)
            current = current.left;
        else
            current = current.right;
        return searchRec(val, current);
    }

    // Prints out an inorder traversal of the tree:
    // Left, root, right
    public static void inOrderTraversal(Node node) {

    }

    // Prints out an preorder traversal of the tree:
    // Root, left right
    public static void preOrderTraversal(Node node) {

    }

    // Prints out an postOrder traversal of the tree:
    // Left, right root
    public static void postOrderTraversal(Node node) {

    }

    public static void main(String[] args) {
        // Test 1: Test iterative search
        System.out.println("Test 1: Iterative Search");
        BST bst = new BST();
        Node node10 = new Node(10);
        Node node2 = new Node(2);
        Node node5 = new Node(5);
        Node node7 = new Node(7);
        Node node3 = new Node(3);
        Node node6 = new Node(6);
        Node node11 = new Node(11);
        Node node13 = new Node(13);
        Node node12 = new Node(12);

        bst.root = node7;
        node7.left = node3;
        node3.left = node2;
        node3.right = node6;
        node6.left = node5;
        node7.right = node10;
        node10.right = node12;
        node12.left = node11;
        node12.right = node13;

        for (int i = 0; i < 15; i += 2) {
            System.out.println(bst.search(i));
        }
        // false
        // true
        // false
        // true
        // false
        // true
        // true
        // false

        // Test 2: Test recursive search
        System.out.println("\nTest 2: Recursive Search");
        for (int i = 0; i < 15; i += 2) {
            System.out.println(searchRec(i, bst.root));
        }
        // false
        // true
        // false
        // true
        // false
        // true
        // true
        // false


        // Test 3: Insert some nodes
        System.out.println("\nTest 3:");
        BST integerBST = new BST();
        integerBST.insert(4);
        integerBST.insert(7);
        integerBST.insert(3);
        integerBST.insert(8);
        BTreePrinter.printNode(integerBST.root);
        //    4
        //   / \
        //  /   \
        //  3   7
        //       \
        //       8

        // Test 4: Inorder traversal (and other optional traversals)
        System.out.println("\nTest 4:");
        inOrderTraversal(integerBST.root);
        // 3
        // 4
        // 7
        // 8

//        System.out.println();
//        preOrderTraversal(integerBST.root);
//        // 4
//        // 3
//        // 7
//        // 8
//
//        System.out.println();
//        postOrderTraversal(integerBST.root);
//        // 3
//        // 8
//        // 7
//        // 4


        // Test 5: Delete a leaf
        System.out.println("\nTest 5:");
        integerBST.insert(9);
        BTreePrinter.printNode(integerBST.root);
        //        4
        //       / \
        //      /   \
        //     /     \
        //    /       \
        //    3       7
        //             \
        //              \
        //              8
        //               \
        //               9

        integerBST.delete(9);
        BTreePrinter.printNode(integerBST.root);
        //    4
        //   / \
        //  /   \
        //  3   7
        //       \
        //       8

        // Test 6: Delete a node with one child
        System.out.println("\nTest 6:");
        integerBST.insert(9);
        BTreePrinter.printNode(integerBST.root);
        //        4
        //       / \
        //      /   \
        //     /     \
        //    /       \
        //    3       7
        //             \
        //              \
        //              8
        //               \
        //               9

        integerBST.delete(8);
        BTreePrinter.printNode(integerBST.root);
        //    4
        //   / \
        //  /   \
        //  3   7
        //       \
        //       9

        // Test 7: Delete a node with two children
        System.out.println("Test 7:");
        integerBST.insert(6);
        BTreePrinter.printNode(integerBST.root);
        //    4
        //   / \
        //  /   \
        //  3   7
        //     / \
        //     6 9

        integerBST.delete(6);
        BTreePrinter.printNode(integerBST.root);
        //
        //    4
        //   / \
        //  /   \
        //  3   7
        //       \
        //       9

    }

    // Searches the bst for the given value
    public boolean search(int val) {
        Node current = root;

        while (current != null) {
            if (val == current.data)
                return true;
            if (val < current.data)
                current = current.left;
            else
                current = current.right;
        }
        return false;
    }

    // Inserts val into the BST
    private void insert(int val) {
        Node v = new Node(val);
        if (root == null) {
            root = v;
        }
        Node current = root;

        while (current != null) {
            if (val == current.data)
                break;
            if (val < current.data)
                if (current.left == null)
                    current.left = v;
                else
                    current = current.left;
            else if (current.right == null)
                current.right = v;
            else
                current = current.right;
        }
    }

    // Deletes val from the BST
    public void delete(int val) {
        /*Node current = root;
        while (current != null) {
            if (val < current.data) {
                if (current.left.data == val) {
                    insert(current.left.left.data);
                    insert(current.left.right.data);
                }
                current = current.left;
            }

            else {
                if (current.left.data == val) {
                    insert(current.right.left.data);
                    insert(current.right.right.data);
                }
                current = current.right;
            }
        }
        */
    }


}

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

// Print binary tree in a helpful way
// from: https://stackoverflow.com/questions/4965335/how-to-print-binary-tree-diagram
class BTreePrinter {

    public static <T extends Comparable<?>> void printNode(Node root) {
        int maxLevel = BTreePrinter.maxLevel(root);

        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static <T extends Comparable<?>> void printNodeInternal(List<Node> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || BTreePrinter.isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        BTreePrinter.printWhitespaces(firstSpaces);

        List<Node> newNodes = new ArrayList<Node>();
        for (Node node : nodes) {
            if (node != null) {
                System.out.print(node.data);
                newNodes.add(node.left);
                newNodes.add(node.right);
            }
            else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            BTreePrinter.printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                BTreePrinter.printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    BTreePrinter.printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).left != null)
                    System.out.print("/");
                else
                    BTreePrinter.printWhitespaces(1);

                BTreePrinter.printWhitespaces(i + i - 1);

                if (nodes.get(j).right != null)
                    System.out.print("\\");
                else
                    BTreePrinter.printWhitespaces(1);

                BTreePrinter.printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static <T extends Comparable<?>> int maxLevel(Node node) {
        if (node == null)
            return 0;

        return Math.max(BTreePrinter.maxLevel(node.left), BTreePrinter.maxLevel(node.right)) + 1;
    }

    private static <T> boolean isAllElementsNull(List<T> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }

}