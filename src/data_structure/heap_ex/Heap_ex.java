package data_structure.heap_ex;

import java.util.ArrayList;
import java.util.Collections;

public class Heap_ex {
    /**
     * 보통 힙을 구현할때에는 배열에 저장한다
     * - 속도적인 측면에서 빠르기 때문에
     * - 이진트리의 규칙이 아니기 때문에 새로운 값이 들어올때 가장 마지막 위치에 데이터를 넣어주면 된다.
     * */

    ArrayList<Integer> heapArray = null;

    public Heap_ex(Integer data) {
        heapArray = new ArrayList<>();

        heapArray.add(null);
        heapArray.add(data);
    }

    public boolean insert(Integer data) {
        if(heapArray == null) {
            heapArray = new ArrayList<>();

            heapArray.add(null);
            heapArray.add(data);
        }else {
            heapArray.add(data);
        }

        /**
         * 마지막 인덱스 번호와
         * 부모 인덱스 번호
         * */
        Integer insertedIdx, parentIdx;

        insertedIdx = this.heapArray.size()-1;

        /**
         * 순회해야하는지 확인하는 메소드가 필요하다.
         * */
        while(this.moveUp(insertedIdx)){
            parentIdx = insertedIdx / 2;
            Collections.swap(this.heapArray, insertedIdx, parentIdx);
            insertedIdx = parentIdx;
        }

        return true;
    }

    public boolean moveUp(Integer insertedIdx) {
        if (insertedIdx <= 1) {
            return false;
        }else {
            return this.heapArray.get(insertedIdx) > this.heapArray.get(insertedIdx/2);
        }
    }

    public Integer pop(){
        if(this.heapArray == null) {
            return null;
        }else {

        Integer popData = this.heapArray.get(1);
        this.heapArray.set(1, this.heapArray.get(this.heapArray.size()-1));
        this.heapArray.remove(this.heapArray.size()-1);

        Integer poppedIdx = 1;
        Integer leftIdx, rightIdx;

        while(this.moveDown(poppedIdx)) {
            /**
             * 오른쪽 자식 노드만 있는지 확인해보면됨
             * */
            leftIdx = poppedIdx * 2;
            rightIdx = poppedIdx * 2 + 1;

            /**
             * 왼쪽 자식만 있는 경우
             * */
            if(rightIdx >= this.heapArray.size()) {
                Collections.swap(this.heapArray, leftIdx, poppedIdx);
                poppedIdx = leftIdx;
                // 자식이 두개인 경우
            }else {
                if(this.heapArray.get(leftIdx) > this.heapArray.get(rightIdx)) {
                    /**
                     * 왼쪽이 더 크므로 왼쪽 노드의 값을 부모로 끌어올리고 팝 인덱스를 변경시켜준다.
                     * */
                    Collections.swap(this.heapArray,leftIdx, poppedIdx);
                    poppedIdx = leftIdx;
                }else {
                    Collections.swap(this.heapArray, rightIdx, poppedIdx);
                    poppedIdx = rightIdx;
                }
            }
        }

        return popData;
        }
    }

    public boolean moveDown(Integer popedIdx){
        Integer leftChildPopedIdx, rightChildPopedIdx;

        leftChildPopedIdx = popedIdx * 2;
        rightChildPopedIdx = popedIdx * 2 + 1;

        /**
         * 왼쪽 자식 노드가 없을 경우
         * */
        if(leftChildPopedIdx >= this.heapArray.size()) {
            return false;
        /**
         * 왼쪽 자식 노드만 있는 경우
         * */
        }else if (rightChildPopedIdx >= this.heapArray.size()) {
            if(this.heapArray.get(popedIdx) < this.heapArray.get(leftChildPopedIdx)){
                return true;
            }else {
                return false;
            }
        /**
         * 자식 노드가 둘인 경우
         *  - 현재 위치의 노드 값이 자식 노드들보다 큰 경우 false
         *  - 그렇지 않는 경우 true;
         * */
        }else {
            if(this.heapArray.get(popedIdx) > this.heapArray.get(leftChildPopedIdx)
                    && this.heapArray.get(popedIdx) > this.heapArray.get(rightChildPopedIdx)){
                return false;
            }else {
                return true;
            }
        }
    }

    public static void main(String[] args) {
        Heap_ex heapTest = new Heap_ex(15);
        heapTest.insert(10);
        heapTest.insert(8);
        heapTest.insert(5);
        heapTest.insert(4);
        heapTest.insert(20);
        System.out.println(heapTest.heapArray);

        heapTest.pop();
        System.out.println(heapTest.heapArray);


        heapTest.pop();
        System.out.println(heapTest.heapArray);

        heapTest.pop();
        System.out.println(heapTest.heapArray);
    }


}
