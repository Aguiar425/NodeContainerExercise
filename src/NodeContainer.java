import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class NodeContainer {

    Node head;
    Node tail;
    private InputStream input;
    private InputStreamReader reader;
    private BufferedReader br;
    int nodeContainerSize;

    public NodeContainer() {
        this.input = System.in;
        this.reader = new InputStreamReader(input);
        this.br = new BufferedReader(reader);
    }

    public Node getNodeContainerSize(int index) {
        Node current = head;
        for (int i = 0; i < nodeContainerSize + 1; i++) {
            if (i != index) {
                current = current.next;
            }
            return current;
        }
        return null;
    }

    public void closeStreams() throws IOException {
        this.input.close();
        this.reader.close();
        this.br.close();
    }

    void addNode() throws IOException {

        System.out.println("What is the property of this node?");

        String prop = this.br.readLine();
        Node newNode = new Node(prop);
        nodeContainerSize++;

        newNode.next = null;

        if (head == null) {
            head = newNode;
            System.out.println("Node created");
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        System.out.println("Node created");
    }

    void addNodeInPosition() throws IOException {
        System.out.println("What is the property of this node?");
        String prop = this.br.readLine();

        System.out.println("In what position do you want to insert this Node?");
        int indexPosition = Integer.parseInt(this.br.readLine());

        Node newNode = new Node(prop);
        nodeContainerSize++;

        if (indexPosition > nodeContainerSize) {
            System.out.println("That's out of bounds. \n");
            addNodeInPosition();
        }
        Node current = getNodeContainerSize(indexPosition - 1);
        newNode.next = current.next;
        current.next = newNode;

        System.out.println("Node created");
    }

    public void printAllNodes() {
        Node current = head;
        System.out.println("====ALL NODES====");
        while (current != null) {
            System.out.println(current.prop);
            current = current.next;
        }
    }

    public void searchNode() throws IOException, NullPointerException, NumberFormatException {
        try {
            System.out.println("What index are you looking for?");
            int indexChoice = Integer.parseInt(this.br.readLine());

            System.out.println(getNodeContainerSize(indexChoice - 1).prop);
        } catch (NumberFormatException nfe) {
            System.out.println("Please insert a valid index");
            searchNode();
        }
    }

    public void removeLastNode() {
        Node current = head;
        Node previous = head;

        while (current.next != null) {
            previous = current;
            current = current.next;
        }
        previous.next = current.next;

    }

    public class Node {

        private Node next;
        private String prop;

        public Node(String prop) {
            this.prop = prop;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}