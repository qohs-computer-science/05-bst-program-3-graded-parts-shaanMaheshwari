import java.lang.Comparable;

public class BST implements BSTInterface
{
    private TreeNode root;

    //main constructor
    public BST(){
        root = null;
    }


    //add method
    public void add(Comparable newVal){
        if(root == null){
            root = new TreeNode(newVal, null, null);
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
            } else { 
                parent.setRight(new TreeNode(val, null, null));
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
            inOrderHelper(child.getLeft());
            inOrderHelper(child.getRight());
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
            inOrderHelper(child.getLeft());
            inOrderHelper(child.getRight());
            System.out.print(" " + child.getValue());
        }
    }

    public int size(){
        return 0;
    }

    public boolean isEmpty(){
        return true;
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

    public boolean replace(Comparable old, Comparable toAdd){
        return true;
    }

    public boolean delete(Comparable old){
        return true;
    }
}