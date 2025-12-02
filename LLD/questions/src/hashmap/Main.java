package hashmap;

public class Main {
    static void main() {
        MyHashMap<String, Integer> myHashMap = new MyHashMap<>();

        myHashMap.put("sandipan", 23);
        myHashMap.put("susama", 87);

        System.out.println(myHashMap.get("sandipan"));
        System.out.println(myHashMap.get("sarbani"));
        System.out.println(myHashMap.get("susama"));

        myHashMap.put("susama", 90);
        System.out.println(myHashMap.get("susama"));

        myHashMap.remove("susama");
        System.out.println(myHashMap.get("susama"));

    }
}
