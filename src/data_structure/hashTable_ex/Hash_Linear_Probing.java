package data_structure.hashTable_ex;
/**
 * 패쇄 해싱 기법 >> 기준 주소 이후 비어있는 곳을 찾아 데이터를 넣어준다.
 * 충돌을 줄이기 위해서 해시함수를 개선하는 방법도 존재한다.
 *
 * */


public class Hash_Linear_Probing {
    Slot[] hashTable;

    public Hash_Linear_Probing(int size) {
        this.hashTable = new Slot[size];
    }

    public class Slot{
        String key;
        String value;

        public Slot(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    public int hash_function(String key) {
        return (int) (key.charAt(0)) % this.hashTable.length;
    }

    public boolean saveData(String key, String value) {
        int address = hash_function(key);

        if(this.hashTable[address] != null) {
            /**
             * hashTable이 비어있는 곳까지 찾아야함
             * 문제점 : 만약 전부다 차있다면 어떻게 할것인가?
             * Lifo? Fifo?
             * */
            for(int i = address; i < this.hashTable.length; i++) {
                if(this.hashTable[i] == null) {
                    this.hashTable[i] = new Slot(key, value);
                    return true;
                }

                if(this.hashTable[i].key == key) {
                    this.hashTable[i].value = value;
                    return true;
                }
            }
            // 전부다 차있는경우에는 어떻게 할것인가?
            return false;
        }else {
            this.hashTable[address] = new Slot(key, value);
        }
        return true;
    }

    public String getData(String key) {
        int address = hash_function(key);
        if(this.hashTable[address] != null) {
            for(int i = address; i < this.hashTable.length ; i++) {
                if(this.hashTable[i] == null) {
                    return null;
                }


                if(this.hashTable[i].key == key) {
                    return this.hashTable[i].value;
                }
            }
            return null;
        }else {
            return null;
        }
    }

    public static void main(String[] args) {
        Hash_Linear_Probing ex = new Hash_Linear_Probing(5);
        System.out.println(ex.saveData("Bou", "1"));
        System.out.println(ex.saveData("Bok", "2"));
        System.out.println(ex.saveData("Aoe", "21"));
        System.out.println(ex.saveData("Boz", "3"));
        System.out.println(ex.saveData("Boe", "4"));


        System.out.println(ex.getData("Aoe"));
        System.out.println(ex.getData("Bou"));
        System.out.println(ex.getData("Boz"));
        System.out.println(ex.getData("Bok"));
        System.out.println(ex.getData("Boe"));



    }

}
