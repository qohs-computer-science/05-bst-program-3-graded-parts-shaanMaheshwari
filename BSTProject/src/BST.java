import java.lang.Comparable;

public class BST implements BSTInterface
{
    private TreeNode root;
    public int counter;

    //main constructor
    public BST(){
        root = null;
    }


    //add method
    public void add(Comparable newVal){
        if(root == null){
            root = new TreeNode(newVal, null, null);
            counter++;
        } else if(newVal.compareTo(root.getValue()) <= 0){
            addHelper(newVal, root.getLeft(), root);
        } else {
            addHelper(newVal, root.getRight(), root);
        }
    }


    //add helper function
    private void addHelper(Comparable val, TreeNode child, TreeNode parent){
        if(child == null){
            if(val.compareTo(parent.getValue()) <= 0){
                parent.setLeft(new TreeNode(val, null, null));
                counter++;
            } else { 
                parent.setRight(new TreeNode(val, null, null));
                counter++;
            }
        } else {
            if(val.compareTo(child.getValue()) <= 0){
                addHelper(val, child.getLeft(), child);
            } else {
                addHelper(val, child.getRight(), child);
            }
        }
    }



    //in order traversal
    public void printInOrder(){
        if(root != null){
            inOrderHelper(root.getLeft());
            System.out.print(root.getValue());
            inOrderHelper(root.getRight());
        }
    }

    private void inOrderHelper(TreeNode child){
        if(child != null){
            inOrderHelper(child.getLeft());
            System.out.print(" " + child.getValue());
            inOrderHelper(child.getRight());
        }
    }


    //pre order traversal
    public void printPreOrder(){
        if(root != null){
            System.out.print(root.getValue());
            preOrderHelper(root.getLeft());
            preOrderHelper(root.getRight());
        }
    }

    private void preOrderHelper(TreeNode child){
        if(child != null){
            System.out.print(" " + child.getValue());
            preOrderHelper(child.getLeft());
            preOrderHelper(child.getRight());
        }
    }


    //post order traversal
    public void printPostOrder(){
        if(root != null){
            postOrderHelper(root.getLeft());
            postOrderHelper(root.getRight());
            System.out.print(root.getValue());
        }
    }

    private void postOrderHelper(TreeNode child){
        if(child != null){
            postOrderHelper(child.getLeft());
            postOrderHelper(child.getRight());
            System.out.print(" " + child.getValue());
        }
    }


    //size method
    public int size(){
        return counter;
    }

    //check if empty
    public boolean isEmpty(){
        if(root == null){
            return true;
        } else {
            return false;
        }
    }


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
            }
        }
    }

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
            }
        }
    }


    //replace method
    public boolean replace(Comparable old, Comparable toAdd){
        if(find(old) == true){
            delete(old);
            add(toAdd);
            return true;
        } else {
            return false;
        }
    }
     

    public boolean delete(Comparable old){
        if(root == null){
            return false;
        } else { 
            if(old.compareTo(root.getValue()) == 0){
                deleteRoot(root);
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
                        }
                    }
                } else {
                    if(root.getRight() == null){
                        return false;
                    } else {
                        if(old.compareTo(root.getRight().getValue()) == 0){
                            deleteSide(root, root.getRight(), false);
                            return false;
                        } else {
                            return deleteHelper(old, root.getRight());
                        }
                    }
                }
            }
        }
    }


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
                }
            }
        } else {
            if(child.getRight() == null){
                return false;
            } else {
                if(val.compareTo(child.getRight().getValue()) == 0){
                    deleteSide(child, child.getRight(), true);
                    return true;
                } else {
                    return deleteHelper(val, child.getRight());
                }
            }
        }
    }


    private void deleteSide(TreeNode parent, TreeNode child, boolean isLeft){
        if(parent.getLeft() == null){
            if(parent.getRight() == null){
                if (isLeft == true){
                    parent.setLeft(null);
                } else {
                    parent.setRight(null);
                }
            } else {
                if (isLeft == true) {
                    parent.setLeft(child.getRight());
                    child.setRight(null);
                } else {
                    parent.setRight(child.getRight());
                    child.setRight(null);
                }
            }
        } else {
            if(child.getRight() == null){
                if (isLeft == true) {
                    parent.setLeft(child.getRight());
                    child.setLeft(null);
                } else {
                    parent.setRight(child.getRight());
                    child.setLeft(null);
                }
            } else {
                TreeNode temp = child.getLeft();
                while(temp.getRight() != null){
                    temp = temp.getRight();
                }
                temp.setRight(child.getRight());
            }
        }
    }


    private void deleteRoot(TreeNode root){
        if(root.getLeft() == null){
            if(root.getRight() == null){
                root.setValue(null);
            } else {
                root =  root.getRight();
            }
        } else {
            if(root.getRight() == null){
                root = root.getLeft();
            } else {
                TreeNode temp = root.getLeft();
                while(temp.getRight() != null){
                    temp = temp.getRight();
                }
                temp.setRight(root.getRight());

                root = root.getLeft();
            }
        }
    }
}