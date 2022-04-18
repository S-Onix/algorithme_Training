package programmers;

import java.util.*;

public class Printer {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        LinkedList<PrintContent> waitingQueue = new LinkedList<PrintContent>();
        LinkedList<Integer> priorityList = new LinkedList<Integer>();
        ArrayList<PrintContent> savePrintList = new ArrayList<PrintContent>();

        for(int i =0 ; i < priorities.length; i++) {
            waitingQueue.add(new PrintContent(i, priorities[i]));
            priorityList.add(priorities[i]);
        }

        Collections.sort(priorityList);
        Collections.reverse(priorityList);

        int cnt= 0;
        while(!priorityList.isEmpty()){
            int targetPriority = priorityList.poll();
            while(!waitingQueue.isEmpty()){
                PrintContent p = waitingQueue.poll();
                if(targetPriority == p.priority) {
                    cnt += 1;
                    p.cnt = cnt;
                    savePrintList.add(p);
                    break;
                }else {
                    waitingQueue.add(p);
                }
            }
        }

        for(PrintContent p : savePrintList) {
            if(p.index == location) {
                answer = p.cnt;
                break;
            };
        }

        return answer;
    }

    static class PrintContent{
        int cnt;
        int index;
        int priority;

        public PrintContent(int index, int priority) {
            this.index=index;
            this.priority = priority;
        }
    }
}
