package programmers;

import java.util.ArrayList;
import java.util.LinkedList;

public class FunctionDevelop {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> result= new ArrayList<Integer>();
        LinkedList<Integer> queue = new LinkedList<Integer>();

        for(int i = 0; i < progresses.length; i++) {
            if((100-progresses[i])%speeds[i] == 0) {
                queue.add((100-progresses[i])/speeds[i]);
            } else {
                queue.add((100-progresses[i])/speeds[i]+1);
            }
        }

        int standard = queue.get(0);
        int completeCnt=0;

        while(!queue.isEmpty()){
            int target = queue.poll();
            if(target <= standard) completeCnt++;
            else{
                queue.addFirst(target);
                standard = queue.get(0);
                result.add(completeCnt);
                completeCnt = 0;
            }
        }
        result.add(completeCnt);

        int[] answer = new int[result.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i]=result.get(i);
        }
        return answer;
    }
}
