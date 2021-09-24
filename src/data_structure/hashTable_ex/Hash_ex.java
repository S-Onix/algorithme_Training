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
 * 해시테이블의 단점으로는 저장공간이 많이 필요하고 충돌이 자주 발생할 수 있다. (주소가 동일한 경우)
 * 충돌을 해결하기 위한 별도의 자료구조가 필요하다.
 *
 * 해시테이블의 주요 용도
 * 1. 검색이 많이 필요한 경우
 * 2. 저장, 삭제, 읽기가 빈번한 경우
 * 3. 캐쉬 구현시(중복 확인이 쉽기 때문에 >> 검색 속도가 빠르기 때문에)
 *
 * 충돌(Collision) / 해쉬 충돌(hash Collision) 해결 알고리즘
 * 1. Chaining 기법
 *      - 개방 해슁 또는 Open Hashing 기법 :  해시 테이블 저장공간 외의 공간을 활용하는 기법
 *      - 충돌이 발생시 링크드 리스트라는 자료 구조를 사용해서, 링크드 리스트로 데이터를 추가로 뒤에 연결시켜 저장하는 기법
 *
 * 2. Linear Probing 기법
 *      - Close Hasing 기법 중 하나 : 해쉬 테이블 저장공간 안에서 충돌 문제를 해결하는 기법
 *      - 충돌 발생시 해당 hash address의 다음 address 부터 맨 처음 나오는 빈공간에 저장하는 기법
 *          - 저장 활용도를 높이기 위한 기법 >> for loop 사용할 듯함.
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

    // 해당 주소에 데이터(Slot)이 있는지 먼저 확인이 필요하다.
    public boolean saveData(String key, String value) {
        int address = hash_function(key);
        if (this.hashTable[address] != null ) {
            this.hashTable[address].value = value;
        }else {
            this.hashTable[address] = new Slot(value);
        }
        return true;
    }

    public String getData(String key) {
        int address = hash_function(key);
        if (this.hashTable[address] != null) {
            return this.hashTable[address].value;
        }else{
            return null;
        }
    }

    public static void main(String[] args) {
        Hash_ex mainObject = new Hash_ex(30);
        mainObject.saveData("Yoo", "01099992222");
        mainObject.saveData("Koo", "01066662222");
        mainObject.saveData("Qoo", "01022222222");

        System.out.println(mainObject.getData("Koo"));

    }
}
