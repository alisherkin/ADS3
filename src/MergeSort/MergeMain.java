package MergeSort;

public class MergeMain {

    public static void main(String[] args)
    {

        Integer[] items = {5, 16, 14, 6, 7, 11, 9, 12};

        Merge<Integer> mergeSort = new Merge<>(items);
        mergeSort.sort();

        for (Integer i : mergeSort.getSortedItems()) {
            System.out.print(i + " ");
        }
    }

}
