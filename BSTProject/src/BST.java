import java.lang.Comparable;

public class BST implements BSTInterface
{
    private TreeNode root;
    public int counter;

    //main constructor
    public BST(){
        root = null;
    }//end constructor


    //add method
    public void add(Comparable newVal){
        if(root == null){
            root = new TreeNode(newVal, null, null);
            counter++;
        } else if(newVal.compareTo(root.getValue()) <= 0){
            addHelper(newVal, root.getLeft(), root);
        } else {
            addHelper(newVal, root.getRight(), root);
        }//end if else if else
    }//end method


    //add helper function
    private void addHelper(Comparable val, TreeNode child, TreeNode parent){
        if(child == null){
            if(val.compareTo(parent.getValue()) <= 0){
                parent.setLeft(new TreeNode(val, null, null));
                counter++;
            } else { 
                parent.setRight(new TreeNode(val, null, null));
                counter++;
            }//end if else
        } else {
            if(val.compareTo(child.getValue()) <= 0){
                addHelper(val, child.getLeft(), child);
            } else {
                addHelper(val, child.getRight(), child);
            }//end if else
        }//end if else
    }//end helper



    //in order traversal
    public void printInOrder(){
        if(root != null){
            inOrderHelper(root.getLeft());
            System.out.print(root.getValue());
            inOrderHelper(root.getRight());
        }//end if
    }//end method

    private void inOrderHelper(TreeNode child){
        if(child != null){
            inOrderHelper(child.getLeft());
            System.out.print(" " + child.getValue());
            inOrderHelper(child.getRight());
        }//end if
    }//end method


    //pre order traversal
    public void printPreOrder(){
        if(root != null){
            System.out.print(root.getValue());
            preOrderHelper(root.getLeft());
            preOrderHelper(root.getRight());
        }//end if
    }//end method

    private void preOrderHelper(TreeNode child){
        if(child != null){
            System.out.print(" " + child.getValue());
            preOrderHelper(child.getLeft());
            preOrderHelper(child.getRight());
        }//end if
    }//end method


    //post order traversal
    public void printPostOrder(){
        if(root != null){
            postOrderHelper(root.getLeft());
            postOrderHelper(root.getRight());
            System.out.print(root.getValue());
        }//end if
    }//end method

    private void postOrderHelper(TreeNode child){
        if(child != null){
            postOrderHelper(child.getLeft());
            postOrderHelper(child.getRight());
            System.out.print(" " + child.getValue());
        }//end if
    }//end method


    //size method
    public int size(){
        return counter;
    }//end method

    //check if empty
    public boolean isEmpty(){
        if(root == null){
            return true;
        } else {
            return false;
        }//end if else
    }//end method


    //find method
    public boolean find(Comparable toFind){
        if(root == null){
            return false;
        } else {
            if(toFind.compareTo(root.getValue()) == 0){
                return true;
            } else if(toFind.compareTo(root.getValue()) <= 0){
                return findHelper(toFind, root.getLeft());
            } else{
                return findHelper(toFind, root.getRight());
            }//end if else if ekse
        }//end if else
    }//end method

    private boolean findHelper(Comparable val, TreeNode child){
        if(child == null){
            return false;
        } else {
            if(val.compareTo(child.getValue()) == 0){
                return true;
            } else if(val.compareTo(child.getValue()) <= 0){
                return findHelper(val, child.getLeft());
            } else {
                return findHelper(val, child.getRight());
            }//end if else if else
        }//end if else
    }//end helper


    //replace method
    public boolean replace(Comparable old, Comparable toAdd){
        if(find(old) == true){
            delete(old);
            add(toAdd);
            return true;
        } else {
            return false;
        }//end if else
    }//end method
     

    public boolean delete(Comparable old){
        if(root == null){
            return false;
        } else { 
            if(old.compareTo(root.getValue()) == 0){
                deleteRoot();
                return true;
            } else {
                if(old.compareTo(root.getValue()) <= 0){
                    if(root.getLeft() == null){
                        return false;
                    } else {
                        if(old.compareTo(root.getLeft().getValue()) == 0){
                            deleteSide(root, root.getLeft(), true);
                            return true;
                        } else {
                            return deleteHelper(old, root.getLeft());
                        }//end if else
                    }//end if else
                } else {
                    if(root.getRight() == null){
                        return false;
                    } else {
                        if(old.compareTo(root.getRight().getValue()) == 0){
                            deleteSide(root, root.getRight(), false);
                            return false;
                        } else {
                            return deleteHelper(old, root.getRight());
                        }//end if else
                    }//end if else
                }//end if else
            }//end if else
        }//end if else
    }//end method


    private boolean deleteHelper(Comparable val, TreeNode child){
        if(val.compareTo(child.getValue()) <= 0){
            if(child.getLeft() == null){
                return false;
            } else {
                if(val.compareTo(child.getLeft().getValue()) == 0){
                    deleteSide(child, child.getLeft(), true);
                    return true;
                } else {
                    return deleteHelper(val, child.getLeft());
                }//end if else
            }//end if else
        } else {
            if(child.getRight() == null){
                return false;
            } else {
                if(val.compareTo(child.getRight().getValue()) == 0){
                    deleteSide(child, child.getRight(), false);
                    return true;
                } else {
                    return deleteHelper(val, child.getRight());
                }//end if else
            }//nd if else
        }//end if else
    }//end helper #1


    private void deleteSide(TreeNode parent, TreeNode child, boolean isLeft){
        if(child.getLeft() == null){
            if(child.getRight() == null){
                if (isLeft == true){
                    parent.setLeft(null);
                } else {
                    parent.setRight(null);
                }//end if else
            } else {
                if (isLeft == true) {
                    parent.setLeft(child.getRight());
                    child.setRight(null);
                } else {
                    parent.setRight(child.getRight());
                    child.setRight(null);
                }//end if else
            }//end if else
        } else {
            if(child.getRight() == null){
                if (isLeft == true) {
                    parent.setLeft(child.getRight());
                    child.setLeft(null);
                } else {
                    parent.setRight(child.getRight());
                    child.setLeft(null);
                }//end if else
            } else {
                TreeNode temp = child.getLeft();
                while(temp.getRight() != null){
                    temp = temp.getRight();
                }//end while
                temp.setRight(child.getRight());
                if(isLeft){
                    parent.setLeft(child.getLeft());
                } else {
                    parent.setRight(child.getLeft());
                }//end if else
                child.setLeft(null);
                child.setRight(null);
            }//end if else
        }//end if else
    }//end helper #2


    private void deleteRoot(){
        if(root.getLeft() == null){
            if(root.getRight() == null){
                root = null;
            } else {
                root =  root.getRight();
            }//end if else
        } else {
            if(root.getRight() == null){
                root = root.getLeft();
            } else {
                TreeNode temp = root.getLeft();
                while(temp.getRight() != null){
                    temp = temp.getRight();
                }//end while
                temp.setRight(root.getRight());

                root = root.getLeft();
            }//end if else
        }//end if else
    }//end helper #3
}//end class