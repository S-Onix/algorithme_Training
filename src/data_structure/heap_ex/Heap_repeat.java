package data_structure.heap_ex;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Heap_repeat {

    ArrayList<Integer> heapArray = null;

    public Heap_repeat(Integer data) {
        heapArray = new ArrayList<>();

        heapArray.add(null);
        heapArray.add(data);
    }

    /**
     * 마지막 위치에 데이터를 넣어준다.
     * */
    public boolean insert(Integer data){
        if(this.heapArray == null) {
            heapArray = new ArrayList<>();
            heapArray.add(null);
            heapArray.add(data);
        } else {
            heapArray.add(data);
        }

        Integer searchIdx, parentIdx;
        searchIdx = this.heapArray.size() - 1 ;
        while(this.isMoveUp(searchIdx)) {
            parentIdx = searchIdx / 2;
            Collections.swap(this.heapArray, searchIdx, parentIdx);
            searchIdx = parentIdx;
        }
        return true;
    }

    /**
     * 마지막에서 올라가며 변겨할지 여부를 확인한다.
     * */
    public boolean isMoveUp(Integer chkIndex){
        if(chkIndex >= 1) {
            return false;
        }else {
            return this.heapArray.get(chkIndex) > this.heapArray.get(chkIndex / 2);
        }
    }

    /**
     * 첫번쨰 인덱스의 값을 가져온다.
     * */
    public Integer pop(){
        if(this.heapArray.size() <= 1) {
            return null;
        }else {
            Integer poppedData = this.heapArray.get(1);
            this.heapArray.set(1, this.heapArray.get(this.heapArray.size()-1));
            this.heapArray.remove(this.heapArray.size()-1);

            Integer poppedIdx = 1;

            while(isMoveDown(poppedIdx)){
                Integer leftChildIndex, rightChildIndex;
                leftChildIndex = poppedIdx * 2;
                rightChildIndex = poppedIdx * 2 + 1;

                if(rightChildIndex >= this.heapArray.size()){
                    Collections.swap(this.heapArray, leftChildIndex, poppedIdx);
                    poppedIdx = leftChildIndex;
                }else {
                    if(this.heapArray.get(leftChildIndex) > this.heapArray.get(rightChildIndex)){
                        Collections.swap(this.heapArray, leftChildIndex, poppedIdx);
                        poppedIdx = leftChildIndex;
                    }else {
                        Collections.swap(this.heapArray, rightChildIndex, poppedIdx);
                        poppedIdx = rightChildIndex;
                    }
                }
            }

            return poppedData;
        }

    }

    public boolean isMoveDown(Integer chkIndex){
        /**
         * 왼쪽 자식의 인덱스번호가 배열의 크기보다 클떄 (마지막위치라는 소리)
         * 왼쪽 자식 노드만 있는 경우
         * 자식 노드가 두개인 경우
         * */
        Integer leftChildIndex, rightChildIndex;

        leftChildIndex = chkIndex * 2;
        rightChildIndex = chkIndex * 2 + 1;

        if(leftChildIndex >= this.heapArray.size()){
            return false;
        }else if (rightChildIndex >= this.heapArray.size()){
            if(this.heapArray.get(chkIndex) > this.heapArray.get(leftChildIndex)){
                return true;
            }else {
                return false;
            }
        }else {
            if (this.heapArray.get(chkIndex) > this.heapArray.get(leftChildIndex) && this.heapArray.get(chkIndex) > this.heapArray.get(rightChildIndex)) {
                return false;
            } else {
                return true;
            }
        }
    }

    public static void main(String[] args) {
        Heap_repeat heapTest = new Heap_repeat(15);
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
