public class Node {
    Object value;
    Node nextNode;
    Node(Object value) {
        this.value = value;
    }
    Node(Object value, Node nextNode) {
        this.value = value;
        this.nextNode = nextNode;
    }
    Node() {
    }
}
