package src.practrice.week3;

public class HashPractice {
    static String [] hashTable = new String[100];

    public static void main(String[] args) {
        put("과일", "사과");
        put("이름", "이르음");

        System.out.println(get("과일"));

    }

    public static void put (String key, String value) {
        System.out.println("key의 해시코드 : " + key.hashCode());

        int hashIndex = key.hashCode() % hashTable.length;
        System.out.println("hash Index : " + hashIndex);
        hashTable[hashIndex] = value;
    }

    public static String get(String key) {
        int hashIndex = key.hashCode() % hashTable.length;
        return hashTable[hashIndex];
    }

}
