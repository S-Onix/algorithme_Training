package data_structure.hashTable_ex;

public class Hash_ex {
    public Slot[] hashTable;

    public Hash_ex(Integer size) {
        this.hashTable = new Slot[size];
    }

    public class Slot {
        String value;
        Slot(String value) {
            this.value = value;
        }
    }

    public Integer hashFunction(String value){
        return (int)(value.charAt(0)) % this.hashTable.length;
    }

    public static void main(String[] args) {
        String name = "S-Onix";
        int a = (int)(name.charAt(0));
    }
}
