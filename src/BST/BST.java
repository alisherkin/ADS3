package BST;

import java.util.Stack;

public class BST<K extends Comparable<? super K>, V> {

    public Node root;
    public char prefixChar;
    public int size = 0;
    private class Node{
        private K key;
        private V value;
        public Node left, right;
        public Node(K key, V value){
            this.key = key;
            this.value = value;
        }

        public boolean isEmpty() {
            return root.isEmpty();
        }

        public boolean haLeft() {
            return !left.isEmpty();
        }
        public boolean hasRight(){
            return !right.isEmpty();
        }
        public void setKey(K key){key = key;}
        public void setValue(V value){value = value;}
        public void setLeft(Node l){
            left = l;
        }
        public void setRight(Node r){
            right = r;
        }
    }

    public void put(K key, V value) {
        Node input = new Node(key, value);
        if (root == null){
            root = input;
            size++;
        } else {
            Node temp = root;
            Node prev = null;
            while (temp != null) {
                prev = temp;
                if ((key.compareTo(temp.key)) > 0){
                    temp = temp.right;
                } else {
                    temp = temp.left;
                }
            }
            if (key.compareTo(prev.key) < 0) {
                prev.left = input;
            } else {
                prev.right = input;
            }
            size++;
        }



    }
    //find node by key
    public V get(K key){
        Node currNode = root;//start search from root point
        while (currNode.key != key) {
            //use compare to from comparable because of generics
            if (key.compareTo(currNode.key) < 0){
                currNode = currNode.left;//when
            } else {
                currNode = currNode.right;
            }
            if (currNode == null) {
                System.out.println("no");
                return null;

            }
        }
        return currNode.value;
    }

    public void delete(K key){
        Node current = root;
        Node parent = root;
        int isLeftChild = 1;
        while (current.key != key) {
            parent = current;
            if (key.compareTo(current.key) < 0) {
                isLeftChild = 1;
                current = current.left;
            } else {
                isLeftChild = 0;
                current = current.right;
            }
            if (current == null){
                System.out.println("nothing to delete");
                return; //no such node
            }
        }
        //delete node if no child
        if (current.left == null & current.right == null) {
            if (current == root) {
                root = current.left;
            } else if(isLeftChild == 1){
                parent.left = null;
            } else {
                parent.right = null;
            }
        }
        //replace node by right if no left child
        else if (current.left == null) {
            if(current == root) {
                root = current.right;
            }
            else if (isLeftChild == 1) {
                parent.left = current.right;
            }
            else {
                parent.right = current.right;
            }
        }
        //same but if no right
        else if (current.right == null) {
            if(current == root) {
                root = current.left;
            }
            else if (isLeftChild == 1) {
                parent.left = current.left;
            }
            else {
                parent.right = current.left;
            }
        }
        size--;
        //if no both child?
    }

    public void print() { // метод для вывода дерева в консоль
        Stack globalStack = new Stack(); // общий стек для значений дерева
        globalStack.push(root);
        int gaps = 32; // начаное значение расстояния между элементами
        boolean isRowEmpty = false;
        String separator = "-----------------------------------------------------------------";
        System.out.println(separator);// черта для указания начала нового дерева
        while (isRowEmpty == false) {
            Stack localStack = new Stack(); // локальный стек для задания потомков элемента
            isRowEmpty = true;

            for (int j = 0; j < gaps; j++)
                System.out.print(' ');
            while (globalStack.isEmpty() == false) { // покуда в общем стеке есть элементы
                Node temp = (Node) globalStack.pop(); // берем следующий, при этом удаляя его из стека
                if (temp != null) {
                    System.out.print(temp.value); // выводим его значение в консоли
                    localStack.push(temp.left); // соохраняем в локальный стек, наследники текущего элемента
                    localStack.push(temp.right);
                    if (temp.left != null ||
                            temp.right != null)
                        isRowEmpty = false;
                }
                else {
                    System.out.print("__");// - если элемент пустой
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < gaps * 2 - 2; j++)
                    System.out.print(' ');
            }
            System.out.println();
            gaps /= 2;// при переходе на следующий уровень расстояние между элементами каждый раз уменьшается
            while (localStack.isEmpty() == false)
                globalStack.push(localStack.pop()); // перемещаем все элементы из локального стека в глобальный
        }
        System.out.println(separator);// подводим черту
    }

    public void printTree(Node root) {
        if(root!=null){
            printTree(root.left);
            System.out.print(" " + root.value);
            printTree(root.right);
        }
    }

//    public void delete(K key){
//        if(key == null){
//            throw new IllegalArgumentException("No element in the tree has a null key.");
//        }else{
//            root = delete(key,root);
//        }
//    }
//    private Node delete(K key, Node node){
//        assert (key != null) : "remove was passed a null key";
//        assert (node != null) : "remove was passed a null node";
//        if (node.isEmpty()) {
//            return node;
//        }else{
//            K temp = node.key;
//            if(key.equals(temp)){
//                if(!node.haLeft()){
//                    node = node.right;
//                }else if(!node.hasRight()){
//                    //the node we are at has no right subtree
//                    node = node.left;
//                }else{
//                    //the node has both left and right subtrees
//                    K temp2 = getMax(node.left).key;
//                    node.setKey(temp2);
//                    node.setLeft(delete(temp2,node.left));
//                }
//                size--;
//            }else if(key.compareTo(temp) <= 0){ //search the left subtree
//                node.setLeft(delete(key, node.left));
//            }else{                            //search the right subtree
//                node.setRight(delete(key, node.right));
//            }
//        }
//        return node;
//    }
//    protected Node getMax(Node node){
//        assert !node.isEmpty() : "getMax was passed a null node";
//        if(node.hasRight()){
//            return getMax(node.right);
//        }else{
//            return node;
//        }
//    }

//    public Iterable<K> iterator() {
//    }

}

