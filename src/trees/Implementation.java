package trees;

class Node {
    int data;
    Node left,right =null;
    Node(int data) {
        this.data=data;
    }
}

public class Implementation {

    public static void main(String[] args) {
        Node rootNode = createBinaryTree();
        Node node = new Node(55);
        System.out.println(contains(rootNode,node));
        Node node1 = new Node(13);
        insert(rootNode,node1);
        System.out.println("Inorder traversal of binary tree after adding 13:");
        inOrder(rootNode);

    }

    public static void inOrder(Node root) {
        if(root ==null) {
            return;
        }
        inOrder(root.left);
        System.out.println(root.data +" ");
        inOrder(root.right);
    }

    public static boolean contains(Node root, Node searchNode) {
        if(root == null) {
            return false;
        }
        if(root.data == searchNode.data) {
            return true;
        }
        boolean result = false;
        if(root.data > searchNode.data) {
            result = contains(root.left,searchNode);
        }
        else if(root.data < searchNode.data) {
            result = contains(root.right,searchNode);
        }
        return result;

    }

    public static Node insert(Node root, Node insertNode) {
        if(root ==null) {
            root = insertNode;
            return root;
        }
        if(root.data > insertNode.data) {
            if(root.left==null) {
                root.left = insertNode;
            }
            else {
                insert(root.left,insertNode);
            }
        }
        else if(root.data < insertNode.data) {
            if(root.right==null) {
                root.right = insertNode;
            }
            else {
                insert(root.right,insertNode);
            }

        }
        return root;

    }

    public static Node createBinaryTree() {
        Node rootNode = new Node(40);
        Node node20 = new Node(20);
        Node node10 = new Node(10);
        Node node30 = new Node(30);
        Node node60 = new Node(60);
        Node node50 = new Node(50);
        Node node70 = new Node(70);
        Node node5 = new  Node(5);
        Node node55 = new Node(55);
        insert(null,rootNode);
        insert(rootNode,node20);
        insert(rootNode,node10);
        insert(rootNode,node30);
        insert(rootNode,node60);
        insert(rootNode,node50);
        insert(rootNode,node70);
        insert(rootNode,node5);
        insert(rootNode,node55);
        return rootNode;
    }
}
