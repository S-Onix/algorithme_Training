package src.practrice.week2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * */
public class JosephusProblem {

    public static void main(String[] args) {
        solve2(7,3);

    }

    public static void solve2(int member, int removeCnt) {
        List<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int currIndex = removeCnt - 1;

        for(int i = 1; i <= member; i++) {
            list.add(i);
        }
        /**
         * result = people_arr.pop(next_index)
         * result_arr.append(result)
         * if len(people_arr) != 0:
         *     next_index = (next_index + (k - 1)) % len(people_arr)
         * */

        while(!list.isEmpty()) {
            Integer popData = list.get(currIndex);
            list.remove(currIndex);

            sb.append(popData);
            sb.append(",");

            if(!list.isEmpty()) {
                currIndex = (currIndex + removeCnt - 1) % list.size();
            }
        }
        sb.delete(sb.length()-1, sb.length());
        System.out.println(sb.toString());
    }

    public static void solve(int member, int removeCnt) {
        LinkedList<Integer> list = new LinkedList<>();
        StringBuilder sb= new StringBuilder();
        int currIndex = removeCnt - 1;
        for(int i = 1; i <= member; i++) {
            list.append(i);
        }

        while(list.getSize() != 0) {
            Node<Integer> node;
            if(list.getSize() == 1) {
                node = list.findNode(0);
                sb.append(node.getValue());
                break;
            }else {
                node = list.findNode(currIndex);
            }

            sb.append(node.getValue());
            sb.append(",");

            list.delete(currIndex);

            if((currIndex + removeCnt) < list.getSize()) {
                currIndex = currIndex + removeCnt - 1;
            }else {
                currIndex = Math.abs((list.getSize()) - (currIndex + removeCnt - 1));
            }
            System.out.println("list size :: " + list.getSize() + " / currIndex :: " + currIndex);
        }

        System.out.println(sb.toString());

        /**
         * 초기 커서의 위치는 removeCnt -1
         * 해당 위치 노드 제거
         * 커서의 위치 - 1 + removeCnt
         *    - 커서의 위치가 리스트의 사이즈보다 작은 경우
         *        - 커서 위치에 있는 노드 제거 >> 커서 위치 - 1
         *    - 커서의 위치가 리스트의 사이즈보다 큰 경우
         *        - (사이즈 - 커서의 위치 - 1 + removeCnt) 절대값 을 커서 위치로 재 조정
         * 리스트의 사이즈가 0이 아니면 계속 반복
         * */


    }
}
