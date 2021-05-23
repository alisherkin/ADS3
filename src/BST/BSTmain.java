package BST;

public class BSTmain {
    public static void main(String[] args) {
        BST tree = new BST();
        // вставляем узлы в дерево:
        tree.put(171, "Alisher");
        tree.put(182, "Alishka");
        tree.put(175, "Dos");
        tree.put(160, "Anara");
        tree.put(178, "Assyl");
        tree.put(168, "Damindr");
        tree.put(169, "Acidic");
        tree.put(190, "Chinitos");
        tree.put(165, "Anelek");
        tree.put(150, "Poltorashka");
        // отображение дерева:
        tree.get(160);
        tree.printTree(tree.root);
        tree.print();
        System.out.println("_____________________");
        tree.delete(175);
        tree.printTree(tree.root);
        tree.print();

    }
}
