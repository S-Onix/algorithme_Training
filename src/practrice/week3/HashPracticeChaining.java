package src.practrice.week3;

import java.util.LinkedList;

public class HashPracticeChaining {
    static LinkedList<KeyPair>[] hashTable = new LinkedList[100];

    public static void init(){
        for(int i =0; i < hashTable.length; i++) {
            hashTable[i] = new LinkedList<KeyPair>();
        }
    }

    public static void put (String key, String value) {
        int hashIndex = key.hashCode() % hashTable.length;
        hashTable[hashIndex].add(new KeyPair(key, value));
    }

    public static String get (String key) {
        int hashIndex = key.hashCode() % hashTable.length;
        for (KeyPair keyPair : hashTable[hashIndex]) {
            if(keyPair.key.equals(key)) {
                return keyPair.value;
            }
        }

        return null;
    }

    static class KeyPair {
        String key;
        String value;

        KeyPair(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }
}
