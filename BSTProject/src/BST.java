import java.lang.Comparable;

public class BST implements BSTInterface
{
    private TreeNode root;

    public BST(){
        root = null;
    }

    public void add(Comparable newVal){
        if(root == null){
            root = new TreeNode(newVal, null, null);
        } else if(newVal.compareTo(root.getValue()) <= 0){
            addHelper(newVal, root.getLeft(), root);
        } else {
            addHelper(newVal, root.getRight(), root);
        }
    }

    private void addHelper(Comparable val, TreeNode child, TreeNode parent){
        if(child == null){
            if(val.compareTo(parent.getValue()) <= 0){
                parent.setLeft(val);
            } else { 
                parent.setRight(val);
            }
        }
    }

}