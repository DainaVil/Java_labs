package Task4;

public class Main {
    public static void main(String[] args) {
        var tree = new BinaryTree();
        tree.addNode(10);
        tree.addNode(5);
        tree.addNode(6);
        tree.addNode(0);
        tree.addNode(-5);
        tree.addNode(2);
        tree.addNode(1);
        tree.addNode(7);
        tree.addNode(11);

        System.out.println(tree.containsValue(-1));
        System.out.println(tree.containsValue(10));
        System.out.println(tree.containsValue(7));
    } 
}
