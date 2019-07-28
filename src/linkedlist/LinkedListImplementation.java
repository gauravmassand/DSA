package linkedlist;

public class LinkedListImplementation {

     class Node {
        int data;
        Node next;
        Node(int data) {
            this.data =data;
        }
    }


    Node head = null;

    public static void main(String[] args) {
        LinkedListImplementation linkedListImplementation= new LinkedListImplementation();
       linkedListImplementation.insertNodeAtEnd(10);
        linkedListImplementation.insertNodeAtEnd(20);
       linkedListImplementation.insertNodeAtEnd(30);
        linkedListImplementation.insertNodeAtEnd(40);
        linkedListImplementation.insertAtBeginning(50);
        linkedListImplementation.insertAtPosition(3,60);
        /*o/p till this above step 50 19 60 20 30 40*/
        linkedListImplementation.deleteFromBeginning();
        linkedListImplementation.deleteLastNode();
        /*o/p till this above step 10 60 20 30 */
        linkedListImplementation.deleteAtPosition(3);
        /*o/p till this above step 10 60 30 */
        linkedListImplementation.printElementAtPosition(2);
        linkedListImplementation.printLinkedList();
    }

    private void insertNodeAtEnd(int data) {
        Node tmpNode = new Node(data);
        if(head == null) {
            head =tmpNode;
        }
        else {
            Node currentNode = head;
            while(currentNode.next!=null) {
                currentNode =currentNode.next;
            }
            currentNode.next=tmpNode;
        }
    }

    private void insertAtBeginning(int data) {
        Node tmpNode = new Node(data);
        if(head == null) {
            head=tmpNode;
        }
        else {
            tmpNode.next = head;
            head = tmpNode;
        }
    }

    private void insertAtPosition(int position,int data) {
        Node tmpNode = new Node(data);
        Node currentNode = head;
        int counter=1;
        while (counter<position-1 && currentNode.next!=null) {
            currentNode =currentNode.next;
            counter++;
        }
        tmpNode.next=currentNode.next;
        currentNode.next=tmpNode;
    }

    private void deleteFromBeginning() {
        if(head.next ==null) {
            head=null;
        }
        Node tmpNode = head.next;
        head =tmpNode;
    }

    private void deleteLastNode() {
        if(head.next ==null) {
            head=null;
        }
        if(head.next.next==null) {
            head.next=null;
        }
        Node currentNode = head;
        while(currentNode.next.next!=null) {
            currentNode =currentNode.next;
        }
        currentNode.next=null;
    }

    private void deleteAtPosition(int position) {
        Node currentNode = head;
        int counter=1;
        while (counter<position-1 && currentNode.next!=null) {
            currentNode=currentNode.next;
            counter++;
        }
        Node deleteNode =currentNode.next;
        currentNode.next=deleteNode.next;
    }

    private void printElementAtPosition(int position) {
        int counter =1;
        Node currentNode= head;
        while(counter<position && currentNode.next!=null) {
            currentNode=currentNode.next;
            counter++;
        }
        System.out.println("printElementAtPosition -> "+position+" "+currentNode.data);
    }


    private void printLinkedList() {
        Node currentNode =head;
        while (currentNode!=null) {
            System.out.println(currentNode.data);
            currentNode=currentNode.next;
        }
    }
}


