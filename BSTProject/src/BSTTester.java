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
    System.out.println("");


    System.out.print("Pre order: ");
    searchTree.printPreOrder();
    System.out.println("");


    System.out.print("Post order: ");
    searchTree.printPostOrder();
    System.out.println("");


    System.out.print("Found? ");
    System.out.println(searchTree.find("A"));


    System.out.print("Found? ");
    System.out.println(searchTree.find("B"));


    System.out.print("Empty? ");
    System.out.println(searchTree.isEmpty());


    System.out.println("Size: " + searchTree.size());


    System.out.println("Delete O: " + searchTree.delete("O"));
    System.out.print("In order: ");
    searchTree.printInOrder();
    System.out.println("");
    System.out.print("Pre order: ");
    searchTree.printPreOrder();
    System.out.println("");
    System.out.print("Post order: ");
    searchTree.printPostOrder();
    System.out.println("");


    System.out.println("Delete R: " + searchTree.delete("R"));
    System.out.print("In order: ");
    searchTree.printInOrder();
    System.out.println("");
    System.out.print("Pre order: ");
    searchTree.printPreOrder();
    System.out.println("");
    System.out.print("Post order: ");
    searchTree.printPostOrder();
    System.out.println("");


    System.out.println("Delete A: " + searchTree.delete("A"));
    System.out.print("In order: ");
    searchTree.printInOrder();
    System.out.println("");
    System.out.print("Pre order: ");
    searchTree.printPreOrder();
    System.out.println("");
    System.out.print("Post order: ");
    searchTree.printPostOrder();
    System.out.println("");

  }
}
