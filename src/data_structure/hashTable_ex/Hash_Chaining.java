package data_structure.hashTable_ex;

public class Hash_Chaining {
    public Slot[] hashTable;

    public Hash_Chaining(int size) {
        this.hashTable = new Slot[size];
    }

    // 링크드리스트 기법을 사용하기 위해 next 라는 Slot  변수가 추가됨
    // key 값을 넣음으로서 데이터를 찾기에 용이해짐
    public class Slot {
        String key;
        String value;
        Slot next;

        public Slot(String key, String value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    public int hash_function(String key) {
        return (int) (key.charAt(0)) % this.hashTable.length;
    }

    // 데이터 저장을 위해서는 링크드 리스트 순회 검색 작업이 필요하다.
    // Slot의 key 값을 통해 데이터의 일치 여부 판단
    public boolean saveData(String key, String value) {
        int address = hash_function(key);
        if (this.hashTable[address] != null) {
            Slot findSlot = this.hashTable[address];
            Slot prevSlot = this.hashTable[address];

            while (findSlot != null) {
                if (findSlot.key == key) {
                    findSlot.value = value;
                    return true;
                } else {
                    prevSlot = findSlot;
                    findSlot = findSlot.next;
                }
            }
            prevSlot.next = new Slot(key, value);

        } else {
            this.hashTable[address] = new Slot(key, value);
        }
        return true;
    }

    public String getData(String key) {
        int address = hash_function(key);
        if (this.hashTable[address] != null) {
            if (this.hashTable[address].key == key) {
                return this.hashTable[address].value;
            } else {
                Slot findSlot = this.hashTable[address];

                while (findSlot != null) {
                    if (findSlot.key == key) {
                        return findSlot.value;
                    } else {
                        findSlot = findSlot.next;
                    }
                }

                return null;
            }
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        Hash_Chaining mainObject = new Hash_Chaining(30);
        mainObject.saveData("Yoo", "01099992222");
        mainObject.saveData("Qoo", "01022222222");
        mainObject.saveData("Koo", "01066662222");
        mainObject.saveData("You", "01021322222");
        mainObject.saveData("Yok", "01084292222");


        System.out.println(mainObject.getData("Yok"));
    }

}
