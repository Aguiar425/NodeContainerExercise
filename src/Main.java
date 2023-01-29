import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        NodeContainer test = new NodeContainer();

        try {

            test.addNode();
            test.addNode();
            test.addNode();

            test.printAllNodes();

            test.removeLastNode();

            test.printAllNodes();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            test.searchNode();
        } catch (NullPointerException | IOException npe) {
            System.out.println("there isn't a node with that index");
        }finally {
            try {
                test.closeStreams();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
