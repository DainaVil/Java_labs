package Task4;

public class BinaryTree {

     Node root; // первый узел

     private Node addSideNode(Node currNode, int value) {
          if (currNode == null) {
               return new Node(value);
          }

          // рекурсивное добавление узлов слева или справа
          if (value < currNode.value) {
               currNode.left = addSideNode(currNode.left, value);
          } else if (value > currNode.value) {
               currNode.right = addSideNode(currNode.right, value);
          } else {
               return currNode;
          }
          return currNode;
     }

     // рекурсивный поиск
     private boolean searchTree(Node currNode, int value) {

          // предусматриваем выход из рекурсивного поиска
          if (currNode == null) {
               return false;
          }

          if (value == currNode.value) {
               return true;
          }
          if (value < currNode.value) {
               return searchTree(currNode.left, value);
          } else {
               return searchTree(currNode.right, value);
          }
     }

     public void addNode(int value) {
          root = addSideNode(root, value);
     }

     public boolean containsValue(int value) {
          return searchTree(root, value);
     }

     // Дочерний класс - узел бин.дерева
     public class Node {

          int value;
          // правый и левый узлы
          Node left;
          Node right;

          Node(int value) {
               this.value = value;
               this.right = null;
               this.left = null;
          }
     }
}
