package treepakage;

public class TreeExample {

    class Node{
        Node LeftNode;
        Node RightNode;
        Object data;
        Node(Object data){
            this.data = data;
        }
    }

    public Node makeRootNode(Object data, Node leftNode, Node rightNode){
        Node rootNode = new Node(data);
        rootNode.LeftNode = leftNode;
        rootNode.RightNode = rightNode;
        return rootNode;
    }

    public void preorder(Node root){
        if(root != null){
            System.out.println(root.data);
            preorder(root.LeftNode);
            preorder(root.RightNode);
        }
    }
    public void inorder(Node root){
        if(root != null){
            preorder(root.LeftNode);
            System.out.println(root.data);
            preorder(root.RightNode);
        }
    }

    public void postorder(Node root){
        if(root != null){
            preorder(root.LeftNode);
            preorder(root.RightNode);
            System.out.println(root.data);
        }
    }


    public static void main(String[] args) {

    }
}
