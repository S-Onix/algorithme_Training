package data_structure.hashTable_ex;

public class Hash_Linear_Probing_while {
    Slot[] hashTable;

    public Hash_Linear_Probing_while(int size) {
        hashTable = new Slot[size];
    }

    public class Slot {
        String key;
        String value;

        public Slot(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    public int hashFunction(String key) {
        return (int) (key.charAt(0)) % this.hashTable.length;
    }

    public boolean saveData(String key, String value) {
        int address = hashFunction(key);

        if (this.hashTable[address] != null) {
            if (this.hashTable[address].key == key) {
                this.hashTable[address].value = value;
                return true;
            } else {
                Integer currentAddress = address + 1;
                while (this.hashTable[currentAddress] != null) {
                    if (this.hashTable[currentAddress].key == key) {
                        this.hashTable[currentAddress].value = value;
                        return true;
                    } else {
                        currentAddress ++;
                        if (currentAddress >= this.hashTable.length) {
                            return false;
                        }
                    }
                }
                this.hashTable[currentAddress] = new Slot(key, value);
                return true;
            }
        } else {
            this.hashTable[address] = new Slot(key, value);
        }

        return true;
    }

    public String getData(String key) {
        int address = hashFunction(key);

        if(this.hashTable[address] != null) {
            while(this.hashTable[address] != null) {
                if(this.hashTable[address].key == key) {
                    return this.hashTable[address].value;
                }else {
                    address ++;
                    if(address >= this.hashTable.length) {
                        return null;
                    }
                }
            }
            return null;
        }else {
            return null;
        }
    }


}
