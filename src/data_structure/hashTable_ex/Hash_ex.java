package data_structure.hashTable_ex;

/**
 * 목표 : Hash Table 개념 이해하기
 *
 * 키 - 벨류  구조로 이루어져 있음
 * hash_function 로 데이터 저장 위치를 찾아 hash_table(데이터 공간)에 저장한다.
 * hash_function : 데이터를 저장(검색) 할 수 있는 주소를 반환한다 (별도 로직이 존재  >>  별도의 메서드가 있어야함을 의미)
 *
 * key를 통해 데이터가 저장되어 있는 주소를 바로 알 수 있으므로, 저장 및 탐색 속도가 획기적으로 빠르다.
 *
 * 1. 데이터를 저장 반환 할 수 있는 데이터 공간을 미리 확보
 * 2. hash_function 을 정책에 맞춰 제작
 * 3. key를 hash_function의 파라미터로 넣은 후 데이터의 주소를 찾아 해당 위치에 저장 및 탐색한다.
 *
 * */

public class Hash_ex {

    // 1. 데이터를 저장 및 반환 할 수 있는 데이터 공간을 만든다 (용어는 Slot)
    public Slot[] hashTable;

    
    // Slot의 사이즈 지정(추후 사이즈 변경 불가능)
    public Hash_ex(Integer size){
        this.hashTable = new Slot[size];
    }

    // Slot 은 String value 데이터만 저장 가능하다. (템플릿 타입으로 변환시 다양한 데이터 저장 가능)
    public class Slot{
        String value;
        Slot(String value) {
            this.value = value;
        }
    }

    // Key 가 문자열일 때, 문자열의 앞 글자를 숫자로 변환해서, Division 기법을 사용하여, Key에 대한 주소(인덱스 번호) 계산
    public int hash_function(String key){
        return (int)(key.charAt(0)) % this.hashTable.length;
    }

    public boolean saveData(String key, String value) {
        int address = hash_function(key);
        if (this.hashTable[address] != null ) {
            this.hashTable[address].value = value;
        }else {
            this.hashTable[address] = new Slot(value);
        }

        return true;
    }

    public static void main(String[] args) {

    }
}
