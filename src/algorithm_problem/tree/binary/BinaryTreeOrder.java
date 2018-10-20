package algorithm_problem.tree.binary;

import java.util.ArrayList;
import java.util.List;
import algorithm_problem.tree.TreeNode;

public class BinaryTreeOrder {

    List<Integer> ret;

    public List<Integer> inorderTraversal(TreeNode root){
        ret = new ArrayList<Integer>();
        iTraverse(root);
        return ret;
    }

    public List<Integer> preorderTraversal(TreeNode root){
        ret = new ArrayList<>();
        preTraverse(root);
        return ret;
    }


    public List<Integer> postorderTraversal(TreeNode root){
        ret = new ArrayList<>();
        postTraverse(root);
        return ret;
    }

    public void iTraverse(TreeNode self){
        if(self == null) return;
        iTraverse(self.leftNode);
        ret.add(self.getData());
        iTraverse(self.rightNode);
    }



    public void preTraverse(TreeNode self){
        if(self == null) return ;
        ret.add(self.getData());
        preTraverse(self.leftNode);
        preTraverse(self.rightNode);
    }

    public void postTraverse(TreeNode self){
        if(self == null) return;
        postTraverse(self.leftNode);
        postTraverse(self.rightNode);
        ret.add(self.getData());
    }


}
