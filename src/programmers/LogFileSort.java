package programmers;

import java.util.Collections;
import java.util.LinkedList;

public class LogFileSort {
    public String[] solution(String[] logs) {
        // 여기에 코드를 작성하세요
        /**
         * 로그는 식별자 + 내용으로 구성된다.
         * 내용은 숫자 혹은 소문자로 구성된다.
         * 내용이 소문자로 구성된 것들이 먼저 출력되야한다.
         * 내용의 인자 값의 크기가 같을 때에는 먼저 입력된 값을 먼저 출력한다.
         * */

        LinkedList<String> numberLogList = new LinkedList<>();
        LinkedList<String> stringLogList = new LinkedList<>();
        LinkedList<String> resultList = new LinkedList<>();

        for(int i = 0 ; i < logs.length; i++) {
            String content = logs[i].split(" ", 2)[1];
            if(Character.isDigit(content.charAt(0))) {
                numberLogList.add(logs[i]);
            }else {
                stringLogList.add(logs[i]);
            }
        }

        stringLogList.sort((a, b) -> {
            String[] pa = a.split(" ", 2);
            String[] pb = b.split(" ", 2);

            int cmp = pa[1].compareTo(pb[1]);
            return cmp != 0 ? cmp : pa[0].compareTo(pb[0]);
        });

        stringLogList.addAll(numberLogList);

        return stringLogList.toArray(new String[0]);
    }
}
