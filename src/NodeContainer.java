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


    public NodeContainer(){
        InputStream input = System.in;
        InputStreamReader reader = new InputStreamReader(input);
        BufferedReader br = new BufferedReader(reader);
    }

    public void closeStreams() throws IOException {

        InputStream input = System.in;
        InputStreamReader reader = new InputStreamReader(input);
        BufferedReader br = new BufferedReader(reader);

        this.input.close();
        this.reader.close();
        this.br.close();
    }

    void addNode() throws IOException {

        InputStream input = System.in;
        InputStreamReader reader = new InputStreamReader(input);
        BufferedReader br = new BufferedReader(reader);

        System.out.println("What is the property of this node?");

        String prop = br.readLine();
        Node newNode = new Node(prop);
        newNode.tail = null;

        if (head == null) {
            head = newNode;
            System.out.println("Node created");

            return;
        }

        Node current = head;
        while (current.tail != null) {
            current = current.tail;
        }
        current.tail = newNode;

        System.out.println("Node created");
    }

    public void printAllNodes() {
        Node current = head;
        System.out.println("====ALL NODES====");
        while (current != null) {
            System.out.println("Node " + current.getIndex() +" =>  Property: " + current.prop + " ");
            current = current.tail;
        }
    }

    public void searchNode() throws IOException, NullPointerException {

        InputStream input = System.in;
        InputStreamReader reader = new InputStreamReader(input);
        BufferedReader br = new BufferedReader(reader);

        System.out.println("What index are you looking for?");

        int indexChoice = Integer.parseInt(br.readLine());
        Node current = head;
        while (current.getIndex() != indexChoice) {
            current = current.tail;
        }
        System.out.println("You searched for the node with index " + indexChoice);
        System.out.println("Node Index: "+ current.getIndex() +" =>  Property: " + current.prop + " ");
    }

    public void removeLastNode(){
        Node current = head;
        Node previous = head;

        while(current.tail != null){
            previous = current;
            current = current.tail;
        }
        previous.tail = current.tail;
    }

    public class Node {

        private Node tail;
        private String prop;
        private int index;
        private static int nextIndex;

        public Node(String prop) {
            this.tail = tail;
            this.prop = prop;
            this.index = nextIndex++;
        }

        public int getIndex() {
            return index;
        }
    }
}

