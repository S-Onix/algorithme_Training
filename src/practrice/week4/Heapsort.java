package src.practrice.week4;

import java.util.ArrayList;
import java.util.List;

public class Heapsort {
    /***
     * 데이터가 추가되면 가장 마지막에 저장된다
     * 최대힙 : 부모는 자식보다 큰 값을 유지해야한다.
     * 최소힙 : 부노믄 자식보다 작은 값을 유지해야한다
     *
     * 루트노드는 최대값 혹은 최소값이 된다.
     */

    public static class MaxHeap {
        ArrayList<Integer> heap;
        public MaxHeap() {
            heap = new ArrayList<>();
            heap.add(null);
        }

        public void insert(int x) {
            heap.add(x);
            int currentIndex = heap.size() - 1;
            while (currentIndex != 1) {
                int parentIndex = currentIndex / 2;
                if(heap.get(currentIndex) < heap.get(parentIndex)) {
                    break;
                }else {
                    int temp = heap.get(currentIndex);
                    heap.set(currentIndex, heap.get(parentIndex));
                    heap.set(parentIndex, temp);
                    currentIndex = parentIndex;
                }
            }
        }

        public Integer pop(){
            int popData = heap.get(1);

            /**
             * 정렬해야함
             * 처음데이터를 마지막으로 보낸다
             * 맨 마지막 데이터를 가장 앞으로 보낸다
             * 자식 데이터들과 비교하여 더 큰 데이터와 바군다.
             * 자식 데이터가 자신보다 작을때까지 비교한다.
             * */

            int temp = heap.get(1);
            heap.set(1, heap.getLast());
            heap.set(heap.size()-1, temp);
            heap.removeLast();

            int currentIndex = 1;
            int leftChildIndex = currentIndex * 2;
            int rightChildIndex = currentIndex * 2 + 1;

            while(currentIndex < heap.size() && leftChildIndex < heap.size() && rightChildIndex < heap.size()) {
                int tempValue = heap.get(currentIndex);

                if(heap.get(currentIndex) < heap.get(rightChildIndex) || heap.get(rightChildIndex) < heap.get(leftChildIndex)) {
                    if(heap.get(rightChildIndex) < heap.get(leftChildIndex)) {
                        heap.set(currentIndex, heap.get(leftChildIndex));
                        heap.set(leftChildIndex, tempValue);
                        currentIndex = leftChildIndex;
                    }else {
                        heap.set(currentIndex, heap.get(rightChildIndex));
                        heap.set(rightChildIndex, tempValue);
                        currentIndex = rightChildIndex;
                    }
                    leftChildIndex = currentIndex * 2;
                    rightChildIndex = currentIndex * 2 + 1;
                }else {
                    break;
                }

            }
            int tempValue = heap.get(currentIndex);
            int tempIndex = 1;
            if(heap.size()-1 == currentIndex*2) {
                tempIndex = currentIndex*2;
                if(heap.get(currentIndex) < heap.get(tempIndex)) {
                    heap.set(tempIndex, heap.get(currentIndex));
                    heap.set(leftChildIndex, tempValue);
                }
            }else if(heap.size()-1 == currentIndex*2+1) {
                tempIndex = currentIndex*2+1;
                if(heap.get(currentIndex) < heap.get(tempIndex)) {
                    heap.set(tempIndex, heap.get(currentIndex));
                    heap.set(leftChildIndex, tempValue);
                }
            }

            return popData;
        }

        public List<Integer> getHeap() {
            return heap;
        }
    }




    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap();

        maxHeap.insert(1);
        maxHeap.insert(2);
        maxHeap.insert(3);
        maxHeap.insert(4);
        maxHeap.insert(5);
        maxHeap.insert(6);
        maxHeap.insert(7);
        maxHeap.insert(8);

        System.out.println(maxHeap.getHeap());
        maxHeap.pop();
    }

}
