package data_structure.hashTable_ex;

public class Hash_Chaining_ex2 {
    /**
     * 데이터 저장 공간 확보
     * 데이터 타입 확보
     */
    Slot[] hashTable;

    public Hash_Chaining_ex2(int size) {
        hashTable = new Slot[size];
    }

    public int hash_function(String key) {
        return (int) key.charAt(0) % this.hashTable.length;
    }


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

    /**
     * 충돌 발생시 링크드리스트기법을 사용하여 다음 데이터에 저장
     */
    public boolean saveData(String key, String value) {
        int address = hash_function(key);

        if (this.hashTable[address] != null) {
            if (this.hashTable[address].key == key) {
                this.hashTable[address].value = value;
            } else {
                /**
                 * 키를 찾아 순회한다.
                 * 키가 없으면 가장 마지막에 데이터를 추가해준다.
                 * */
                Slot currentSlot = this.hashTable[address].next;
                Slot prevSlot = this.hashTable[address].next;

                while (currentSlot != null) {
                    if (currentSlot.key == key) {
                        currentSlot.value = value;
                        return true;
                    } else {
                        prevSlot = currentSlot;
                        currentSlot = currentSlot.next;
                    }
                }
                prevSlot.next = new Slot(key, value);
            }
        } else {
            this.hashTable[address] = new Slot(key, value);
        }
        return true;
    }

    public String getData(String key) {
        int address = hash_function(key);
        if(this.hashTable[address] != null) {
            Slot currentSlot = this.hashTable[address];
            while(currentSlot != null) {
                if(currentSlot.key == key) {
                    return currentSlot.value;
                }else {
                    currentSlot = currentSlot.next;
                }
            }
            return null;
        }else{
            return null;
        }
    }


}
