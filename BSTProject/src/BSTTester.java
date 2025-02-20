/*
 * TODO: Name
 * TODO: Date
 * TODO: Class Period
 * TODO: Program Description
 */

import java.lang.Comparable;

public class BSTTester {
  public static void main(String[] args) {

    BST searchTree = new BST();

    searchTree.add("O");
    searchTree.add("R");
    searchTree.add("C");
    searchTree.add("H");
    searchTree.add("A");
    searchTree.add("R");
    searchTree.add("D");
    searchTree.add("Q");
    searchTree.add("U");
    searchTree.add("I");
    searchTree.add("N");
    searchTree.add("C");
    searchTree.add("E");

    System.out.print("In order: ");
    searchTree.printInOrder();

    System.out.print("Pre order: ");
    searchTree.printPreOrder();

    System.out.print("Post order: ");
    searchTree.printPostOrder();
  }
}