package trees;

import java.util.LinkedList;
import java.util.Queue;

public class TreeTraversals {
    public static void main(String[] args) {
        Node root =createBinaryTree();
        System.out.println("inorder-");
        inOrder(root);
        System.out.println("preorder-");
        preOrder(root);
        System.out.println("postorder");
        postOrder(root);
        System.out.println("levelorder");
        levelOrder(root);

    }

    public static void inOrder(Node rootNode) {
        if(rootNode!=null) {
            inOrder(rootNode.left);
            System.out.println(rootNode.data);
            inOrder(rootNode.right);
        }

    }

    public static void preOrder(Node rootNode) {
        if(rootNode!=null) {
            System.out.println(rootNode.data);
            preOrder(rootNode.left);
            preOrder(rootNode.right);
        }
    }

    public static void postOrder(Node rootNode) {
        if(rootNode!=null) {
            postOrder(rootNode.left);
            postOrder(rootNode.right);
            System.out.println(rootNode.data);
        }
    }

    public static void levelOrder(Node rootNode) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(rootNode);
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            System.out.println(currentNode.data);
            if(currentNode.left!=null) {
                queue.add(currentNode.left);
            }
            if(currentNode.right!=null) {
                queue.add(currentNode.right);
            }
        }
    }

    public static Node createBinaryTree()
    {

        Node rootNode =new Node(40);
        Node node20=new Node(20);
        Node node10=new Node(10);
        Node node30=new Node(30);
        Node node60=new Node(60);
        Node node50=new Node(50);
        Node node70=new Node(70);

        rootNode.left=node20;
        rootNode.right=node60;

        node20.left=node10;
        node20.right=node30;

        node60.left=node50;
        node60.right=node70;

        return rootNode;
    }
}
