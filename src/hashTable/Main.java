package hashTable;

public class Main {
    public static void main(String[] args) {
        MyHT<String,Integer> HT = new MyHT<>();
        HT.put("alisher",1 );
        HT.put("aruzhan",1 );
        HT.put("zhuldyz",2 );
        HT.put("aiaru",3 );
        HT.put("gulden",4 );
        HT.put("zhansaya",4 );
        HT.put("agai", 5);

        HT.get("alisher");
        HT.get("aruzhan");
        HT.isEmpty();
        HT.hashSize();
        HT.remove("this");
        HT.remove("alisher");
        HT.hashSize();
    }
}
